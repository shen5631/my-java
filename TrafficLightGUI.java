package TrafficPack;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficLightGUI extends JFrame {
    enum TrafficLight {
        GREEN(Color.GREEN, "진행", 20), YELLOW(Color.YELLOW, "주의", 5), RED(Color.RED, "정지", 30);
        private Color color;
        private String mean;
        private int duration;

        TrafficLight(Color color, String mean, int duration) {
            this.color = color;
            this.mean = mean;
            this.duration = duration;
        }

        TrafficLight nextLight() {
            switch (this) {
                case RED : {
                    return GREEN;
                }
                case YELLOW : {
                    return RED;
                }
                case GREEN : {
                    return YELLOW;
                }
                default : {
                    return this;
                }
            }
        }
    }

    TrafficLight current = TrafficLight.RED;
    LightPanel lp = new LightPanel();
    JLabel label = new JLabel("", SwingConstants.CENTER);

    public TrafficLightGUI() {
        this.setTitle("신홍등");
        this.setSize(240, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(lp, BorderLayout.CENTER);

        label.setFont(new Font("궁서체", Font.BOLD, 18));
        this.add(label, BorderLayout.SOUTH);
        updateLight();

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                current = current.nextLight();
                updateLight();
            }
        }, 0, 2000);

        setVisible(true);
    }

    void updateLight() {
        label.setText("현재 신홍 : " + current.mean);
        lp.repaint();
    }

    class LightPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = 80, y = 50, size = 60;
            g.setColor(Color.DARK_GRAY);
            g.fillRect(50, 30, 120, 260);

            g.setColor((current == TrafficLight.RED) ? Color.RED : Color.GRAY);
            g.fillOval(x, y, 60, 60);

            g.setColor((current == TrafficLight.YELLOW) ? Color.YELLOW : Color.GRAY);
            g.fillOval(x, y + 80, 60, 60);

            g.setColor((current == TrafficLight.GREEN) ? Color.GREEN : Color.GRAY);
            g.fillOval(x, y + 160, 60, 60);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLightGUI::new);
    }
}