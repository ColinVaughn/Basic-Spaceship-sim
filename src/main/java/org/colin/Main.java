import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private int spaceshipX = 50;  // initial x-coordinate of the spaceship
    private int spaceshipY = 500; // initial y-coordinate of the spaceship

    public Main() {
        setTitle("Space Ship Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSpaceship(g);
            }
        };

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spaceshipY -= 1;  // moves the spaceship up by 1 pixel per timer tick
                panel.repaint();
            }
        });
        timer.start();

        add(panel);
        setVisible(true);
    }

    private void drawSpaceship(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(spaceshipX, spaceshipY, 20, 40);  // draws the spaceship as a blue rectangle
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
