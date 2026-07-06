class Product {
    String name;
    String date;
    String manufacturer;
    String country;
    int price;
    boolean isReserved;

    Product(String name, String date, String manufacturer,
            String country, int price, boolean isReserved) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    void show() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + date);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        if (isReserved) {
            System.out.println("Состояние бронирования покупателем: зарезервирован");
        } else {
            System.out.println("Состояние бронирования покупателем: свободен");
        }
        System.out.println();
    }
}

class Park {
    static class Attraction {
        String name;
        String hours;
        int cost;

        Attraction(String name, String hours, int cost) {
            this.name = name;
            this.hours = hours;
            this.cost = cost;
        }

        void show() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Часы работы: " + hours);
            System.out.println("Стоимость: " + cost + " руб.");
            System.out.println();
        }
    }

    Attraction[] list;

    Park(Attraction[] list) {
        this.list = list;
    }

    void printAll() {
        for (int i = 0; i < list.length; i++) {
            list[i].show();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Sony WH-1000XM5", "15.03.2025",
                "Sony Corporation", "Japan", 32000, false);
        productsArray[2] = new Product("Apple MacBook Air M3", "10.01.2025",
                "Apple Inc.", "USA", 120000, true);
        productsArray[3] = new Product("Xiaomi Redmi Note 14", "20.02.2025",
                "Xiaomi Corporation", "China", 22000, false);
        productsArray[4] = new Product("Bose QuietComfort Ultra", "05.04.2025",
                "Bose Corporation", "USA", 45000, false);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].show();
        }

        Park.Attraction[] attractions = new Park.Attraction[3];
        attractions[0] = new Park.Attraction("Колесо обозрения", "10:00–22:00", 350);
        attractions[1] = new Park.Attraction("Американские горки", "11:00–21:00", 400);
        attractions[2] = new Park.Attraction("Карусель", "10:00–20:00", 200);

        Park park = new Park(attractions);
        park.printAll();
    }
}