package ru.std.level.up.algorithm.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LengthOfLastWord {

    @DisplayName(value = "58. Length of Last Word")
    @ParameterizedTest(name = "{index} - {0} target result {2}")
    @MethodSource
    public void lengthOfLastWord(String s, int result) {
        int actual = lengthOfLastWord(s);
        Assertions.assertEquals(result, actual);
    }

    private int lengthOfLastWord(String s) {
        int cur = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 32 && cur != 0) break;
            if (s.charAt(i) != 32) cur++;
        }
        return cur;
    }

    static Stream<Arguments> lengthOfLastWord() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of(" ", 0),
                Arguments.of("", 0),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }
}
