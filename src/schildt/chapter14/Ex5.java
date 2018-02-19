package schildt.chapter14;

import java.util.function.Predicate;

public class Ex5 {
//    Составьте лямбда-выражение, которое возвращает значение true, если число
//    принадлежит к диапазону чисел 10-20, включая граничные значения.
    public static void main(String[] args) {
        Predicate<Integer> b = i -> ((i>=10) && (i<=20));
        System.out.println(b.test(10));
    }
}
