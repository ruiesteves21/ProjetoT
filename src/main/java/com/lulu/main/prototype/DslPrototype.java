package com.lulu.main.prototype;

import com.lulu.main.java.models.configurations.ReporterConfiguration;
import com.lulu.main.java.models.dsl.DslParser;
import com.lulu.main.java.models.monitors.CpuMonitor;
import com.lulu.main.java.models.monitors.MemoryMonitor;
import com.lulu.main.java.models.monitors.MetricMonitor;
import com.lulu.main.java.models.monitors.Monitors;
import com.lulu.main.java.models.use_cases.UseCases;

import java.io.IOException;
import java.util.Arrays;

public class DslPrototype {
    public static void main(String[] args) throws IOException, InterruptedException {
        String pathToYaml = "C:\\Users\\ruesteves\\Documents\\GitHub\\LuluPerfTest\\src\\main\\java\\com\\lulu\\main\\prototype\\DslPrototype.yml";
        DslParser parser = new DslParser(pathToYaml, pathToYaml);
        UseCases useCases = parser.useCases;
        parser.run();


        // Define monitors
        ReporterConfiguration reporterConfiguration = new ReporterConfiguration();
        MemoryMonitor memoryMonitor = new MemoryMonitor("Memory", 500, reporterConfiguration);
        CpuMonitor cpuMonitor = new CpuMonitor("CPU", 500, reporterConfiguration);
        MetricMonitor[] metricMonitors = {memoryMonitor, cpuMonitor};
        Monitors monitors = new Monitors(Arrays.asList(metricMonitors));

        monitors.start();
        useCases.start();

        /*
        for (UseCase useCase : useCases.getUseCases()) {
            loadTest(useCase);
        }*/
        monitors.stopMonitoring();
    }

}


