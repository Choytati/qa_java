package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensShouldReturnValidValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedResult = new Random().nextInt(50);
        Mockito.when(feline.getKittens()).thenReturn(expectedResult);
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodShouldReturnValidValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedResult = List.of("Крокодилы", "Бегемоты", "Попугай");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }
}
