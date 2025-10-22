package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IsExpiredTest {
    private final PerishableParcel perishableParcel = new PerishableParcel("бананы", 60,
            "Мадагаскар", 22, 7);

    @Test
    public void notExpired() {
        assertFalse(perishableParcel.isExpired(24));
    }

    @Test
    public void expired() {
        assertTrue(perishableParcel.isExpired(30));
    }
}
