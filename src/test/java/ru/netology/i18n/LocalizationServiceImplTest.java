package ru.netology.i18n;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizationServiceImplTest {
    LocalizationServiceImpl sut;

    @BeforeEach
    void initLocal() {
        sut = new LocalizationServiceImpl();
    }

    @AfterEach
    void endLocal() {
        sut = null;
    }

    @Test
    void testLocalFirst() {
        Country country = Country.RUSSIA;
        String result = sut.locale(country);
        String expected = "Добро пожаловать";
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"GERMANY", "USA", "BRAZIL"})
    void testLocalSecond(Country country) {
        String result = sut.locale(country);
        String expected = "Велком";
        assertEquals(expected, result);
    }
}
