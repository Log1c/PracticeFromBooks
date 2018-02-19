package warburtonLambdas.chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Answer6 {
    //Подсчитайте количество строчных букв в строке (подсказка: воспользуйтесь методом chars класса String).
    public static int countLowercaseLetters(String str) {
//        return artists.stream()
//                .map(artist -> artist.getMembers().size())
//                .reduce(0, Integer::sum)
//                .intValue();

//        int result = 0;
//        char[] array = str.toCharArray();
//        for(char x:array){
//            if(Character.isUpperCase(x)){
//                result++;
//            }
//        }
//        return result;

//        return str.toCharArray()
//                //.filter(value -> Character.isUpperCase(value))
//            .map(value -> Character.isUpperCase(value))
//            .reduce(0, Integer::sum)
//            .intValue();
        // Question 7

        return (int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    //Пусть дан список строк List<String>. Найдите в нем строку, содержащую максимальное число строчных букв.
    //Чтобы код правильно работал, когда входной список пуст, можете возвращат объект типа Optional<String>.
    public static Optional<String> countLowercaseLetters(List<String> list) {
        return list.stream()
                .max(Comparator.comparing(Answer6::countLowercaseLetters));

    }

    public static void main(String[] args) {
        //String str = "StrMN";
        //System.out.println(countLowercaseLetters(str));
        List<String> list = new ArrayList<String>();

        list.add("one");
        list.add("two");
        list.add("tree");
        System.out.println(countLowercaseLetters(list).get());
    }
}