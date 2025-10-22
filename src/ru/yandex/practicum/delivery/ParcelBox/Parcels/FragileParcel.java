package ru.yandex.practicum.delivery.ParcelBox.Parcels;

import ru.yandex.practicum.delivery.Trackable;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double getCostOfParcel() {
        return fragileParcelCost;
    }

    @Override
    public void delivery() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.delivery();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description +">> изменила местоположение на " + newLocation);
    }
}
