package warburtonLambdas.chapter3;

public class StringUtil {
    public static String LongestName(String a, String b) {
        if (a.length() < b.length()) {
            return b;
        }

        return a;
    }
}
