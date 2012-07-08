package de.consistec.jobad.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;

public final class ScoreUtil {

	private static int WEIGHT_NEGATIVE_ATTRIBUTE = 2;
	
	private ScoreUtil() {}

	public static <T extends Developer> Map<T, Integer> calculateDevScore(List<T> devs,
			Set<Attribute> positiveAttributes,
			Set<Attribute> negativeAttributes) {
		final Map<T, Integer> result = new HashMap<T, Integer>(devs.size());
		
		final Set<Attribute> matchingPositiveAttributes = new HashSet<Attribute>(positiveAttributes);
		final Set<Attribute> matchingNegativeAttributes = new HashSet<Attribute>(negativeAttributes);
		for (T dev : devs) {
			matchingPositiveAttributes.retainAll(dev.getAttributes());
			matchingNegativeAttributes.retainAll(dev.getAttributes());
			
			int score = matchingPositiveAttributes.size() 
					- (WEIGHT_NEGATIVE_ATTRIBUTE * matchingNegativeAttributes.size());
			result.put(dev, score);
		}
		
		return result;
	}

}
