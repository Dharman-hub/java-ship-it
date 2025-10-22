package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import ru.yandex.practicum.delivery.ParcelBox.ParcelBox;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.FragileParcel;

public class AddParcelTest {
    private static FragileParcel littleFragileParcel;
    private static FragileParcel bigFragileParcel;
    private static final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(100);

    @BeforeAll
    public static void beforeAll() {
        littleFragileParcel = create(20);
        bigFragileParcel = create(1000);
    }

    @Test
    public void TheMaximumWeightIsNotExceeded() {
        assertTrue(fragileParcelBox.addParcel(littleFragileParcel));
    }

    @Test
    public void TheMaximumWeightIsExceeded() {
        assertFalse(fragileParcelBox.addParcel(bigFragileParcel));
    }

    public static FragileParcel create(int weight) {
        return new FragileParcel("люстры", weight,
                "Парашютная 65", 22);
    }
}
