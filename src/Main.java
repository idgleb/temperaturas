import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Temperaturas t = new Temperaturas();
        System.out.println(t);
        System.out.println("Promedio " + Arrays.deepToString(t.getPromedio()));
        System.out.println("Maxima " + Arrays.deepToString(t.getMaxima()));

    }
}