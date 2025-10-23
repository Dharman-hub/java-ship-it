package ru.yandex.practicum.delivery.ParcelBox.Parcels;

import ru.yandex.practicum.delivery.Trackable;

public class FragileParcel extends Parcel implements Trackable {

    protected static final double fragileParcelCost = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double getCostOfParcel() {
        return fragileParcelCost;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку и упакована");// 1 исправление
        //переопределил нужный метод
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description +">> изменила местоположение на " + newLocation);
    }
}
