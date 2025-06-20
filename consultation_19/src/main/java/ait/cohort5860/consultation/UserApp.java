package ait.cohort5860.consultation;

import ait.cohort5860.consultation.model.User;
import ait.cohort5860.consultation.model.UserBuilder;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.06.2025)
 */
public class UserApp {
    public static void main(String[] args) {

        User user = User.builder()
                .firstName("Anna")
                .lastName("Smith")
                .age(25)
                .build();

        User user1 = User.builder()
                .lastName("Smirnof")
                .password("1234")
                .email("test@test.com")
                .hobby("Reading")
                .hobby("Walking")
                .hobby("music")
                .build();

        System.out.println(user.toString());
        System.out.println(user1.toString());

        UserBuilder userBuilder = UserBuilder.builder()
                .firstName("Anna")
                .lastName("Smith")
                .age(35)
                .build();

        System.out.println(userBuilder.toString());
    }
}
