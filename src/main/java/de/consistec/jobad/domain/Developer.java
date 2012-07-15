package de.consistec.jobad.domain;

import java.util.Set;


public interface Developer {
	Set<Attribute> getAttributes();
	Set<Experience> getExperience();
}
