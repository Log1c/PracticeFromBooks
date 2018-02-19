package warburtonLambdas.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class Quest6_7 {
    public static void main(String[] args) {
        String h = "Hello World";
        System.out.println(countLoverCaseLiterals(h));
        Optional<String> s = getLongestLowerCaseString(asList(h, "sddfdf"));
        System.out.println(s.get());
    }

    public static void test() {

    }

    //Подсчитайте количество строчных букв в строке (подсказка:воспользуйтесь методом chars класса String).
    public static long countLoverCaseLiterals(String s) {
        return s.chars().filter(Character::isLowerCase)
                .count();
    }

    //Пусть дан список строк List<String>. Найдите в нем строку, со-
    //держащую максимальное число строчных букв. Чтобы код правильно работал, когда входной список пуст,
    // можете возвращать объект типа Optional<String>.
    public static Optional<String> getLongestLowerCaseString(List<String> s) {
        return Optional.of(s.stream()
                .max(Comparator.comparingLong(Quest6_7::countLoverCaseLiterals))
                .get());
    }
}
