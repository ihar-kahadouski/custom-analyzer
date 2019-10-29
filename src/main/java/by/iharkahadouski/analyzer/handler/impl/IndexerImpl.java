package by.iharkahadouski.analyzer.handler.impl;

import by.iharkahadouski.analyzer.handler.Indexer;
import by.iharkahadouski.analyzer.model.CleanIndexRq;
import by.iharkahadouski.analyzer.model.IndexLaunch;
import by.iharkahadouski.analyzer.model.IndexTestItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Component
public class IndexerImpl implements Indexer {

	private static Map<String, String> STORAGE = new HashMap<>();

	@Override
	public Long index(List<IndexLaunch> request) {
		return request.stream().flatMap(it -> it.getTestItems().stream()).map(IndexTestItem::getLogs).count();
	}

	@Override
	public void cleanIndex(CleanIndexRq request) {

	}

	@Override
	public void deleteIndex(Long index) {

	}

}
