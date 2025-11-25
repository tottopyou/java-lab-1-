import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class PersonStorage {
    private final String filename;

    public PersonStorage(String filename) {
        this.filename = filename;
    }

    public void save(Collection<Person> persons) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(persons));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Person> load() throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Person>) ois.readObject();
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Student st1 = new Student("Mark", 19, new int[]{95, 87, 90}, new String[]{"Math", "Chemistry"});
        Student st2 = new Student("Anna", 20, new int[]{85, 90, 92}, new String[]{"Biology", "English"});
        Teacher th1 = new Teacher("Johnson", 48, 5100.00, new String[]{"Biology", "Science"});

        List<Person> persons = new ArrayList<>();
        persons.add(st1);
        persons.add(st2);
        persons.add(th1);

        PersonStorage storage = new PersonStorage("persons.dat");

        try {
            storage.save(persons);
            System.out.println("Persons saved to file.");
        } catch (IOException e) {
            System.err.println("Error while saving persons: " + e.getMessage());
        }

        try {
            List<Person> loaded = storage.load();
            System.out.println("\nLoaded persons from file:\n");
            for (Person p : loaded) {
                p.displayInfo();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while loading persons: " + e.getMessage());
        }
    }
}
