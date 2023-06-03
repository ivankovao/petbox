package com.sandbox.pet;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondTest extends AbstractTestClass{

    @Test
    @DisplayName("second")
    @SneakyThrows
    void test_second_context() {
        Thread.sleep(3000);
        assertEquals(1, 0+1);
    }
}
