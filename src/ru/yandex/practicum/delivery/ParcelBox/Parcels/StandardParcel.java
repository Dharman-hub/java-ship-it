package ru.yandex.practicum.delivery.ParcelBox.Parcels;

public class StandardParcel extends Parcel {

    protected static final double standardParcelCost = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double getCostOfParcel() {
        return standardParcelCost;
    }
}
