package by.iharkahadouski.analyzer.handler.impl;

import by.iharkahadouski.analyzer.handler.Searcher;
import by.iharkahadouski.analyzer.model.SearchRq;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Component
public class SearcherImpl implements Searcher {


	@Override
	public List<Long> search(SearchRq request) {
		return null;
	}
}
