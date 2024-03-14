package org.ratomidev;

import org.ratomidev.model.SummaryStatistics;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics) throws Exception;
}
