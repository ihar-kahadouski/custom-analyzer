package by.iharkahadouski.analyzer.handler;

import by.iharkahadouski.analyzer.model.AnalyzedItemRs;
import by.iharkahadouski.analyzer.model.IndexLaunch;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public interface Analyzer {

	List<AnalyzedItemRs> analyze(IndexLaunch request);
}
