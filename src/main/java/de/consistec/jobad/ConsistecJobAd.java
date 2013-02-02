package de.consistec.jobad;

import static de.consistec.jobad.domain.Amenity.AGILE_SWD;
import static de.consistec.jobad.domain.Amenity.FLATHIERARCHY;
import static de.consistec.jobad.domain.Amenity.INNOVATION;
import static de.consistec.jobad.domain.Amenity.RESPONSIBLE_POSITION;
import static de.consistec.jobad.domain.Amenity.VARIETY;
import static de.consistec.jobad.domain.Attribute.CLEAN_CODE_LOVER;
import static de.consistec.jobad.domain.Attribute.ENTHUSIASTIC;
import static de.consistec.jobad.domain.Attribute.JOB_HOPPER;
import static de.consistec.jobad.domain.Attribute.LONER;
import static de.consistec.jobad.domain.Attribute.OPEN_MINDED;
import static de.consistec.jobad.domain.Attribute.SOLUTION_ORIENTED;
import static de.consistec.jobad.domain.Attribute.TEAMPLAYER;
import static de.consistec.jobad.domain.Experience.EJB3;
import static de.consistec.jobad.domain.Experience.JAVAEE;
import static de.consistec.jobad.domain.Experience.MAVEN;
import static de.consistec.jobad.domain.Experience.VCS;
import static de.consistec.jobad.domain.TimeUnit.YEARS;
import de.consistec.jobad.domain.CandidatePool;
import de.consistec.jobad.domain.Consistec;
import de.consistec.jobad.domain.Individuals;

public class ConsistecJobAd {

	/**
	 * Engage new developers for consistec
	 *
	 * @see <a href="http://www.consistec.de/?key=javaJobAd">consistec homepage</a>
	 * @see <a href="http://github.com/consistec/jobad">this working code</a>
	 */
	public static void engageNewColleagues() {

		while (CandidatePool.isNotEmpty()) {
			Consistec.isLookingFor(Individuals.class)
				.whoAreMostOf(ENTHUSIASTIC, CLEAN_CODE_LOVER, OPEN_MINDED, SOLUTION_ORIENTED, TEAMPLAYER)
				.withJobExperience(3, YEARS)
				.whoAreNot(JOB_HOPPER, LONER)
				.haveExperienceWith(JAVAEE, MAVEN, EJB3, VCS)
				.like(INNOVATION, RESPONSIBLE_POSITION, VARIETY, FLATHIERARCHY, AGILE_SWD)
				.engage();
		}

	}

}
