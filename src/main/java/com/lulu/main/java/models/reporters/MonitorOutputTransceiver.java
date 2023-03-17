package com.lulu.main.java.models.reporters;

import com.lulu.main.java.models.configurations.ReporterConfiguration;

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
            case JSON:
                transmitStrings();
            case STRING:
                transmitStrings();
            case SQL_ALL_STRINGS:
                transmitStrings();
            case SQL:
                transmitStrings();
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
        for (MonitorOutputDataAdapter adapter : this.adapters) {
            System.out.println(adapter.renderString());
        }
    }

}
