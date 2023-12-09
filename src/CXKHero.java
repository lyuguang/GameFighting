// import javazoom.jl.decoder.JavaLayerException;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CXKHero extends Hero{
    // MySound bgMusic;  // 音频
    public CXKHero(){
        try {
            // read the image
            tempImg = ImageIO.read(CXKHero.class.getResource("/img/cxk_right.png"));
            // get the size of image
            w = tempImg.getWidth()/2;
            h = tempImg.getHeight()/2;

            // set location
            x = 50;
            y = 500;

            // Add the enter action
            for(int i = 1; i <= 12; i++){
                enterAction.add(ImageIO.read(CXKHero.class.getResource("/img/actionRed/red"+i+".png")));
            }
            // set the life Bar
            hp = 200;
            bp = 200;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // kun专属音频的方法
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
