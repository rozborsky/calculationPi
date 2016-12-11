package ua.rozborsky.calculationPi.classes;

import ua.rozborsky.calculationPi.interfaces.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by roman on 26.10.2016.
 */
public class Window implements View{

    private final Font FONT = new Font("Arial", Font.PLAIN, 20);
    JLabel jLabel;

    public void createWindow() {
        JFrame frame = new JFrame("Calculator π");
        setWindowParameters(frame);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton());
        JPanel labelPanell = new JPanel();
        labelPanell.add(createLabel());

        JScrollPane jScrollPane = new JScrollPane(labelPanell);

        mainPanel.add(buttonPanel);
        mainPanel.add(jScrollPane);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void setWindowParameters(JFrame frame) {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private JButton createButton() {
        JButton button = new JButton("calculate");
        button.setFont(FONT);
        button.addActionListener(new ButtonListener());

        return button;
    }

    private JLabel createLabel() {
        jLabel = new JLabel();
        jLabel.setVisible(false);
        return jLabel;
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                PIfounderThread pIfounderThread = new PIfounderThread(new PIfounderSpigot());
                pIfounderThread.start();
                pIfounderThread.run();
                String pi = pIfounderThread.getPI();

                jLabel.setText(pi);
                jLabel.setVisible(true);
                }
            });
        }
    }
}
