package de.consistec.jobad;

import static de.consistec.jobad.Attribute.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ConsistecJobAd {
	
	public static List<JavaDeveloper> findNewColleague() {
		
		List<Attribute> positiveAttributes = Arrays.asList(
				ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_DRIVEN, TEAMPLAYER, OPEN_MINDED);
		
		List<Attribute> negativeAttributes = Arrays.asList(JOB_HOPPER, LONER);
		
		List<JavaDeveloper> devs = 
				findDeveloper(JavaDeveloper.class, Knows.JAVA, Knows.ENGLISH);
		Map<JavaDeveloper, Integer> devScoreCard = 
				calculateDevScore(devs, positiveAttributes, negativeAttributes);
		
		List<JavaDeveloper> newColleagues = Collections.<JavaDeveloper>emptyList();
		for (Map.Entry<JavaDeveloper, Integer> entry : devScoreCard.entrySet()) {
			
			// Check applicant quality ;)
			if (entry.getValue() > 3) {
				newColleagues.add(entry.getKey());
			}
		}
		
		return newColleagues;
		
		// Find this (working) code at: http://github.com/consistec/jobad
	}
	
	
	
	private static <T extends Developer> Map<T, Integer> calculateDevScore(List<T> devs,
			List<Attribute> positiveAttributes,
			List<Attribute> negativeAttributes) {
		return null;
	}

	private static <T extends Developer> List<T> findDeveloper(Class<T> devClass, 
			Knows... expectedKnowledge) {
		// TODO Auto-generated method stub
		return null;
	}
}
