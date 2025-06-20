package ait.cohort5860.consultation.model;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.06.2025)
 */
@Builder
@ToString
public class User {
    private String firstName;
    //вщ всех конструкторах
    private String lastName;
    private int age;
    private boolean status;
    private String email;
    // во всех конструкторах
    private String password;
    private boolean isActive;
    @Singular
    private List<String> hobbies;
}
