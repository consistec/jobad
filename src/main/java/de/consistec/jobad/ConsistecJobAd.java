package de.consistec.jobad;

import static de.consistec.jobad.domain.Attribute.*;
import static de.consistec.jobad.util.ScoreUtil.calculateDevScore;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;
import de.consistec.jobad.domain.Gender;
import de.consistec.jobad.domain.JavaDeveloper;
import de.consistec.jobad.domain.Knows;

public class ConsistecJobAd {
	
	public static List<JavaDeveloper> findNewColleagues() {
		
		Set<Attribute> positiveAttributes = Sets.newHashSet(
				ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_DRIVEN, TEAMPLAYER, OPEN_MINDED);
		
		Set<Attribute> negativeAttributes = Sets.newHashSet(JOB_HOPPER, LONER);
		
		List<JavaDeveloper> devs = 
				findDeveloper(JavaDeveloper.class, Gender.BOTH, Knows.JAVA, Knows.ENGLISH);
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
	
	
	
	private static <T extends Developer> List<T> findDeveloper(Class<T> devClass,
			Gender expectedGender,
			Knows... expectedKnowledge) {
		// Do some magic in the real world to find developers.     
		return null;
	}
}	
