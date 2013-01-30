package de.consistec.jobad;

import static de.consistec.jobad.domain.Amenity.FLATHIERARCHY;
import static de.consistec.jobad.domain.Amenity.INNOVATION;
import static de.consistec.jobad.domain.Amenity.RESPONSIBLEPOSITION;
import static de.consistec.jobad.domain.Amenity.VARIETY;
import static de.consistec.jobad.domain.Attribute.ENTHUSIASTIC;
import static de.consistec.jobad.domain.Attribute.JOB_HOPPER;
import static de.consistec.jobad.domain.Attribute.LONER;
import static de.consistec.jobad.domain.Attribute.LOVES_CLEAN_CODE;
import static de.consistec.jobad.domain.Attribute.OPEN_MINDED;
import static de.consistec.jobad.domain.Attribute.SOLUTION_ORIENTED;
import static de.consistec.jobad.domain.Attribute.TEAMPLAYER;
import static de.consistec.jobad.domain.Attribute.TEST_DRIVEN;
import static de.consistec.jobad.domain.Experience.EJB3;
import static de.consistec.jobad.domain.Experience.JAVAEE;
import static de.consistec.jobad.domain.Experience.MAVEN;
import static de.consistec.jobad.util.ScoreUtil.calculateDevScore;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import de.consistec.jobad.domain.Amenity;
import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;
import de.consistec.jobad.domain.Experience;
import de.consistec.jobad.domain.Gender;
import de.consistec.jobad.domain.JavaDeveloper;
import de.consistec.jobad.domain.Knows;

public class ConsistecJobAd {

    /**
     * Find new developers for consistec
     * @return list of new colleagues
     * @see <a href="http://www.consistec.de/?key=javaJobAd">consistec homepage</a>
     * @see <a href="http://github.com/consistec/jobad">this working code</a>
     */
  public static List<JavaDeveloper> findNewColleagues() {

    Set<Attribute> positiveAttributes = Sets.newHashSet(
        ENTHUSIASTIC, LOVES_CLEAN_CODE, OPEN_MINDED, SOLUTION_ORIENTED, TEAMPLAYER, TEST_DRIVEN);

    Set<Attribute> negativeAttributes = Sets.newHashSet(JOB_HOPPER, LONER);

    Set<Experience> plusFactors = Sets.newHashSet(JAVAEE, MAVEN, EJB3);

    Set<Amenity> amenities = Sets.newHashSet(INNOVATION, RESPONSIBLEPOSITION, VARIETY, FLATHIERARCHY);

    List<JavaDeveloper> devs =
        findDeveloper(JavaDeveloper.class, Gender.BOTH, Knows.JAVA, Knows.ENGLISH);
    Map<JavaDeveloper, Integer> devScoreCard =
        calculateDevScore(devs, positiveAttributes, negativeAttributes, plusFactors, amenities);

    List<JavaDeveloper> newColleagues = Collections.<JavaDeveloper>emptyList();
    for (Map.Entry<JavaDeveloper, Integer> entry : devScoreCard.entrySet()) {

      // Check applicant quality ;)
      if (entry.getValue() > 6) {
        newColleagues.add(entry.getKey());
      }
    }

    return newColleagues;
  }



  private static <T extends Developer> List<T> findDeveloper(Class<T> devClass,
      Gender expectedGender,
      Knows... expectedKnowledge) {
    // Do some magic in the real world to find developers.
    return null;
  }
}
