package by.iharkahadouski.analyzer.handler.impl;

import by.iharkahadouski.analyzer.handler.Indexer;
import by.iharkahadouski.analyzer.handler.Storage;
import by.iharkahadouski.analyzer.util.Index;
import by.iharkahadouski.analyzer.util.IssueType;
import com.epam.ta.reportportal.ws.model.analyzer.CleanIndexRq;
import com.epam.ta.reportportal.ws.model.analyzer.IndexLaunch;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Component
public class IndexerImpl implements Indexer {

	private Storage storage;

	@Autowired
	public IndexerImpl(Storage storage) {
		this.storage = storage;
	}

	@Override
	public Long index(List<IndexLaunch> request) {
		request.stream()
				.map(it -> Pair.of(it.getProjectId(), it.getTestItems()))
				.forEach(it -> it.getRight().forEach(item -> item.getLogs().forEach(log -> storage.put(
						it.getLeft(),
						new Index(log.getLogId(), IssueType.fromString(item.getIssueTypeLocator()).orElseThrow(), log.getMessage())
				))));

		return request.stream().flatMap(it -> it.getTestItems().stream()).mapToLong(it -> it.getLogs().size()).sum();
	}

	@Override
	public void cleanIndex(CleanIndexRq request) {
		storage.clean(request.getProjectId(), request.getItemIds());
	}

	@Override
	public void deleteIndex(Long index) {
		storage.delete(index);
	}

}
