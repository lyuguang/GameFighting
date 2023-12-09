import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MySound {
    // 音频播放对象
    Player player;
    // 播放路径
    String path;

    public MySound(String path){
        this.path = path;
    }
    // 播放的方法
    public void isPlay() throws JavaLayerException {
        // 通过指定路径创建一个音频播放对象
        player = new Player(this.getClass().getResourceAsStream(path));
        // 播放
        player.play();
    }
}
