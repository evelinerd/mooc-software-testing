package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoNumbersSumTest {

    @Test
    public void testEmptyLists(){

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> expectedResult = new ArrayList<>();

        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();

        ArrayList<Integer> actualResult = twoNumbersSum.addTwoNumbers(first, second);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void FirstListEmpty() {

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(7, 5));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(7, 5));

        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();

        ArrayList<Integer> actualResult = twoNumbersSum.addTwoNumbers(first, second);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void SecondListEmpty(){

        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 0));
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(7, 8 , 9, 1, 0));

        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();

        ArrayList<Integer> actualResult = twoNumbersSum.addTwoNumbers(first, second);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TotalElementsMoreThanTenAndFirstListLongest(){

        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(7, 5));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 3, 1));

        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();

        ArrayList<Integer> actualResult = twoNumbersSum.addTwoNumbers(first, second);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TotalElementsMoreThanTenAndSecondListLongest(){

        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 0));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(2, 0, 2, 3, 6, 6));
        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();

        ArrayList<Integer> actualResult = twoNumbersSum.addTwoNumbers(first, second);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void CarryOverScenario() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9));
        ArrayList<Integer> second = new ArrayList<>(Collections.singletonList(1));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 0, 0));

        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();

        ArrayList<Integer> actualResult = twoNumbersSum.addTwoNumbers(first, second);

        Assertions.assertEquals(expectedResult, actualResult);
    }


}
