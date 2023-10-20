package ru.std.level.up.algorithm.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlusOne {

    @DisplayName(value = "66. Plus One")
    @ParameterizedTest(name = "{index} - {0} target result {2}")
    @MethodSource
    public void plusOne(int[] arr, int[] result) {
        int[] actual = plusOne(arr);
        Assertions.assertArrayEquals(result, actual);
    }

    private int[] plusOne(int[] arr) {
        int cur = 1;
        int dif;
        for (int i = arr.length - 1; i >= 0; i--) {
            dif = arr[i] + cur;
            cur = dif >= 10 ? 1: 0 ;
            arr[i]=dif%10;
        }
        if (cur > 0) {
            int[] arr2 = new int[arr.length+1];
            arr2[0]=1;
            for (int i = 0; i <= arr.length - 1; i++) {
                arr2[i+1] = arr[i];
            }
            return arr2;
        }
        return arr;
    }

    static Stream<Arguments> plusOne() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}),
                Arguments.of(new int[]{9}, new int[]{1,0}),
                Arguments.of(new int[]{0}, new int[]{1}),
                Arguments.of(new int[]{}, new int[]{1})
        );
    }
}
