package ru.std.level.up.algorithm;

import org.junit.jupiter.params.ParameterizedTest;

import java.util.HashMap;
import java.util.Map;

class LeetCodeEasyTest {

    @ParameterizedTest(name = "{index}:Two Sum - {0}")
    public int[] twoSum (int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) return new int[]{m.get(target - nums[i]), i};

            m.put(nums[i], i);
        }
        return new int[0];
    }

//    String[][] strings = {
//            {""},
//            {"a"},
//            {"ab", ""},
//            {"ab", "a"},
//            {"a", "ab"},
//            {"flower", "flow", "flight"},
//            {"dog", "racecar", "car"}};
    public static String longestCommonPrefix(String[] strs) {
        int ind = -1;
        boolean br = false;
        if (strs.length == 1) return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int k = 1; k < strs.length; k++) {
                if (!(strs[k].length() - 1 >= i && strs[k].charAt(i) == strs[0].charAt(i))) {
                    br = true;
                    break;
                } else {
                    if (k == strs.length - 1) ind = i;
                }

                if (strs[k].length() - 1 == i && !br) {
                    br = true;
                }
            }
            if (br) break;
        }
        return ind < 0 ? "" : strs[0].substring(0, ind + 1);
    }

    /**
     * 1231
     * 133
     * 131
     * 2
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x / 10;
        int z = x % 10;
        while (y >= 1) {
            z = z * 10 + (y % 10);
            y = y / 10;
        }

        return x == z;
    }

}