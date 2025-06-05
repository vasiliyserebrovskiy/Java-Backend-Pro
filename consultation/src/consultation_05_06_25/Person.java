package consultation_05_06_25;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                '}';
    }

    private void sayHello() {
        System.out.println("Привет, меня зовут " + name);
    }

    private void sayHello(String str) {
        System.out.println("Привет, " + str);
    }
}
