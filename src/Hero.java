import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Hero Class, The parent class of the game
 */

public class Hero {
    // The life Bar
    public int hp;
    // The magic power Bar
    public int bp;
    // The energy Bar
    public int ep;

    // Image
    public BufferedImage img;
    public BufferedImage tempImg;

    // The location
    public int x;
    public int y;
    // size of image
    public int w;
    public int h;

    // The direction of image
    public BufferedImage leftIma;
    public BufferedImage rightImg;

    // 存放出场动画图片的集合(List 与 Set集合， LinkedList  ArrayList， HashMap， HashTable)
    List<BufferedImage> enterAction = new ArrayList<>();

    // 出场动画的方法
    int index = 0;
    public boolean action(){
        index++;
        img = (index >= enterAction.size() - 1) ? tempImg:enterAction.get(index);
        return index != enterAction.size()-1;
    }
}
