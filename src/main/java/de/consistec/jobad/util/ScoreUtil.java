package de.consistec.jobad.util;

import static com.google.common.collect.Sets.intersection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets.SetView;

import de.consistec.jobad.domain.Amenity;
import de.consistec.jobad.domain.Attribute;
import de.consistec.jobad.domain.Developer;
import de.consistec.jobad.domain.Experience;

public final class ScoreUtil {

  private static int WEIGHT_POSITIVE_ATTRIBUTE = 2;
  private static int WEIGHT_NEGATIVE_ATTRIBUTE = 4;
  private static int WEIGHT_EXPERIENCE = 1;
  private static int WEIGHT_AMENITY = 1;

  private ScoreUtil() {}

  public static <T extends Developer> Map<T, Integer> calculateDevScore(List<T> devs,
      Set<Attribute> positiveAttributes,
      Set<Attribute> negativeAttributes,
      Set<Experience> plusFactors,
      Set<Amenity> amenities) {
    final Map<T, Integer> result = new HashMap<T, Integer>(devs.size());

    for (T dev : devs) {
      SetView<Attribute> matchingPositiveAttributes = intersection(positiveAttributes, dev.getAttributes());
      SetView<Attribute> matchingNegativeAttributes = intersection(negativeAttributes, dev.getAttributes());
      SetView<Experience> matchingExperience = intersection(plusFactors, dev.getExperience());
      SetView<Amenity> matchingAmenity = intersection(amenities, dev.getLookingFor());

      int score = WEIGHT_POSITIVE_ATTRIBUTE * matchingPositiveAttributes.size()
          - WEIGHT_NEGATIVE_ATTRIBUTE * matchingNegativeAttributes.size()
          + WEIGHT_EXPERIENCE * matchingExperience.size()
          + WEIGHT_AMENITY * matchingAmenity.size();
      result.put(dev, score);
    }

    return result;
  }

}
