package org.ratomidev;

import org.ratomidev.model.SummaryStatistics;

public class JsonExporter implements Exporter{
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"sum\": ").append(summaryStatistics.getSum()).append(",");
        jsonBuilder.append("\"max\": ").append(summaryStatistics.getMax()).append(",");
        jsonBuilder.append("\"min\": ").append(summaryStatistics.getMin()).append(",");
        jsonBuilder.append("\"average\": ").append(summaryStatistics.getAverage());
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
