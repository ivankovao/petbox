package com.sandbox.pet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LeetTasks {

    @ParameterizedTest(name = "{index} - {0} - Valid Parentheses")
    @ValueSource(strings = {"[{}]{}", "", "{]{}}[", "{}", "{", "[", "(", ")"})
    void testParentheses(String s) {
        boolean result = true;
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.addLast(s.charAt(i));
                continue;
            } else if (!stack.isEmpty() && map.get(stack.removeLast()).equals(s.charAt(i))) {
                continue;
            }
            result = false;
            break;
        }
        assertTrue(result);
        assertTrue(stack.isEmpty());
    }

    


}
