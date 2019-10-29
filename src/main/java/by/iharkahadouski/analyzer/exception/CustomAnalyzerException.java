package by.iharkahadouski.analyzer.exception;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public class CustomAnalyzerException extends RuntimeException {

	public CustomAnalyzerException(String message) {
		super(message);
	}

	public CustomAnalyzerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomAnalyzerException(Throwable cause) {
		super(cause);
	}
}
