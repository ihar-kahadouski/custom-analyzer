package by.iharkahadouski.analyzer.handler;

import com.epam.ta.reportportal.ws.model.analyzer.AnalyzedItemRs;
import com.epam.ta.reportportal.ws.model.analyzer.IndexLaunch;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public interface Analyzer {

	List<AnalyzedItemRs> analyze(List<IndexLaunch> request);
}
