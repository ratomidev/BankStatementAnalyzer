package org.ratomidev;

import org.ratomidev.model.SummaryStatistics;

import java.lang.reflect.Field;

public class HtmlExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) throws IllegalAccessException {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='en'>");
        htmlBuilder.append("<head><meta charset='UTF-8'><title>Summary Statistics Report</title></head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<h1>Summary Statistics Report</h1>");
        htmlBuilder.append("<ul>");

        // Use reflection to dynamically iterate over properties of SummaryStatistics
        Field[] fields = SummaryStatistics.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            Object value = field.get(summaryStatistics);
            htmlBuilder.append("<li><strong>").append(field.getName()).append("</strong>: ").append(value).append("</li>");
        }
        htmlBuilder.append("</ul>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");
        return htmlBuilder.toString();
    }
}
