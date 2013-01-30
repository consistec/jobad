package de.consistec.jobad.domain;

import java.util.Set;

public interface Developer {
	// Remove old stuff
	Set<Attribute> getAttributes();
	Set<Experience> getExperience();
	Set<Amenity> getLookingFor();

	// New Stuff
	Developer whoAreMostOf(Attribute... attributes);
	Developer whoAreNot(Attribute... attributes);
	Developer haveExperienceWith(Experience... exp);
	Developer like(Amenity... amenities);
}
