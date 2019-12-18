package by.iharkahadouski.analyzer.handler.impl;

import by.iharkahadouski.analyzer.handler.Analyzer;
import by.iharkahadouski.analyzer.handler.Storage;
import com.epam.ta.reportportal.ws.model.analyzer.AnalyzedItemRs;
import com.epam.ta.reportportal.ws.model.analyzer.IndexLaunch;
import com.epam.ta.reportportal.ws.model.analyzer.IndexLog;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Component
public class AnalyzerImpl implements Analyzer {

	private final Storage storage;

	@Autowired
	public AnalyzerImpl(Storage storage) {
		this.storage = storage;
	}

	@Override
	public List<AnalyzedItemRs> analyze(List<IndexLaunch> request) {
		List<Pair<Long, List<String>>> messages = request.stream().map(it -> Pair.of(
				it.getProjectId(),
				it.getTestItems().stream().flatMap(item -> item.getLogs().stream().map(IndexLog::getMessage)).collect(Collectors.toList())
		)).collect(Collectors.toList());
		return messages.stream()
				.map(it -> storage.get(it.getLeft()).stream().filter(index -> it.getRight().contains(index.getMessage())).map(bla -> {
					AnalyzedItemRs response = new AnalyzedItemRs();
					response.setItemId(bla.getId());
					response.setLocator(bla.getIssueType().getLocator());
					return response;
				}))
				.flatMap(it -> it)
				.collect(Collectors.toList());
	}
}
