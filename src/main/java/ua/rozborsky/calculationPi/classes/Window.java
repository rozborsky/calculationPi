package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by roman on 26.10.2016.
 */
public class Window implements View{

    private final Font font = new Font("Arial", Font.PLAIN, 20);

    public void createWindow() {
        JFrame frame = new JFrame("Розрахунок числа \u03c0");
        setWindowParameters(frame);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(75, 0, 130));

        panel.add(createButton("Розрахувати"));

        frame.add(panel);
    }

    private void setWindowParameters(JFrame frame) {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton createButton(String name) {
        JButton button = new JButton(name);
        button.setFont(font);

        return button;
    }

    private Label createLabel(String PIvalue) {

        Label label = new Label(PIvalue);
        label.setFont(font);

        return label;
    }
}
