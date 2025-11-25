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

    public double getAverageGrade() {
        double sum = 0;
        for (int g : grades) sum += g;
        return sum / grades.length;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student:");
        System.out.println("Name: " + name + ", Age: " + age);

        System.out.print("Grades: ");
        for (int g : grades) System.out.print(g + " ");

        System.out.print("\nSubjects: ");
        for (String s : subjects) System.out.print(s + " ");

        System.out.println("\nAverage grade: " + getAverageGrade());
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
        for (String s : subjects) System.out.print(s + " ");
        System.out.println();
    }
}

public class Main {

    public static double getAverageForAllStudents(Student[] students) {
        double sum = 0;
        int count = 0;
        for (Student st : students) {
            sum += st.getAverageGrade();
            count++;
        }
        return sum / count;
    }

    public static void main(String[] args) {

        Student st1 = new Student("Mark", 19, new int[]{95, 87, 90}, new String[]{"Math", "Chemistry"});
        Student st2 = new Student("Anna", 20, new int[]{85, 90, 92}, new String[]{"Biology", "English"});
        Student st3 = new Student("Tom", 18, new int[]{70, 75, 80}, new String[]{"Physics", "History"});

        Teacher th = new Teacher("Johnson", 48, 5100.00, new String[]{"Biology", "Science"});

        Student[] students = {st1, st2, st3};

        st1.displayInfo();
        System.out.println();
        st2.displayInfo();
        System.out.println();
        st3.displayInfo();
        System.out.println();

        th.displayInfo();

        double avgAll = getAverageForAllStudents(students);
        System.out.println("\nAverage grade of ALL students: " + avgAll);
    }
}
