package ru.std.level.up.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {
    /**
     * Given two strings needle and haystack,
     * return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    @DisplayName("28. Find the Index of the First Occurrence in a String")
    @ParameterizedTest
    @CsvSource(value = {
            "mississippi, sippia, -1",
            "mississippi, issipi, -1",
            "mississippi, issip, 4",
            "a, ab, -1",
            "a, a, 0",
            "ab, a, 0",
            "ab, ab, 0",
            "sadbutsad, sad, 0",
            "leetcode, leeto, -1"
    })
    public void strStr(String str, String subStr, int result) {
        int idx = -1;
        int j = 0;

        if(subStr.length()>str.length()) return;
        for (int i = 0; i < str.length() && j < subStr.length(); i++) {
            if (str.charAt(i) == subStr.charAt(j)) {
                if (idx == -1) {
                    idx = i;
                }
                if(j==subStr.length()-1) break;
                if (j!=subStr.length()-1 && i == str.length()-1) {
                    idx=-1;
                }
                j++;
                continue;
            }

            if (idx != -1) {
                i=idx;
                idx = -1;
                j = 0;
            }
        }
        Assertions.assertEquals(result, idx);
    }
}
