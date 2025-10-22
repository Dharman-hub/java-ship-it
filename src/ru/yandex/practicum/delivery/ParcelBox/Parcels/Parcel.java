package ru.yandex.practicum.delivery.ParcelBox.Parcels;

public abstract class Parcel {
   protected final String description;
   protected final int weight;
   protected final String deliveryAddress;
   protected final int sendDay;
   protected static final double standardParcelCost = 2;
   protected static final double fragileParcelCost = 4;
   protected static final double perishableParcelCost = 3;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void delivery() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    public abstract double getCostOfParcel();

    public double calculateDeliveryCost() {
       return getCostOfParcel() * weight;
    }
}
