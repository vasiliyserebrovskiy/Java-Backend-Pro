package fileManipulation;

import fileManipulation.infra.ManipulationUtils;
import fileManipulation.utils.FileUtils;

import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
public class FileManipulationAppl {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Wrong number of arguments");
            return;
        }
        // 1. Read input file
        List<String> manipulatedList = FileUtils.readLines(args[0]);

        // 2. Manipulate data
        ManipulationUtils.caller(args[2], manipulatedList);

        // 3. Write result to the file
        FileUtils.writeLines(args[1], manipulatedList);

    }
}
