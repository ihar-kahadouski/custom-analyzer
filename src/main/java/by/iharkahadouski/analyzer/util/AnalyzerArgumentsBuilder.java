package by.iharkahadouski.analyzer.util;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public class AnalyzerArgumentsBuilder {

	private static final String ANALYZER_NAME_KEY = "analyzer";
	private static final String ANALYZER_INDEX_KEY = "analyzer_index";
	private static final String ANALYZER_PRIORITY_KEY = "analyzer_priority";
	private static final String ANALYZER_LOG_SEARCH_KEY = "analyzer_log_search";
	private static final String ANALYZER_VERSION_KEY = "version";

	private ImmutableMap.Builder<String, Object> arguments = new ImmutableMap.Builder<>();

	public AnalyzerArgumentsBuilder() {
	}

	public AnalyzerArgumentsBuilder withName(String name) {
		arguments.put(ANALYZER_NAME_KEY, name);
		return this;
	}

	public AnalyzerArgumentsBuilder withPriority(int priority) {
		arguments.put(ANALYZER_PRIORITY_KEY, String.valueOf(priority));
		return this;
	}

	public AnalyzerArgumentsBuilder withIndexSupport(boolean indexSupport) {
		arguments.put(ANALYZER_INDEX_KEY, indexSupport);
		return this;
	}

	public AnalyzerArgumentsBuilder withSearchSupport(boolean searchSupport) {
		arguments.put(ANALYZER_LOG_SEARCH_KEY, searchSupport);
		return this;
	}

	public AnalyzerArgumentsBuilder withVersion(String version) {
		arguments.put(ANALYZER_VERSION_KEY, version);
		return this;
	}

	public Map<String, Object> build() {
		return arguments.build();
	}
}
