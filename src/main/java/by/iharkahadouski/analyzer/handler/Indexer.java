package by.iharkahadouski.analyzer.handler;

import by.iharkahadouski.analyzer.model.CleanIndexRq;
import by.iharkahadouski.analyzer.model.IndexLaunch;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public interface Indexer {

	Long index(List<IndexLaunch> request);

	void cleanIndex(CleanIndexRq request);

	void deleteIndex(Long index);
}
