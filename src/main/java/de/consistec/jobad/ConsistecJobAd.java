package de.consistec.jobad;

import de.consistec.jobad.persistence.HibernateUtil;

public class ConsistecJobAd {
	
	public static JavaDeveloper findNewColleague() {
		
		
		HibernateUtil.getSession().createQuery("from JavaDeveloper where ...");
		// Hibernate query with params to find a dev, filter further...
		// HasFun.workingWith(Beans.flavored(Jelly().or(Enterprise())));
		// groovy rubies...
		
		return null;
	}
}
