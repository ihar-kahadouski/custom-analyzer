package by.iharkahadouski.analyzer.handler;

import com.epam.ta.reportportal.ws.model.analyzer.CleanIndexRq;
import com.epam.ta.reportportal.ws.model.analyzer.IndexLaunch;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public interface Indexer {

	Long index(List<IndexLaunch> request);

	void cleanIndex(CleanIndexRq request);

	void deleteIndex(Long index);
}
