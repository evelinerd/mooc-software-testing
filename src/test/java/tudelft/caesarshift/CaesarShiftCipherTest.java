package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.ghappy.GHappy;

public class CaesarShiftCipherTest {

    @ParameterizedTest(name = "{0}: ({1}, {2}) = {3}")
    @CsvSource({
            // wrong character
            "'wrong-character', 'abc', 3, 'def'", "'wrong-character', 'abc%', 3, 'invalid'", "'wrong-character', '%abc', 3, 'invalid'", "'wrong-character', '&*^', 3, 'invalid'",
            // wrap around
            "'wrap-around', 'xyz', 1, 'yza'", "'wrap-around', 'xyz', 26, 'xyz'", "'wrap-around', 'xyz', 10, 'hij'",
            // spacing
            "'spacing', 'de f', 2, 'fg h'", "'spacing', 'de f ', 2, 'fg h '", "'spacing', ' de f', 2, ' fg h'", "'spacing', 'de  f', 2, 'fg  h'",
            // no characters
            "'no-characters', '', 2, ''",
            // no shift
            "'no-shift', 'def', 0, 'def'"
    })

    public void testAlgorithm(String partition, String message, int shift, String expectedResult){
        String result = new CaesarShiftCipher().CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expectedResult, result);
    }

}
