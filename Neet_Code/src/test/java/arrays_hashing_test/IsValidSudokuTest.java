package arrays_hashing_test;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import arrays_hashing.IsValidSudoku;
import test_base.TesterRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IsValidSudokuTest extends TesterRunner {

    private IsValidSudoku ab;

    @BeforeEach
    void setUp() throws Exception {
        ab = new IsValidSudoku();
    }

    @Order(1)
    @ParameterizedTest
    @MethodSource("provideTestData")
    void IsValidSudokuBruteTestCase1(char[][] nums1, boolean expected) {
        boolean result = ab.isValidSudokuBrute(nums1);
        runTestEquals(expected, result);
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("provideTestData")
    void IsValidSudokuHashSetTestCase2(char[][] nums1, boolean expected) {
        boolean result = ab.isValidSudokuHashMap(nums1);
        runTestEquals(expected, result);
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("provideTestData")
    void IsValidSudokuBitmaskTestCase3(char[][] nums1, boolean expected) {
        boolean result = ab.isValidSudokuBitmask(nums1);
        runTestEquals(expected, result);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new char[][] {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }, true),
                Arguments.of(new char[][] {
                        {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                        {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }, false)
        );
    }
}
