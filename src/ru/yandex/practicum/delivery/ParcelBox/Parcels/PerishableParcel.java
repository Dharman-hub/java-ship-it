package ru.yandex.practicum.delivery.ParcelBox.Parcels;

public class PerishableParcel extends Parcel{
    protected final int timeToLive;

    protected static final double perishableParcelCost = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public double getCostOfParcel() {
        return perishableParcelCost;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive <= currentDay;//исправление 4, убрал конвертацию сравнения
    }
}
