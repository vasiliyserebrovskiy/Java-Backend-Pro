package ait.reflection;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
public class ReflectionAppl {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1 Каждому типу, класс, интерфейс, тип и enum Объект, соответствует объект рефлексии, который храниться в class loader.
        // Каждому классу соответствует только один объект рефлексии
        // java - строго типизированный язык. Все объекты имеют конкретный тип, Объект рефлексии имеет класс/тип, который называется Class
            // class Class {};
        // 2 Объект рефлексии имеют тип Class. (Второй по значимости после Object) Мы не можем их создавать

        // Можно ли получить ссылку на объект рефлексии? Да можно.
        // 3 Можно получить ссылку

        Class<String> clazzStr1 = String.class; // первый метод - ссылка на объект рефлексии, соответствующий типу String
        String str = "hello";
        // получить объект рефлексии через экземпляр этого типа
        // Class<String> classStr2 = str.getClass(); // в теории может быть не только String
        Class<? extends String> clazzStr2 = str.getClass(); // правильно так
        // можно по имени класса
        Class<?> clazzStr3 = Class.forName("java.lang.String"); // какой-то тип Class<?> wildcard

        System.out.println(clazzStr1 == clazzStr2);
        System.out.println(clazzStr1 == clazzStr3);


        String str1 = (String) clazzStr3.newInstance(); // кастинг необходим(как в рантайме создаются объекты)
        // InstantiationException - не могу создать экземпляр, когда нет дефолтного конструктора
        // IllegalAccessException - невозможный доступ, конструктор есть но он private
        // Объект рефлексии существует и для примитивов

        Class<?> clazzInt = int.class;
        Class<?> clazzInteger = Integer.class;
        System.out.println(clazzInt == clazzInteger); // false - примитив и класс обертка представлены разными объектами рефлексии в рантайме

        Class<?> clazz = void.class; // для void тоже есть объект рефлексии

    }
}
