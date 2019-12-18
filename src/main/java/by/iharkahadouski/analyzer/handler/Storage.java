package by.iharkahadouski.analyzer.handler;

import by.iharkahadouski.analyzer.util.Index;

import java.util.List;
import java.util.Set;

public interface Storage {

	Set<Index> get(Long id);

	void put(Long id, Set<Index> indices);

	void put(Long id, Index index);

	void delete(Long id);

	void clean(Long id, List<Long> indices);
}
