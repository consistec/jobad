package de.consistec.jobad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ScoreUtil {
	
	private ScoreUtil() {}

	public static <T extends Developer> Map<T, Integer> calculateDevScore(List<T> devs,
			Set<Attribute> positiveAttributes,
			Set<Attribute> negativeAttributes) {
		final Map<T, Integer> result = new HashMap<T, Integer>(devs.size());
		
		
		
		return result;
	}

}
