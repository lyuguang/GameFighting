// import javazoom.jl.decoder.JavaLayerException;

import javax.imageio.ImageIO;
import java.io.IOException;

public class WYFHero extends Hero{
    // MySound bgMusic;  // 音频
    public WYFHero(){
        try {
            // read the image
            tempImg = ImageIO.read(WYFHero.class.getResource("/img/wyf_left.png"));
            // get the size of image
            w = tempImg.getWidth()/5;
            h = tempImg.getHeight()/5;

            // set location
            x = 850;
            y = 450;

            // Add the enter action
            for(int i = 1; i <= 12; i++){
                enterAction.add(ImageIO.read(WYFHero.class.getResource("/img/actionRed/blue"+i+".png")));
            }
            // set the life Bar
            hp = 200;
            bp = 200;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*public void say(){
        Thread t = new Thread(){
            @Override
            public void run() {
                bgMusic = new MySound("/music/KunEnter.mp3");
                try {
                    bgMusic.isPlay();
                } catch (JavaLayerException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // 启动线程 ===> 将线程纳入线程调度
        t.start();
    }*/
}
