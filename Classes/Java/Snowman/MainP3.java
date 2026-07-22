import javax.swing.*;

public class MainP3 {
    public static void main(String[] args) {
        Snowman snow = new Snowman();
        SnowFrame mainFrame = new SnowFrame(snow);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
   }
}