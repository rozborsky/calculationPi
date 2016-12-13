package ua.rozborsky.calculationPi.classes;

import java.util.List;

/**
 * Created by roman on 01.11.2016.
 */
public class ListToString {

    ListToString(int digits){
        PiTMP = new StringBuilder(digits);
    }
    StringBuilder PiTMP;

    public String format(List PiList) {
        for (int i = 0; i < PiList.size(); ) {
            PiTMP.append(PiList.remove(i));
        }
        String pi = PiTMP.toString();
        int length = pi.length();
        int transfers = (int)Math.floor(length/70);
        StringBuilder transferedPi = new StringBuilder(pi);

        if (transferedPi.length() > 2) {
            transferedPi.insert(1, '.');
        }

        for (int i = 0; i < transfers; i++) {
            transferedPi.insert((70 * (i + 1)) + 4 * i, "<br>");
        }

        return transferedPi.toString();
    }
}
