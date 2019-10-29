package by.iharkahadouski.analyzer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnalyzerConfig {

	@JsonProperty(value = "minDocFreq")
	private Integer minDocFreq;

	@JsonProperty(value = "minTermFreq")
	private Integer minTermFreq;

	@JsonProperty(value = "minShouldMatch")
	private Integer minShouldMatch;

	@JsonProperty(value = "numberOfLogLines")
	private Integer numberOfLogLines;

	@JsonProperty(value = "isAutoAnalyzerEnabled")
	private Boolean isAutoAnalyzerEnabled;

	@JsonProperty(value = "analyzerMode")

	private String analyzerMode;

	@JsonProperty(value = "indexingRunning")
	private boolean indexingRunning;

	public boolean isIndexingRunning() {
		return indexingRunning;
	}

	public void setIndexingRunning(boolean indexingRunning) {
		this.indexingRunning = indexingRunning;
	}

	public Integer getMinDocFreq() {
		return minDocFreq;
	}

	public void setMinDocFreq(Integer minDocFreq) {
		this.minDocFreq = minDocFreq;
	}

	public Integer getMinTermFreq() {
		return minTermFreq;
	}

	public void setMinTermFreq(Integer minTermFreq) {
		this.minTermFreq = minTermFreq;
	}

	public Integer getMinShouldMatch() {
		return minShouldMatch;
	}

	public void setMinShouldMatch(Integer minShouldMatch) {
		this.minShouldMatch = minShouldMatch;
	}

	public Integer getNumberOfLogLines() {
		return numberOfLogLines;
	}

	public void setNumberOfLogLines(Integer numberOfLogLines) {
		this.numberOfLogLines = numberOfLogLines;
	}

	public Boolean getIsAutoAnalyzerEnabled() {
		return isAutoAnalyzerEnabled;
	}

	public void setIsAutoAnalyzerEnabled(Boolean autoAnalyzerEnabled) {
		isAutoAnalyzerEnabled = autoAnalyzerEnabled;
	}

	public String getAnalyzerMode() {
		return analyzerMode;
	}

	public void setAnalyzerMode(String analyzerMode) {
		this.analyzerMode = analyzerMode;
	}

}
