package fileManipulation.infra;

import fileManipulation.model.FileManipulationMethods;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
public class ManipulationUtils {
    public static void caller(String functionName, List<String> inList) {
        Class<FileManipulationMethods> clazz = FileManipulationMethods.class;

        try {
            Method method = clazz.getDeclaredMethod(functionName, List.class);
            method.invoke(new FileManipulationMethods(), inList);
        } catch (Exception e) {
            System.out.println(functionName + " doesn't exist!");
        }

    }
}
