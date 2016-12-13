package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.PIfounder;


/**
 * Created by roman on 26.10.2016.
 */
public class PIfounderThread extends Thread{
    private PIfounder PIfounder;
    private String PI;

    PIfounderThread(PIfounder PIfounder) {
        this.PIfounder = PIfounder;
    }

    @Override
    public void run() {
        PI = PIfounder.calculate();
    }

    public String getPI() {
        return PI;
    }
}