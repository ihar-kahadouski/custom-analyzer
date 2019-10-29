package by.iharkahadouski.analyzer.handler.impl;

import by.iharkahadouski.analyzer.handler.Analyzer;
import by.iharkahadouski.analyzer.model.AnalyzedItemRs;
import by.iharkahadouski.analyzer.model.IndexLaunch;
import by.iharkahadouski.analyzer.util.IssueType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Component
public class AnalyzerImpl implements Analyzer {

	@Override
	public List<AnalyzedItemRs> analyze(IndexLaunch request) {
		return request.getTestItems().stream().map(it -> {
			AnalyzedItemRs response = new AnalyzedItemRs();
			response.setItemId(it.getTestItemId());
			response.setLocator(IssueType.PRODUCT_BUG.getLocator());
			return response;
		}).collect(Collectors.toList());
	}
}
