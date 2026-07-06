class Animal {
    protected String name;
    protected static int countAnimals = 0;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " не знает, как бежать");
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public static int getCountAnimals() {
        return countAnimals;
    }
}

class Dog extends Animal {
    private static int countDogs = 0;
    private final int MAX_RUN = 500;
    private final int MAX_SWIM = 10;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " устал и не смог пробежать " + distance + " м. Максимум: " + MAX_RUN + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м. Максимум: " + MAX_SWIM + " м.");
        }
    }

    public static int getCountDogs() {
        return countDogs;
    }
}

class Cat extends Animal {
    private static int countCats = 0;
    private final int MAX_RUN = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        countCats++;
        isFull = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " устал и не смог пробежать " + distance + " м. Максимум: " + MAX_RUN + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public boolean eat(Bowl bowl, int amount) {
        if (!isFull && bowl.hasEnoughFood(amount)) {
            bowl.reduceFood(amount);
            isFull = true;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCountCats() {
        return countCats;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        foodAmount = initialFood;
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }

    public boolean hasEnoughFood(int needed) {
        return foodAmount >= needed;
    }

    public void reduceFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double a;
    private double b;
    private double c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        dogBobik.run(150);
        dogBobik.swim(5);

        Cat catBarsik = new Cat("Барсик");
        catBarsik.run(100);
        catBarsik.swim(3);

        System.out.println("Всего животных: " + Animal.getCountAnimals());
        System.out.println("Собак: " + Dog.getCountDogs());
        System.out.println("Котов: " + Cat.getCountCats());

        Bowl bowl = new Bowl(10);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Пушок");
        cats[2] = new Cat("Снежок");

        for (Cat cat : cats) {
            cat.eat(bowl, 5);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + cats[i].name + " сыт: " + cats[i].isFull());
        }

        bowl.addFood(20);
        System.out.println("Еды в миске теперь: " + bowl.getFoodAmount());

        Shape circle = new Circle(5, "красный", "чёрный");
        System.out.println("\nКруг:");
        circle.printInfo();

        Shape rectangle = new Rectangle(4, 6, "зелёный", "синий");
        System.out.println("\nПрямоугольник:");
        rectangle.printInfo();

        Shape triangle = new Triangle(3, 4, 5, "жёлтый", "фиолетовый");
        System.out.println("\nТреугольник:");
        triangle.printInfo();
    }
}