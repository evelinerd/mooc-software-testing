package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    @ParameterizedTest(name = "{0}: ({1}) = {2}")
    @CsvSource({
            // only one G
            "'one-g', 'g', false", "'one-g', 'gx', false", "'one-g', 'xg', false", "'one-g', 'xgx', false", "'one-g', 'xgxg', false",
            // multiple G's
            "'g's-together', 'gg', true", "'g's-together', 'ggx', true", "'g's-together', 'xgg', true", "'g's-together', 'xggx', true", "'g's-together', 'xggg', true",
            // multiple G's and one G
            "'multiple+one', 'ggxg', false", "'multiple+one', 'xggxg', false", "'multiple+one', 'gxgg', false", "'multiple+one', 'xgxgg', false",
            // no G's
            "no-g', 'x', false",
            // empty string
            "'empty', '', false",
            // null value
            "'null', NULL, AssertionError.class"
    })

    public void testAlgorithm(String partition, String text, boolean expectedResult){
        boolean result = new GHappy().gHappy(text);
        Assertions.assertEquals(expectedResult, result);
    }
}
