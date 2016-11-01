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
        for (int i = 0; i < PiList.size(); i++) {
            PiTMP.append(PiList.remove(i));
        }
        String pi = PiTMP.toString();
        if (pi.length() != 0){
            int length = pi.length();
            int transfers = (int)Math.floor(length/70);
            StringBuilder transferedPi = new StringBuilder(pi);

            for (int i = 0; i < transfers; i++) {
                transferedPi.insert((70 * (i + 1)) + 4 * i, "<br>");
            }

            return "<html>" + transferedPi.toString() + "</html>";
        }
        return "cant calculate \u03c0";
    }
}
