package com.lulu.main.java.models.configurations;

import com.lulu.main.java.models.reporters.ReportType;

public class ReporterConfiguration {
    public ReportType reportType;

    public ReporterConfiguration() {}

    public void setReportType(String reportTypeString) {
        this.reportType = reportTypeMap(reportTypeString);
    }

    private static ReportType reportTypeMap(String reportTypeString) {
        if (reportTypeString == null) {
            return ReportType.STRING;
        }
        switch (reportTypeString.toLowerCase()) {
            case "json":
                return ReportType.JSON;
            case "sql":
                return ReportType.SQL;
            case "sql strings":
                return ReportType.SQL_ALL_STRINGS;
            default:
                return ReportType.STRING;
        }
    }
}