package by.iharkahadouski.analyzer.listener;

import by.iharkahadouski.analyzer.handler.Searcher;
import by.iharkahadouski.analyzer.model.SearchRq;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Service
public class SearchListener {

	private final Searcher searcher;

	@Autowired
	public SearchListener(Searcher searcher) {
		this.searcher = searcher;
	}

	@RabbitListener(queues = "${queue.search}")
	@SendTo("${routing.search}")
	public List<Long> search(SearchRq request) {
		return searcher.search(request);
	}
}
