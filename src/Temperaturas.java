import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Temperaturas {
    private String[][] temperaturas;

    public Temperaturas() {
        temperaturas = new String[2][8];
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[0].length; j++) {
                if (j == 0) {
                    temperaturas[i][j] = pedirCadenaNoVacia("Ciudad?");
                } else {
                    temperaturas[i][j] = pedirTemperatura(j);;
                }
            }
        }
    }

    public String[][] getPromedio() {
        String[][] promedio = new String[temperaturas.length][2];
        int sum = 0;
        double promed = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 1; j < temperaturas[0].length; j++) {
                 sum += Integer.parseInt(temperaturas[i][j]);
            }
            promed = (double) sum / (temperaturas[0].length-1);
            promedio[i][0] = temperaturas[i][0];
            promedio[i][1] = new DecimalFormat("#.##").format(promed);
            sum = 0;
        }
        return promedio;
    }

    public String[][] getMaxima() {
        String[][] maxima = new String[temperaturas.length][2];
        int max = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            max = Integer.parseInt(temperaturas[i][1]);
            for (int j = 2; j < temperaturas[0].length; j++) {
                max = Math.max(max, Integer.parseInt(temperaturas[i][j]));
            }
            maxima[i][0] = temperaturas[i][0];
            maxima[i][1] = String.valueOf(max);
        }
        return maxima;
    }

    @Override
    public String toString() {
        return "Temperaturas{" +
                "temperaturas=" + Arrays.deepToString(temperaturas) +
                '}';
    }

    public static String pedirCadenaNoVacia(String msg) {
        String str = "";
        do{
            str = JOptionPane.showInputDialog(null, msg);
        }while (str.isEmpty());
        return str;
    }

    public static String pedirTemperatura(int dia) {
        String temp = "";
        do{
            temp = JOptionPane.showInputDialog(null, "? temp dia " + dia);
        }while (!isNumeroDeMinus50_Plus50(temp));
        return temp;
    }

    public static boolean isNumeroDeMinus50_Plus50(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            if (!(str.charAt(0) == '-' || str.charAt(0) == '+' || (str.charAt(0) >= '0' && str.charAt(0) <= '9'))) {
                return false;
            }
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int num = Integer.parseInt(str);
            if (num < -50 || num > 50) return false;
        }
        return true;
    }




}
