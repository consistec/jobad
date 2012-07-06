package de.consistec.jobad;

import java.util.Arrays;
import java.util.List;

public class ConsistecJobAd {
	
	public static JavaDeveloper findNewColleague() {
		
		List<Attribute> positiveAttributes = Arrays.asList();
		List<Attribute> negativeAttributes = Arrays.asList();
		
		List<JavaDeveloper> devs = 
				findDeveloper(JavaDeveloper.class, Knows.JAVA, Knows.ENGLISH);
		calculateDevScore(devs, positiveAttributes, negativeAttributes);
		
		
		return null;
		
		// Find this code at: http://github.com/cboutter/jobad
	}
	
	
	
	private static void calculateDevScore(List<JavaDeveloper> devs,
			List<Attribute> positiveAttributes,
			List<Attribute> negativeAttributes) {
		// TODO Auto-generated method stub
		
	}

	private static <T extends Developer> List<T> findDeveloper(Class<T> devClass, 
			Knows... expectedKnowledge) {
		// TODO Auto-generated method stub
		return null;
	}
}
