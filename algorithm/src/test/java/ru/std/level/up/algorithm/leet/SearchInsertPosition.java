package ru.std.level.up.algorithm.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInsertPosition {

    @DisplayName(value = "35:Search Insert Position")
    @ParameterizedTest(name = "{index} - {0} target {1} result {2}")
    @MethodSource
    public void searchInsert(int[] nums, int target, int result) {
        int actual = searchInsert2(nums, target);
        Assertions.assertEquals(result, actual);
    }

    //мой вариант решения
    private int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int cur = ((end - start) / 2) + start;
        while (start <= end) {
            if (nums[cur] == target) {
                return cur;
            }
            //проверяем границы
            if (nums[start]>=target) return start;
            if (nums[end]<target) return end+1;
            if (cur == start) return start+1;

            if(nums[cur] > target) {
                end = cur-1;
            } else {
                start = cur;
            }
            cur = ((end - start) / 2) + start;
        }
        return cur;
    }

    //решение оптимальнее: убираем лишние проверки и просто схлапываем промежуток ->..<-, если старт выместился за пределы допустимого это и будет результатом.
    private int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int cur = ((end - start) / 2) + start;
        while (start <= end) {
            if (nums[cur] == target) {
                return cur;
            }
            if(nums[cur] > target) {
                end = cur-1;
            } else {
                start = cur+1;
            }
            cur = ((end - start) / 2) + start;
        }
        return start;
    }

    static Stream<Arguments> searchInsert() {
        return Stream.of(
                Arguments.of(new int[]{}, 0, 0),
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{1}, 3, 1),
                Arguments.of(new int[]{3}, 1, 0),
                Arguments.of(new int[]{1, 10}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 10, 20}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 10, 20}, 6, 3),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 10, 20}, 15, 6),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 10, 20}, 22, 7),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 10, 20}, 9, 5),
                Arguments.of(new int[]{1, 3, 5, 7, 8, 10, 20}, 1, 0)
        );
    }
}
