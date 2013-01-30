package de.consistec.jobad.util;

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
import static de.consistec.jobad.domain.Experience.GWT;
import static de.consistec.jobad.domain.Experience.JAVAEE;
import static de.consistec.jobad.domain.Experience.MAVEN;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;

import com.google.common.collect.Sets;

import de.consistec.jobad.domain.Amenity;
import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;
import de.consistec.jobad.domain.Experience;

public class ScoreUtilTest {

  private Set<Attribute> positiveAttributes = Sets.newHashSet(
      ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_ORIENTED, TEAMPLAYER, OPEN_MINDED);

  private Set<Attribute> negativeAttributes = Sets.newHashSet(JOB_HOPPER, LONER);

  private Set<Experience> plusFactors = Sets.newHashSet(JAVAEE, MAVEN, EJB3);

  private Set<Amenity> amenities = Sets.newHashSet(INNOVATION, RESPONSIBLEPOSITION);

  @Test
  public void testScoreCalculationForSingleDev() {
    Developer dev = Mockito.mock(Developer.class);
    Set<Attribute> attributes = Sets.newHashSet(
        ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_ORIENTED, LONER);
    Set<Experience> experience = Sets.newHashSet(JAVAEE, GWT, MAVEN);
    Set<Amenity> lookingFor = Sets.newHashSet(RESPONSIBLEPOSITION, VARIETY);
    when(dev.getAttributes()).thenReturn(attributes);
    when(dev.getExperience()).thenReturn(experience);
    when(dev.getLookingFor()).thenReturn(lookingFor);

    Map<Developer, Integer> devScore = ScoreUtil.calculateDevScore(Arrays.asList(dev),
        positiveAttributes,
        negativeAttributes,
        plusFactors,
        amenities);
    assertEquals(1, devScore.size());
    assertEquals(5, devScore.get(dev).intValue());
  }

  @Test
  public void testScoreCalculationForTwoDevs() {
    Developer dev1 = Mockito.mock(Developer.class);
    Developer dev2 = Mockito.mock(Developer.class);
    Set<Attribute> attributes1 = Sets.newHashSet(
        ENTHUSIASTIC, LOVES_CLEAN_CODE, TEST_DRIVEN, LONER);
    Set<Experience> experience1 = Sets.newHashSet(JAVAEE, GWT);
    Set<Amenity> lookingFor1 = Sets.newHashSet(RESPONSIBLEPOSITION, VARIETY);
    Set<Attribute> attributes2 = Sets.newHashSet(
        ENTHUSIASTIC, LOVES_CLEAN_CODE, TEAMPLAYER, LONER);
    Set<Experience> experience2 = Sets.newHashSet(GWT);
    Set<Amenity> lookingFor2 = Sets.newHashSet(RESPONSIBLEPOSITION);
    when(dev1.getAttributes()).thenReturn(attributes1);
    when(dev1.getExperience()).thenReturn(experience1);
    when(dev1.getLookingFor()).thenReturn(lookingFor1);
    when(dev2.getAttributes()).thenReturn(attributes2);
    when(dev2.getExperience()).thenReturn(experience2);
    when(dev2.getLookingFor()).thenReturn(lookingFor2);

    Map<Developer, Integer> devScore = ScoreUtil.calculateDevScore(Arrays.asList(dev1, dev2),
        positiveAttributes,
        negativeAttributes,
        plusFactors,
        amenities);
    assertEquals(2, devScore.size());
    assertEquals(2, devScore.get(dev1).intValue());
    assertEquals(3, devScore.get(dev2).intValue());
  }

}
