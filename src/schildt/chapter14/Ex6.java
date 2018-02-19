package schildt.chapter14;

//Создайте функциональный интерфейс, способный поддерживать лямбда-выражение,
//предложенное в п. 5. Вызовите интерфейс MyTest и его абстрактный метод testing().
public class Ex6 implements MyTest<Integer>{
    @Override
    public boolean test(Object o) {
        return (((Integer)o>=10) && ((Integer)o<=20));
    }
}
