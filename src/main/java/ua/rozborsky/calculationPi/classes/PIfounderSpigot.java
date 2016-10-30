package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.PIfounder;

/**
 * Created by roman on 26.10.2016.
 */
public class PIfounderSpigot implements PIfounder{//https://habrahabr.ru/post/188700/
    private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;

    public String calculate() {
        int digits = 10000;
        StringBuffer pi = new StringBuffer();

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

                pi.append(String.format("%04d", carry + sum / SCALE));
                carry = sum % SCALE;
            }
        } finally {
            return pi.toString();
        }
    }
}
