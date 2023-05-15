package com.lulu.main.java.models.reporters;

import com.lulu.main.java.models.configurations.ReporterConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class MonitorOutputTransceiver {
    public ReporterConfiguration reporterConfig;
    public ArrayList<MonitorOutputSignal> signals;
    public ArrayList<MonitorOutputDataAdapter> adapters = new ArrayList<>();

    public MonitorOutputTransceiver(ReporterConfiguration reporterConfig) {
        this.reporterConfig = reporterConfig;
        this.signals = new ArrayList<>();
    }

    public void receiveSignal(long threadId, long monitorIteration, String threadName, double data) {
        MonitorOutputSignal signal = new MonitorOutputSignal(
                threadId,
                monitorIteration,
                threadName,
                data
        );
        this.signals.add(signal);
    }

    public void transmit() {
        this.translateSignals();
        switch (reporterConfig.reportType) {
            case CSV:
                transmitStrings();
                break;
            case STRING:
                transmitStrings();
                break;
            case TXT:
                transmitTxtFile();
                break;
            case SQL:
                transmitStrings();
                break;
        }
    }

    public void translateSignals() {
        ListIterator<MonitorOutputSignal> signalIterator = this.signals.listIterator();
        while (signalIterator.hasNext()) {
            this.adapters.add(new MonitorOutputDataAdapter(signalIterator.next()));
            signalIterator.remove();
        }
    }

    public void transmitStrings() {
        if (reporterConfig.reportType == ReportType.CSV) {
            try (PrintWriter writer = new PrintWriter(new File(reporterConfig.testName + ".csv"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("threadId, monitorIteration, threadName, data\n");

                for (MonitorOutputDataAdapter adapter : this.adapters) {
                    sb.append(adapter.renderCsvString()).append("\n");
                    System.out.println(adapter.renderString());
                }

                writer.write(sb.toString());
                System.out.println("Output saved to " + reporterConfig.testName + ".csv");
            } catch (FileNotFoundException e) {
                System.err.println("Error writing output to CSV file: " + e.getMessage());
            }
        } else {
            for (MonitorOutputDataAdapter adapter : this.adapters) {
                System.out.println(adapter.renderString());
            }
        }
    }

    private void transmitTxtFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (MonitorOutputDataAdapter adapter : this.adapters) {
                String outputString = adapter.renderString();
                System.out.println(outputString); // print to console
                writer.write(outputString + "\n"); // write to file
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to txt file: " + e.getMessage());
        }
    }



}
