package by.iharkahadouski.analyzer.handler.impl;

import by.iharkahadouski.analyzer.handler.Storage;
import by.iharkahadouski.analyzer.util.Index;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InMemoryStorage implements Storage {

	private static final Map<Long, Set<Index>> STORAGE = Maps.newHashMap();

	@Override
	public Set<Index> get(Long id) {
		return STORAGE.get(id);
	}

	@Override
	public void put(Long id, Set<Index> indices) {
		STORAGE.put(id, indices);
	}

	@Override
	public void put(Long id, Index index) {
		STORAGE.computeIfPresent(id, (key, value) -> {
			value.add(index);
			return value;
		});
		STORAGE.putIfAbsent(id, Sets.newHashSet(index));
	}

	@Override
	public void delete(Long id) {
		STORAGE.remove(id);
	}

	@Override
	public void clean(Long id, List<Long> indices) {
		STORAGE.put(id, STORAGE.get(id).stream().filter(it -> !indices.contains(it.getId())).collect(Collectors.toSet()));
	}
}
