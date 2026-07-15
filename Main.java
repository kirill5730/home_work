import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades != null ? grades : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}

class PhoneBook {
    private final Map<String, List<String>> data = new HashMap<>();

    public void add(String surname, String phone) {
        data.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    public List<String> get(String surname) {
        List<String> phones = data.get(surname);
        return phones != null ? phones : Collections.emptyList();
    }
}

public class Main {

    public static void removeLowPerformers(Set<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3.0) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ЗАДАНИЕ 1: Студенты ===");

        Set<Student> students = new HashSet<>();
        students.add(new Student("Елена", "ПИ-21", 2, Arrays.asList(5, 4, 5)));
        students.add(new Student("Дмитрий", "ПИ-21", 2, Arrays.asList(2, 2, 2)));
        students.add(new Student("Ольга", "КТ-32", 3, Arrays.asList(4, 4, 3)));
        students.add(new Student("Кирилл", "КТ-32", 3, Arrays.asList(3, 3, 4)));

        System.out.println("До обработки:");
        System.out.println("Курс 2:");
        printStudents(students, 2);
        System.out.println("Курс 3:");
        printStudents(students, 3);

        removeLowPerformers(students);
        promoteStudents(students);

        System.out.println("\nПосле обработки:");
        System.out.println("Курс 3:");
        printStudents(students, 3);
        System.out.println("Курс 4:");
        printStudents(students, 4);


        System.out.println("\n=== ЗАДАНИЕ 2: Телефонный справочник ===");

        PhoneBook book = new PhoneBook();
        book.add("Смирнова", "+79991110022");
        book.add("Смирнова", "+79993334455");
        book.add("Волков", "+79996667788");

        System.out.println("Телефоны для Смирнова:");
        for (String p : book.get("Смирнова")) {
            System.out.println(p);
        }

        System.out.println("Телефоны для Волков:");
        for (String p : book.get("Волков")) {
            System.out.println(p);
        }

        System.out.println("Телефоны для Зайцев (нет в справочнике):");
        for (String p : book.get("Зайцев")) {
            System.out.println(p);
        }
    }
}