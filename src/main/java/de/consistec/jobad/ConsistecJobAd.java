package de.consistec.jobad;

import java.util.List;

public class ConsistecJobAd {
	
	public static JavaDeveloper findNewColleague() {
		
		
		List<JavaDeveloper> devs = 
				findDeveloper(JavaDeveloper.class, Knows.JAVA, Knows.ENGLISH, Knows.AGILE);
		// Hibernate query with params to find a dev, filter further...
		// HasFun.workingWith(Beans.flavored(Jelly().or(Enterprise())));
		// groovy rubies...
		
		return null;
		
		// Find this code at: http://github.com/cboutter/jobad
	}

	private static <T extends Developer> List<T> findDeveloper(Class<T> devClass, 
			Knows... expectedKnowledge) {
		// TODO Auto-generated method stub
		return null;
	}
}
