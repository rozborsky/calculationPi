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

    PIfounderThread pIfounderThread;
    private final Font FONT = new Font("Arial", Font.PLAIN, 20);
    JLabel jLabel;

    public void createWindow() {
        JFrame frame = new JFrame("Calculator \u03c0");
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
    }

    public void setPIfounderThread(PIfounderThread pIfounderThread) {
        this.pIfounderThread = pIfounderThread;
    }

    private void setWindowParameters(JFrame frame) {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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

    private String formatPi(String pi) {System.out.println(pi);
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

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    //long start = System.currentTimeMillis();

                    pIfounderThread.start();
                    pIfounderThread.run();
                    String pi = formatPi(pIfounderThread.getPI());

                    jLabel.setText(pi);
                    jLabel.setVisible(true);

//                    long finish = System.currentTimeMillis();
//                    long timeConsumedMillis = finish - start;
//                    System.out.println(timeConsumedMillis / 1000);
                }
            });
        }
    }
}
