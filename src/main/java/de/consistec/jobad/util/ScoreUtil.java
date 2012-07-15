package de.consistec.jobad.util;

import static com.google.common.collect.Sets.intersection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets.SetView;

import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;

public final class ScoreUtil {

	private static int WEIGHT_POSITIVE_ATTRIBUTE = 2;
	private static int WEIGHT_NEGATIVE_ATTRIBUTE = 4;
	
	private ScoreUtil() {}

	public static <T extends Developer> Map<T, Integer> calculateDevScore(List<T> devs,
			Set<Attribute> positiveAttributes,
			Set<Attribute> negativeAttributes) {
		final Map<T, Integer> result = new HashMap<T, Integer>(devs.size());
		
		for (T dev : devs) {
			SetView<Attribute> matchingPositiveAttributes = intersection(positiveAttributes, dev.getAttributes());
			SetView<Attribute> matchingNegativeAttributes = intersection(negativeAttributes, dev.getAttributes());
			
			int score = WEIGHT_POSITIVE_ATTRIBUTE * matchingPositiveAttributes.size()
					- (WEIGHT_NEGATIVE_ATTRIBUTE * matchingNegativeAttributes.size());
			result.put(dev, score);
		}
		
		return result;
	}

}
