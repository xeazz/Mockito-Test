package ru.netology.geo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTest {
    GeoServiceImpl sut;

    @BeforeEach
    void initStart() {
        sut = new GeoServiceImpl();
    }

    @AfterEach
    void endInit() {
        sut = null;
    }

    @MethodSource("source")
    @ParameterizedTest
    void testGeoServiceByIp(String ip, String expected) {
        Location location = sut.byIp(ip);
        String result = location.getCity();
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of("127.0.0.1", null),
                Arguments.of("172.0.32.11", "Moscow"),
                Arguments.of("96.44.183.149", "New York"),
                Arguments.of("172.0.0.8", "Moscow"),
                Arguments.of("96.1.1.1", "New York"));
    }

    @Test
    void testByCoordinates() {
        double latitude = 50.333;
        double longitude = 333.2;
        assertThrows(ArrayStoreException.class, () -> sut.byCoordinates(latitude, longitude));

    }

}
