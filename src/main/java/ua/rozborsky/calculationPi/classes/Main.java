package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.PIfounder;
import ua.rozborsky.calculationPi.interfaces.View;

/**
 * Created by roman on 26.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        View window = new Window();
        window.createWindow();

        PIfounder pIfounder = new PIfounderSpigot();
        PIfounderThread PIfounderThread = new PIfounderThread(pIfounder);
        window.setPIfounderThread(PIfounderThread);
    }
}
