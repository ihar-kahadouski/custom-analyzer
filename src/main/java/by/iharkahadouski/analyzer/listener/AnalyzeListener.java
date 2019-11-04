package by.iharkahadouski.analyzer.listener;

import by.iharkahadouski.analyzer.handler.Analyzer;
import com.epam.ta.reportportal.ws.model.analyzer.AnalyzedItemRs;
import com.epam.ta.reportportal.ws.model.analyzer.IndexLaunch;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
@Service
public class AnalyzeListener {

	private final Analyzer analyzer;

	public AnalyzeListener(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	@RabbitListener(queues = "${queue.analyze}")
	@SendTo("${routing.analyze}")
	public List<AnalyzedItemRs> handle(List<IndexLaunch> request) {
		return analyzer.analyze(request);
	}
}
