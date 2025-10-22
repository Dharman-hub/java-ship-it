package ru.yandex.practicum.delivery.ParcelBox;


import ru.yandex.practicum.delivery.ParcelBox.Parcels.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.Parcel;

import ru.yandex.practicum.delivery.ParcelBox.Parcels.PerishableParcel;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.StandardParcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    List<T> parcels = new ArrayList<>();
    protected final double maxWeight;

    public ParcelBox(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        if(maxWeight >=  getWeightOfParcels() + parcel.getWeight()) {
            parcels.add(parcel);
            System.out.println("Поместили посылку в коробку");
            return true;
        } else {
            System.out.println("В коробке больше нет места для посылок");
            return false;
        }
    }

    public double getWeightOfParcels() {
        double weight = 0;
        for (T parcel: parcels) {
            weight += parcel.getWeight();
        }
        return weight;
    }

    public void getAllParcels() {
        if (!parcels.isEmpty()) {
            if (parcels.getFirst() instanceof StandardParcel) {
                System.out.println("Достали посылки из коробки");
            } else if (parcels.getFirst() instanceof FragileParcel) {
                System.out.println("Достали хрупкие посылки из коробки");
            } else if (parcels.getFirst() instanceof PerishableParcel) {
                System.out.println("Достали скоропортящиеся посылки из коробки");
            }
        } else {
            System.out.println("Коробка была пустая");
        }
        parcels.clear();
    }

    public void contentOfTheBox() {
        for (T parcel: parcels) {
            System.out.println(parcel.getDescription());
        }
    }
}
