abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void displayInfo();
}

class Student extends Person {
    private int[] grades;
    private String[] subjects;

    public Student(String name, int age, int[] grades, String[] subjects) {
        super(name, age);
        this.grades = grades;
        this.subjects = subjects;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student:");
        System.out.println("Name: " + name + ", Age: " + age);

        System.out.print("Grades: ");
        for (int g : grades) {
            System.out.print(g + " ");
        }

        System.out.print("\nSubjects: ");
        for (String s : subjects) {
            System.out.print(s + " ");
        }

        double sum = 0;
        for (int g : grades) {
            sum += g;
        }
        double average = sum / grades.length;

        System.out.println("\nAverage grade: " + average);
    }
}

class Teacher extends Person {
    private double salary;
    private String[] subjects;

    public Teacher(String name, int age, double salary, String[] subjects) {
        super(name, age);
        this.salary = salary;
        this.subjects = subjects;
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher:");
        System.out.println("Name: " + name + ", Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.print("Subjects taught: ");
        for(String s : subjects) System.out.print(s + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Student st = new Student(
                "Mark",
                19,
                new int[]{95, 87, 90},
                new String[]{"Math", "Chemistry"}
        );

        Teacher th = new Teacher(
                "Johnson",
                48,
                5100.00,
                new String[]{"Biology", "Science"}
        );

        st.displayInfo();
        System.out.println();
        th.displayInfo();
    }
}
