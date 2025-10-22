package ru.yandex.practicum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.yandex.practicum.delivery.ParcelBox.Parcels.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.PerishableParcel;

public class DeliveryCostTest {
    private final FragileParcel fragileParcel = new FragileParcel("очки", 10,
            "Парашютная 65", 22);

    private final PerishableParcel perishableParcel = new PerishableParcel("бананы", 60,
            "Мадагаскар", 22, 7);

    @Test
    public void fragileParcelDeliveryCost() {
        assertEquals(40, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void perishableParcelDeliveryCost() {
        assertEquals(180, perishableParcel.calculateDeliveryCost());
    }
}
