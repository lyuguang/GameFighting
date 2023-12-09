import javax.swing.*;

public class GameFrame extends JFrame {

    public final static int WIDTH = 1000;
    public final static int HEIGHT = 700;
    private static boolean started = false;

    public GameFrame(){  // java的设计模式，单例模式的construct是private
        setSize(WIDTH, HEIGHT);
        // when close the window, then the program stop
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the location of window
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        GamePanel gp = new GamePanel();
        gf.add(gp);
        gf.setVisible(!started);
    }
}
