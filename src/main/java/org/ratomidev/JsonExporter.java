package org.ratomidev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ratomidev.model.SummaryStatistics;

public class JsonExporter implements Exporter{
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String export(SummaryStatistics summaryStatistics) throws JsonProcessingException {
        /* this is a bad design becuse each time you add a property in the SummaryStatics it
        you should update the jsonExporter, here is a decoupled code.
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"sum\": ").append(summaryStatistics.getSum()).append(",");
        jsonBuilder.append("\"max\": ").append(summaryStatistics.getMax()).append(",");
        jsonBuilder.append("\"min\": ").append(summaryStatistics.getMin()).append(",");
        jsonBuilder.append("\"average\": ").append(summaryStatistics.getAverage());
        jsonBuilder.append("}");
        return jsonBuilder.toString();
        */

        return objectMapper.writeValueAsString(summaryStatistics);
    }
}
