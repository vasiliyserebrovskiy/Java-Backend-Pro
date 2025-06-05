package consultation_05_06_25;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
public class MagicDemo {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Alex");

        // Находим приватное поле по имени
        Field nameField = Person.class.getDeclaredField("name");

        // Открываем доступ к полю
        nameField.setAccessible(true);
        System.out.println("Старое имя: " + nameField.get(person)); // вывод - Maria
        // Меняю значение поля у объекта Person
        nameField.set(person, "Maria");

        // Проверяем сработало ли изменение
        System.out.println("Новое имя: " + nameField.get(person)); // вывод - Maria

        // Возвращаю полю приватность
        nameField.setAccessible(false);

        System.out.println("===============");

        // Нахожу приватный метод

        Method sayHelloMethod = Person.class.getDeclaredMethod("sayHello");
        Method sayHelloMethod2 = Person.class.getDeclaredMethod("sayHello", String.class);
        sayHelloMethod.setAccessible(true);
        sayHelloMethod2.setAccessible(true);

        // вызываем метод на исполнение
        sayHelloMethod.invoke(person);
        sayHelloMethod2.invoke(person, "argument");

        sayHelloMethod.setAccessible(false);

        System.out.println("===============");
        // Создание объекта через доступ к конструктору, который вытягиваем через рефлексию
        Class<?> clazz = Class.forName("consultation_05_06_25.Person");

        Constructor<?> constructor = clazz.getConstructor(String.class);

        Object object = constructor.newInstance("Peter");

        if (object instanceof Person) {
            Person person2 = (Person) object;
            System.out.println(person2);
        }

        System.out.println("===============");

        //Создать массив строк
        int arrayLength = 10;
        Class<String> componentType = String.class;

        //Object array =  Array.newInstance(componentType, arrayLength);
        String[] array = (String[]) Array.newInstance(componentType, arrayLength);
        // Установить значение в нулевую ячейку
        Array.set(array, 0, "Peter");

        // Получить значение по индексу

        System.out.println(Arrays.toString(array));
        // Значение нулевой ячейки
        String value = (String) Array.get(array,0);
        System.out.println("Значение в ячейке 0: "+value);
    }
}
