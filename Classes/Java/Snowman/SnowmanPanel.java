import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnowmanPanel extends JPanel {
    private final List<Runnable> drawActions = new ArrayList<>();
    private final int MID = 150;
	private final int TOP = 50;
    Graphics g;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.g = g;

        g.setColor(new Color(135, 206, 235)); // light blue background
        g.fillRect(20, 20, 260, 260); // fill the background

        for (Runnable action : drawActions) {
            action.run();
        }
    }

    // Methods
    public void addHead() {
        drawActions.add(() -> {
            //set the color for the snowman
            g.setColor(Color.white);

            //Draw the head
            g.fillOval(MID - 20, TOP, 40, 40);
        });
        repaint();
    }

    public void addEyes() {
        drawActions.add(() -> {
            //set the color for face
            g.setColor(Color.black);

            //draw the left eye
            g.fillOval(MID - 10, TOP + 10, 5, 5);

            //draw the right eye
            g.fillOval(MID + 5, TOP + 10, 5, 5);

        });
        repaint();
    }

    public void addSmile() {
        drawActions.add(() -> {
            //set the color for face
            g.setColor(Color.black);

            //draw the smile
            g.drawArc(MID - 10, TOP + 20, 20, 10, 190, 160);

        });
        repaint();
    }

    public void addArms() {
        drawActions.add(() -> {
            //set the color for arms
            g.setColor(Color.black);

            //draw the left arm
            g.drawLine(MID - 25, TOP + 60, MID - 50, TOP + 40);

            //draw the right arm
            g.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);
        });
        repaint();
    }

    public void addBase() {
        drawActions.add(() -> {
            //set the color for the base
            g.setColor(Color.white);

            //draw the base
            g.fillOval(MID - 50, TOP + 80, 100, 60);
        });
        repaint();
    }

    public void addMiddle() {
        drawActions.add(() -> {
            //set the color for the middle
            g.setColor(Color.white);

            //draw the middle
            g.fillOval(MID - 35, TOP + 35, 70, 50);
        });
        repaint();
    }
}