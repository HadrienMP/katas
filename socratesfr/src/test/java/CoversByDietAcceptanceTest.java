import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversByDietAcceptanceTest {
    @Test
    public void should_return_the_number_of_covers_by_diet_for_a_meal() {
        Collection<Diet> diets = Arrays.asList(
                Diet.VEGAN,
                Diet.VEGETARIAN,
                Diet.PESCETARIAN,
                Diet.OMNIVOROUS,
                Diet.PESCETARIAN);

        Map<Diet, Integer> coversByDiet = new Covers().countByDiet(diets);

        assertThat(coversByDiet.get(Diet.VEGAN)).isEqualTo(1);
        assertThat(coversByDiet.get(Diet.VEGETARIAN)).isEqualTo(1);
        assertThat(coversByDiet.get(Diet.PESCETARIAN)).isEqualTo(2);
        assertThat(coversByDiet.get(Diet.OMNIVOROUS)).isEqualTo(1);
    }

    private enum  Diet {
        VEGETARIAN, VEGAN, PESCETARIAN, OMNIVOROUS
    }

    private class Covers {
        public Map<Diet, Integer> countByDiet(Collection<Diet> diets) {
            return null;
        }
    }
}
