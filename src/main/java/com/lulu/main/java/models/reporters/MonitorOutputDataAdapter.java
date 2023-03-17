package com.lulu.main.java.models.reporters;

import com.lulu.main.java.models.monitors.Monitors;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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


    public String renderString() { return this.transmissionData.toString(); }
 /*
    public JSONObject renderJSON() {
        JSONObject json = new JSONObject();
        for (String key : this.transmissionData.keySet()) {
            json.put(key, this.transmissionData.get(key));
        }
        return json;
    }

    public String renderSQLInsertValuesAllStrings(boolean castAllValuesToString) {
        String insertValues = "";
        insertValues += "\"" + this.transmissionData.get("threadId") + "\"";
        insertValues += ", ";
        insertValues += "\"" + this.transmissionData.get("monitorIteration") + "\"";
        insertValues += ", ";
        insertValues += "\"" + this.transmissionData.get("threadName") + "\"";
        insertValues += ", ";
        insertValues += "\"" + this.transmissionData.get("data") + "\"";
        insertValues = "(" + insertValues + ")";
        return insertValues;
    }

    public String renderSQLInsertValues() {
        String insertValues = "";
        insertValues += this.transmissionData.get("threadId");
        insertValues += ", ";
        insertValues += this.transmissionData.get("monitorIteration");
        insertValues += ", ";
        insertValues += "\"" + this.transmissionData.get("threadName") + "\"";
        insertValues += ", ";
        insertValues += this.transmissionData.get("data");
        insertValues = "(" + insertValues + ")";
        return insertValues;
    }


    Monitors monitor = new Monitors();
    // ...add monitor rules and signals...
    MonitorOutputSignal signal = monitor.generateOutputSignal();
    MonitorOutputDataAdapter adapter = new MonitorOutputDataAdapter(signal);
    String sqlInsertValues = adapter.renderSQLInsertValues();
    public void insertIntoDatabase() {
        String insertStatement = "INSERT INTO monitor_data(thread_id, monitor_iteration, thread_name, data) VALUES "
                + this.renderSQLInsertValues() + ";";

        // Use your database connection object to execute the insert statement
        Connection conn = MyDatabaseConnection.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    MonitorOutputSignal signal = monitor.generateOutputSignal();
    MonitorOutputDataAdapter adapter = new MonitorOutputDataAdapter(signal);
    adapter.insertIntoDatabase();
    */
}
