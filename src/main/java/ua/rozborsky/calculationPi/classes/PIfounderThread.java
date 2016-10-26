package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.PIfounder;

/**
 * Created by roman on 26.10.2016.
 */
public class PIfounderThread extends Thread{
    private PIfounder PIfounder;
    private int size = 200;

    PIfounderThread(PIfounder PIfounder) {
        this.PIfounder = PIfounder;
    }

    public void run() {
        PIfounder.calculate(size);
    }
}
