import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Memory and Matching Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
