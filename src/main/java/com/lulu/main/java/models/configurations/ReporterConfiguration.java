package com.lulu.main.java.models.configurations;

import com.lulu.main.java.models.reporters.ReportType;

public class ReporterConfiguration {
    public ReportType reportType;
    public String testName;

    public ReporterConfiguration() {}

    public void setReportType(String reportTypeString, String testName) {
        this.reportType = reportTypeMap(reportTypeString);
        this.testName = testName;
    }

    private static ReportType reportTypeMap(String reportTypeString) {
        if (reportTypeString == null) {
            return ReportType.STRING;
        }
        switch (reportTypeString.toLowerCase()) {
            case "csv":
                return ReportType.CSV;
            case "sql":
                return ReportType.SQL;
            case "txt":
                return ReportType.TXT;
            default:
                return ReportType.STRING;
        }
    }
}
