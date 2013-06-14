package strategy;

import impl.DynamicPathCalculationStrategy;

public class StrategyFactory {

	public DynamicPathCalculationStrategy generateStrategy(String id) {
		if (id == null || id.isEmpty()) {
			throw new NullPointerException("id is null - cannot set Strategy");
		}

		if ("Dynamic".equals(id)) {
			return new DynamicPathCalculationStrategy();
		}

		throw new IllegalArgumentException("unknown strategy");
	}

}
