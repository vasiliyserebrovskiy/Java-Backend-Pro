package consultation_19_06_25;

import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.06.2025)
 */
public class Args {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        System.out.println(args[1].length());
        int param1 = Integer.parseInt(args[1]);
        System.out.println(param1 + 10);
    }
}
