package org.ratomidev;

import org.ratomidev.model.SummaryStatistics;

import java.lang.reflect.Field;
import java.util.logging.ConsoleHandler;

public class XmlExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) throws IllegalAccessException{
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<summaryStatistics>");
        Field[] fields = summaryStatistics.getClass().getDeclaredFields();
        for(final Field field: fields) {
            field.setAccessible(true);
                Object value = field.get(summaryStatistics);
                xmlBuilder.append("<").append(field.getName()).append(">")
                        .append(value)
                        .append("</").append(field.getName()).append(">");

        }
        xmlBuilder.append("</summaryStatistics>");
        return xmlBuilder.toString();
    }

}
