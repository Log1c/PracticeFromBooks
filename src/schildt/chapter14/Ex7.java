package schildt.chapter14;

import java.util.function.UnaryOperator;

//Создайте блочное лямбда-выражение для вычисления факториала целого числа.
//Продемонстрируйте его использование. В качестве функционального интерфейса
//используйте интерфейс NumericFunc, который рассматривался в этой главе.
public class Ex7 {
    public static int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }

    public static void main(String[] args) {
        UnaryOperator<Integer> integerUnaryOperator = i -> {
            return fact(i);
        };

        System.out.println(integerUnaryOperator.apply(4));
    }
}
