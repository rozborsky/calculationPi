package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.PIfounder;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by roman on 26.10.2016.
 */
public class PIfounderSpigotBigDecimal implements PIfounder{
    private int numDigits = 500000;
    private MathContext mc;

    public String calculate() {
        mc = new MathContext(numDigits);
        BigDecimal pi = BigDecimal.valueOf(4);
        String result = new String();
        try{
            boolean plus = false;
            for (int i = 3; i < numDigits; i += 2) {
                BigDecimal dividend = BigDecimal.valueOf(4);
                BigDecimal fraction = dividend.divide(BigDecimal.valueOf(i), mc);

                if (!plus){
                    fraction = fraction.multiply(BigDecimal.valueOf(-1));
                }

                pi = pi.add(fraction);
                plus = !plus;
                result = pi.round(mc).toString();
            }

        } catch (OutOfMemoryError e) {
            System.out.println("------out of memory error---------");

        }finally {
            return result;
        }
    }
}
