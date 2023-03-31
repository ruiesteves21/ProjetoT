package com.lulu.main.java.models.reporters;

import java.util.HashMap;

public class MonitorOutputDataAdapter {
    public HashMap<String, Object> transmissionData;

    public MonitorOutputDataAdapter(MonitorOutputSignal signal) {
        this.transmissionData = new HashMap<>();
        this.transmissionData.put("threadId", signal.getThreadId());
        this.transmissionData.put("monitorIteration", signal.getMonitorIteration());
        this.transmissionData.put("threadName", signal.getThreadName());
        this.transmissionData.put("data", signal.getData());
    }


    public String renderString() {
        return this.transmissionData.toString();
    }
}
