package by.iharkahadouski.analyzer.handler;

import com.epam.ta.reportportal.ws.model.analyzer.SearchRq;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
public interface Searcher {

	List<Long> search(SearchRq request);
}
