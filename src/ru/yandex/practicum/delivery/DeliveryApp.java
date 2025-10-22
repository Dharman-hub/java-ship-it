package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.ParcelBox.ParcelBox;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.Parcel;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.PerishableParcel;
import ru.yandex.practicum.delivery.ParcelBox.Parcels.StandardParcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragilebox  = new ParcelBox<>(30);
    private static final ParcelBox<PerishableParcel>  perishableBox = new ParcelBox<>(60);

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackingParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    tracking();
                    break;
                case 5:
                    boxContent();
                    break;
                case 6:
                    isExpiredParcel();
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Указать месторасположение посылки");
        System.out.println("5 — Узнать содержимое коробки");
        System.out.println("6 — Узнать состояние скоропортящейся посылки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Посылку какого типа вы хотите добавить?");
        System.out.println("1 — Добавить стандартную посылку");
        System.out.println("2 — Добавить хрупкую посылку");
        System.out.println("3 — Добавить скоропортящуюся посылку");
        int number = Integer.parseInt(scanner.nextLine());


        System.out.println("Опишите содержимое посылки");
        String content = scanner.nextLine();

        System.out.println("Укажите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());


        System.out.println("Укажите адрес доставки");
        String address = scanner.nextLine();

        System.out.println("Укажите дату отправки посылки");
        int sendDay = Integer.parseInt(scanner.nextLine());


        switch (number) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(content, weight, address, sendDay);
                if (standardBox.addParcel(standardParcel)) {
                    allParcels.add(standardParcel);
                    System.out.println("Посылка была добавлена!");
                }
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(content, weight, address, sendDay);
                if (fragilebox.addParcel(fragileParcel)) {
                    allParcels.add(fragileParcel);
                    trackingParcels.add(fragileParcel);
                    System.out.println("Посылка была добавлена!");
                }
                break;
            case 3:
                System.out.println("Укажите срок, по истечении которого посылка станет негодной");
                System.out.println("(Срок указывайте в днях)");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(content, weight, address, sendDay, timeToLive);
                if (perishableBox.addParcel(perishableParcel)) {
                    allParcels.add(perishableParcel);
                    System.out.println("Посылка была добавлена!");
                }
                break;
            default:
                System.out.println("Введено некорректное значение");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        System.out.println("Посылки были отправлены!");
        standardBox.getAllParcels();
        fragilebox.getAllParcels();
        perishableBox.getAllParcels();
        for (Parcel p: allParcels) {
            p.packageItem();
            p.delivery();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double totalSum = 0;
        for (Parcel p: allParcels) {
            totalSum += p.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех посылок: " + totalSum);
    }

    private static void boxContent() {
        System.out.println("Содержимое коробки c какими посылками вы хотите узнать?");
        System.out.println("1 — стандартными");
        System.out.println("2 — хрупкими");
        System.out.println("3 — скоропортящимися");
        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {
            case 1:
                standardBox.contentOfTheBox();
                break;
            case 2:
                fragilebox.contentOfTheBox();
                break;
            case 3:
                perishableBox.contentOfTheBox();
                break;
            default:
                System.out.println("Введено некорректное значение");
        }
    }

    private static void tracking() {
        System.out.println("Введите новое месторасположение посылок");
        String newLocation = scanner.nextLine();
        for (Trackable p: trackingParcels) {
            p.reportStatus(newLocation);
        }
    }

    private static void isExpiredParcel() {
        List<PerishableParcel> box = new ArrayList<>();
        int number = 0;
        System.out.println("Состояние какой посылки вы хотите узнать?");
        for (Parcel p: allParcels) {
            if (p instanceof PerishableParcel) {
                System.out.println(number + " — " + p.getDescription());
                number++;
                box.add((PerishableParcel)p);
            }
        }
        int answer = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите текущий день месяца");
        int currentDay = Integer.parseInt(scanner.nextLine());

        if (box.get(answer).isExpired(currentDay)) {
            System.out.println("Ваша посылка испортилась :(");
        } else {
            System.out.println("Ваша посылка не испортилась");
        }
    }
}

