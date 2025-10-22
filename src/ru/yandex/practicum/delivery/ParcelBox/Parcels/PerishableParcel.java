package ru.yandex.practicum.delivery.ParcelBox.Parcels;

public class PerishableParcel extends Parcel{
    protected final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public double getCostOfParcel() {
        return perishableParcelCost;
    }

    public boolean isExpired(int currentDay) {
        return !(sendDay + timeToLive >= currentDay);
    }
}
