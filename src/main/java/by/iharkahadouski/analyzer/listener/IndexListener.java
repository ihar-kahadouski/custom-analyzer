package by.iharkahadouski.analyzer.listener;

import by.iharkahadouski.analyzer.handler.Indexer;
import by.iharkahadouski.analyzer.model.CleanIndexRq;
import by.iharkahadouski.analyzer.model.IndexLaunch;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Service
public class IndexListener {

	private final Indexer indexer;

	@Autowired
	public IndexListener(Indexer indexer) {
		this.indexer = indexer;
	}

	@RabbitListener(queues = "${queue.index}")
	@SendTo("${routing.index}")
	public Long handle(List<IndexLaunch> request) {
		return indexer.index(request);
	}

	@RabbitListener(queues = "${queue.clean}")
	public void clean(CleanIndexRq request) {
		indexer.cleanIndex(request);
	}

	@RabbitListener(queues = "${queue.delete}")
	public void delete(Long index) {
		indexer.deleteIndex(index);
	}
}
