package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void lastWordDoesNotMatch2() {
        int words = new CountLetters().count("car");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void lastWordDoesNotMatch3() {
        int words = new CountLetters().count("car dos");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch4() {
        int words = new CountLetters().count("hoi ja");
        Assertions.assertEquals(0, words);
    }

}