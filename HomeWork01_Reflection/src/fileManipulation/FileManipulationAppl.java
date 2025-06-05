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

        //1. read file and get list with text
        List<String> manipulatedList = FileUtils.readLines(args[0]);

        //2. made operation with read information
        ManipulationUtils.caller(args[2], manipulatedList);

        //3. write results to the output file
        FileUtils.writeLines(args[1], manipulatedList);

    }
}
