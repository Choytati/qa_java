package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    String sex;
    boolean expectedResult;
    public LionParametrizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters(name = "{index}: sex = {0}, heHasMane() = {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Львёнок", true}
        };
    }

    @Test
    public void constructorShouldVerifySex() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
            boolean actualResult = lion.doesHaveMane();
            assertEquals(expectedResult, actualResult);
        } catch (Exception e) {
            assertEquals(expectedResult, e.getMessage().equals("Используйте допустимые значения пола животного - самей или самка"));
        }
    }
}
