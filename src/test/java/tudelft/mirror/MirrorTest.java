package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {

    @ParameterizedTest(name = "{0}: ({1}) = {2}")
    @CsvSource({
            // mirrorEnds for even inputlenght
            "'mirrorEnds-even-1-mirror', 'aa', 'aa'", "'mirrorEnds-even-1-mirror', 'aCDABa', 'a'", "'mirrorEnds-even-3-mirror', 'abccba', 'abccba'", "'mirrorEnds-even-3-mirror', 'abcGHYtbcba', 'abc'",
            // mirrorEnds for uneven inputlenght
            "'mirrorEnds-uneven-1-mirror', 'a', 'a'", "'mirrorEnds-uneven-1-mirror', 'aba', 'aba'", "'mirrorEnds-uneven-3-mirror', 'abcba', 'abcba'", "'mirrorEnds-uneven-3-mirror', 'abcdefcba', 'abc'",
            // no mirrorEnds
            "'no-mirrorEnds', 'xabc', ''",
            // no input
            "'no-Input', '', ''"
    })
    public void testAlgorithm(String partition, String string, String expectedResult) {
        Mirror mirror = new Mirror();

        String actualResult = mirror.mirrorEnds(string);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
