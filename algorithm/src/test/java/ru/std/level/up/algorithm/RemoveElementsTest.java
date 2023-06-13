package ru.std.level.up.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class RemoveElementsTest {

    @DisplayName("[LC] 26. Remove Duplicates from Sorted Array")
    @ParameterizedTest
    @MethodSource
    public void removeDuplicates(int[] nums, int result) {
        if (nums.length == 0) return;/*return 0*/
        int idx = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] == nums[i]) {
                continue;
            }
            nums[++idx] = nums[i];
            count++;
        }
        Assertions.assertEquals(count, result);
    }

    @DisplayName("[LC] 27. Remove Element")
    @ParameterizedTest
    @MethodSource
    public void removeElement(int[] nums, int val, int result) {
        int ind = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
                if (ind == -1) {
                    ind = i;
                }
                continue;
            }

            if (ind != -1) {
                int swap = nums[ind];
                nums[ind] = nums[i];
                nums[i]=swap;
                if ((ind - i) != 1) {
                    ind++;
                } else {
                    ind = -1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        Assertions.assertEquals(nums.length - count, result);
    }


    static Stream<Arguments> removeDuplicates() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 3, 3, 3, 3, 69}, 3),
                Arguments.of((Object) new int[]{1}, 1),
                Arguments.of((Object) new int[]{1, 10}, 2),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 4, 4, 5, 6, 6}, 6),
                Arguments.of((Object) new int[]{}, 0)
        );
    }

    static Stream<Arguments> removeElement() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 3, 3, 3, 3, 69}, 3, 3),
                Arguments.of((Object) new int[]{3,2,2,3}, 3, 2),
                Arguments.of((Object) new int[]{1}, 1, 0),
                Arguments.of((Object) new int[]{1, 10}, 2, 2),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 4, 4, 5, 6, 6}, 6, 7),
                Arguments.of((Object) new int[]{}, 0, 0)
        );
    }
}
