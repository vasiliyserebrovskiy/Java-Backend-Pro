package ait.utils;
// 1 для кого видна анотаця

import java.lang.annotation.*;

//class - дефолтный, виден и в байт коде
//runtime - виден только в байт коде - тоесть в run time -> reflection
//source - overwrite() на уровне компиляции

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // над чем можно ее ставить
public @interface Table {
    //атрибуты
    String name() default ""; // название таблицы
    // может возвращать любые примитивы, string, enum, объекты рефлексии, другие рефлексии и одномерные массивы
    // свои атрибуты включать нельзя


}

