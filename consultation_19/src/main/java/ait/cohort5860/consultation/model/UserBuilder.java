package ait.cohort5860.consultation.model;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.06.2025)
 */

public class UserBuilder {
    private String firstName;
    private String lastName;
    private int age;

    //Приватный конструктор
    private UserBuilder(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "UserBuilder {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Статический вложенный класс
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder build() {
            return new UserBuilder(this);
        }
    }


}
