package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.PIfounder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 26.10.2016.
 */
public class PIfounderSpigot implements PIfounder{
    private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;
    private int digits = 1000000;
    ListToString listToString = new ListToString(digits);

    public String calculate() {
        List PiList = new ArrayList();
        String digit [];
        try{
            int[] arr = new int[digits + 1];
            int carry = 0;

            for (int i = 0; i <= digits; ++i)
                arr[i] = ARRINIT;

            for (int i = digits; i > 0; i-= 14) {

                int sum = 0;
                for (int j = i; j > 0; --j) {
                    sum = sum * j + SCALE * arr[j];
                    arr[j] = sum % (j * 2 - 1);
                    sum /= j * 2 - 1;
                }
                digit = String.format("%04d", carry + sum / SCALE).split("");

                for (int k = 0; k < digit.length; k ++) {
                    PiList.add(Integer.valueOf(digit[k]));
                }
                carry = sum % SCALE;
            }

        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemoryError");
        } finally {
            return listToString.format(PiList);
        }
    }
}
