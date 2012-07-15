package de.consistec.jobad.util;

import static de.consistec.jobad.domain.Attribute.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;

import com.google.common.collect.Sets;

import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;

public class ScoreUtilTest {
	
	private Set<Attribute> positiveAttributes = Sets.newHashSet(
			ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_DRIVEN, TEAMPLAYER, OPEN_MINDED);
	
	private Set<Attribute> negativeAttributes = Sets.newHashSet(JOB_HOPPER, LONER);

	@Test
	public void testScoreCalculationForSingleDev() {
		Developer dev = Mockito.mock(Developer.class);
		Set<Attribute> attributes = Sets.newHashSet(
				ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_DRIVEN, LONER);
		when(dev.getAttributes()).thenReturn(attributes);
		
		Map<Developer, Integer> devScore = ScoreUtil.calculateDevScore(Arrays.asList(dev), 
				positiveAttributes, 
				negativeAttributes);
		assertEquals(1, devScore.size());
		assertEquals(2, devScore.get(dev).intValue());
	}
	
	@Test
	public void testScoreCalculationForTwoDevs() {
		Developer dev1 = Mockito.mock(Developer.class);
		Developer dev2 = Mockito.mock(Developer.class);
		Set<Attribute> attributes1 = Sets.newHashSet(
				ENTHUSIASTIC, LOVES_CLEAN_CODE, SOLUTION_DRIVEN, LONER);
		Set<Attribute> attributes2 = Sets.newHashSet(
				ENTHUSIASTIC, LOVES_CLEAN_CODE, TEAMPLAYER, LONER);
		when(dev1.getAttributes()).thenReturn(attributes1);
		when(dev2.getAttributes()).thenReturn(attributes2);
		
		Map<Developer, Integer> devScore = ScoreUtil.calculateDevScore(Arrays.asList(dev1, dev2), 
				positiveAttributes, 
				negativeAttributes);
		assertEquals(2, devScore.size());
		assertEquals(2, devScore.get(dev1).intValue());
		assertEquals(2, devScore.get(dev2).intValue());
	}

}
