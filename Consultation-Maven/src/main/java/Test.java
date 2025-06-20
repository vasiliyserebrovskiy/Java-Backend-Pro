import lombok.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (17.06.2025)
 */

// During compilation lombok add all method to our class automatically.
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor // constructor with all fields which are final.
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@Data // include @RequiredArgsConstructor, @Setter, @Getter, @ToString - some more. Need to set
//@Builder // read what it is
public class Test {

   private String title;
   private boolean status;
   private int score;


}
