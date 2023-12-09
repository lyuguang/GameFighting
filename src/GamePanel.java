import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.TimerTask;

public class GamePanel extends JPanel {
    private final static int BG_X = 0;
    private final static int BG_Y = 0;
    private final static int LEFT_UP_X = 15;
    private final static int LEFT_UP_Y = 15;
    private final static int LEFT_VALUE_X = 120;
    private final static int LEFT_LIFEBAR_Y = 32;
    private final static int LEFT_MAGIC_POWER_Y = 62;
    private final static int LEFT_ENERGY_Y = 92 ;
    private final static int RIGHT_UP_X =885;
    private final static int RIGHT_UP_Y = 15;
    private final static int RIGHT_VALUE_X = 680;
    private final static int HEIGHT_IMAGE = 100;
    private final static int WIDTH_IMAGE = 100;
    private final static int WIDTH_LIFEBAR_MAGIC_ENERGY = 200;
    private final static int HEIGHT_LIFEBAR_MAGIC = 25;
    private final static int HEIGHT_ENERGY = 7;

    // declare a background
    BufferedImage bg;
    // 声明一个图标变量
    BufferedImage cxkIcon;
    CXKHero cxk;
    WYFHero wyf;
    BufferedImage wyfIcon;

    public GamePanel(){
        setBackground(Color.PINK);
        // 通过IO流读取图片；IO相关的问题，序列化与反序列化
        try {
            bg = ImageIO.read(GamePanel.class.getResource("/img/bg.jpg"));
            cxkIcon = ImageIO.read(GamePanel.class.getResource("/img/蔡徐坤aa.png"));
            wyfIcon = ImageIO.read(GamePanel.class.getResource("/img/吴亦凡bb.png"));

            cxk = new CXKHero();
            wyf = new WYFHero();

            action();
        } catch (IOException e) {
            // TODO 异常日志的记录  log4j
            throw new RuntimeException(e);
        }
    }

    public void action(){
        // 播放玩家一的出场音频
        // cxk.say();
        // 计时器
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 玩家一出场
                if(!cxk.action()){
                    // 清除定时任务
                    timer.cancel();
                    // 刷新
                    repaint();
                    // 线程休眠
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    // 玩家二出场
                    // wyf.say();
                    java.util.Timer f_timer = new java.util.Timer();
                    f_timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if(!wyf.action()){
                                // 清除定时器
                                f_timer.cancel();
                                repaint();
                            }
                            repaint();
                        }
                    }, 0, 150);

                }
                repaint();
            }
        }, 0, 150);
    }

    @Override  // 面向对象中，override and overload 的区别
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the background
        g.drawImage(bg, BG_X, BG_Y, GameFrame.WIDTH, GameFrame.HEIGHT, null);

        // Draw players
        drawPlayer(g, cxkIcon, LEFT_UP_X, LEFT_UP_Y);
        drawPlayer(g, wyfIcon, RIGHT_UP_X, RIGHT_UP_Y);

        // Draw life bars, magic power, and energy for both sides
        drawBars(g, LEFT_VALUE_X);
        drawBars(g, RIGHT_VALUE_X);

        // Draw the game player
        g.drawImage(cxk.img, cxk.x, cxk.y, cxk.w, cxk.h, null);
        g.drawImage(wyf.img, wyf.x, wyf.y, wyf.w, wyf.h, null);
    }

    private void drawPlayer(Graphics g, Image playerIcon, int x, int y) {
        g.drawImage(playerIcon, x, y, WIDTH_IMAGE, HEIGHT_IMAGE, null);
    }

    private void drawBars(Graphics g, int valueX) {
        g.setColor(Color.white);
        g.drawRect(valueX, LEFT_LIFEBAR_Y, WIDTH_LIFEBAR_MAGIC_ENERGY, HEIGHT_LIFEBAR_MAGIC);
        g.drawRect(valueX, LEFT_MAGIC_POWER_Y, WIDTH_LIFEBAR_MAGIC_ENERGY, HEIGHT_LIFEBAR_MAGIC);
        g.drawRect(valueX, LEFT_ENERGY_Y, WIDTH_LIFEBAR_MAGIC_ENERGY, HEIGHT_ENERGY);

        g.setColor(Color.GREEN);
        g.fillRect(valueX, LEFT_LIFEBAR_Y, WIDTH_LIFEBAR_MAGIC_ENERGY, HEIGHT_LIFEBAR_MAGIC);

        g.setColor(Color.YELLOW);
        g.fillRect(valueX, LEFT_MAGIC_POWER_Y, WIDTH_LIFEBAR_MAGIC_ENERGY, HEIGHT_LIFEBAR_MAGIC);
    }

}
