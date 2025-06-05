package ait.reflection.infra;


import ait.reflection.model.Foo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
public class FooUtils {
    public static void caller(String functionName, String arg) {
        // применение рефлексии
        Class<Foo> clazz = Foo.class;
        try {
            Method method = clazz.getDeclaredMethod(functionName, String.class);
            method.setAccessible(true);
            // method.invoke(new Foo(), arg); // метод 1
            Constructor constructor = clazz.getDeclaredConstructor();
            method.invoke(constructor.newInstance(), arg);
//            method.invoke(clazz.newInstance(), arg); // метод 2
        } catch (Exception e) {
            System.out.println(functionName + " doesn't exist");;
        }


//        Foo foo = new Foo();
//        switch (functionName) {
//            case "f1":
//                foo.f1(arg);
//                break;
//            case "f2":
//                foo.f2(arg);
//                break;
//            case "f3":
//                foo.f3(arg);
//                break;
//            default:
//                System.out.println(functionName + " doesn't exist");
//        }
    }
}
