package com.lulu.main.java.models.dsl;

import com.lulu.main.java.models.configurations.ReporterConfiguration;
import com.lulu.main.java.models.monitors.*;
import com.lulu.main.java.models.use_cases.UseCase;
import com.lulu.main.java.models.use_cases.UseCases;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DslParser {
    private final String pathToAuxYaml;
    public Monitors monitors;
    public UseCases useCases;
    public ReporterConfiguration reporterConfiguration;

    public DslParser(String pathToYaml, String pathToAuxYaml) {
        this.pathToAuxYaml = pathToAuxYaml;
        Yaml yaml = new Yaml(new Constructor(Map.class));
        try (InputStream inputStream = new FileInputStream(pathToYaml)) {
            Map<String, Object> script = yaml.load(inputStream);
            buildTest(script);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() throws InterruptedException {
        this.monitors.start();
        this.useCases.start();
        while (this.useCases.isRunning()) {
            Thread.sleep(10000);
        }
        this.monitors.stopMonitoring();
    }


    private void buildTest(Map<String, Object> script) {

        Map<String, Object> performanceTest = (Map<String, Object>) script.get("Performance Test");

        Map<String, Object> reporterConfigMap = (Map<String, Object>) performanceTest.get("reporterConfiguration");
        this.reporterConfiguration = buildReporterConfiguration(reporterConfigMap);

        Map<String, Object> useCasesMap = (Map<String, Object>) performanceTest.get("User Group");
        List<Map<String, Object>> useCasesList = (List<Map<String, Object>>) useCasesMap.get("useCases");

        ArrayList<UseCase> useCases = new ArrayList<>();
        useCasesList.forEach(uc -> {
            try {
                useCases.add(buildUseCase(uc));
            } catch (MalformedURLException | FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        List<Map<String, Object>> monitorsMap = (List<Map<String, Object>>) performanceTest.get("Monitors");
        ArrayList<Map<String, Object>> monitorList = new ArrayList<>(monitorsMap);
        ArrayList<MetricMonitor> metricMonitors = new ArrayList<>();
        monitorList.forEach(m -> metricMonitors.add(buildMonitor(m)));

        this.useCases = new UseCases(useCases);
        this.monitors = new Monitors(metricMonitors);
    }

    private UseCase buildUseCase(Map<String, Object> useCaseMap) throws MalformedURLException, FileNotFoundException {
        Yaml yaml = new Yaml(new Constructor(Map.class));
        InputStream auxInputStream = new FileInputStream(pathToAuxYaml);
        Map<String, Object> scriptAux = yaml.load(auxInputStream);

        String name = (String) useCaseMap.get("name");
        int intThreadCount = (int) useCaseMap.get("threads");

        String scriptPath = "";
        String command = "";
        List<Map<String, Object>> auxComandosList = (List<Map<String, Object>>) scriptAux.get("aux_comando");
        for (Map<String, Object> auxComando : auxComandosList) {
            if (name.equals(auxComando.get("name"))) {
                command = (String) auxComando.get("command");
                scriptPath = (String) auxComando.get("script");
                break;
            }
        }
        return new UseCase(name, scriptPath, command, intThreadCount);
    }


    private ReporterConfiguration buildReporterConfiguration(Map<String, Object> configMap) {
        ReporterConfiguration reporterConfig = new ReporterConfiguration();
        if (configMap.containsKey("reportType")) {
            String reportTypeString = (String) configMap.get("reportType");
            reporterConfig.setReportType(reportTypeString);
        }
        return reporterConfig;
    }

    private MetricMonitor buildMonitor(Map<String, Object> monitorMap) {
        String name = (String) monitorMap.get("name");
        Integer stringInterval = (Integer) monitorMap.get("every");
        int interval = Integer.parseInt(String.valueOf(stringInterval));
        switch (name) {
            case "Memory":
                return new MemoryMonitor(name, interval, this.reporterConfiguration);
            case "CPU":
                return new CpuMonitor(name, interval, this.reporterConfiguration);
            case "disk":
                String dirToMonitor = (String) monitorMap.get("directory");
                return new DiskSpaceMonitor(name, interval, this.reporterConfiguration, dirToMonitor);
            default:
                throw new IllegalArgumentException("Unknown monitor type: " + name);
        }
    }

}