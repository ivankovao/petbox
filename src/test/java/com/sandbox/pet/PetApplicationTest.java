package com.sandbox.pet;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
class PetApplicationTest  extends AbstractTestClass {

    @Test
    @SneakyThrows
    void contextLoadsTest() {
        Thread.sleep(3000);
        assertEquals(1, 0+1);
    }

}
