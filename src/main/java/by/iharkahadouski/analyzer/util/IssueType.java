package by.iharkahadouski.analyzer.util;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public enum IssueType {
	PRODUCT_BUG("pb001"),
	TO_INVESTIGATE("ti001"),
	AUTOMATION_BUG("ab001"),
	SYSTEM_ISSUE("si001"),
	NO_DEFECT("nd001");

	private String locator;

	IssueType(String locator) {
		this.locator = locator;
	}

	public String getLocator() {
		return locator;
	}
}
