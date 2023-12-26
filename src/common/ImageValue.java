package common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageValue {
    public static BufferedImage whiteImage=null;
    public static BufferedImage blackImage=null;
    private static String path="/images/";

    //初始化图片方法
    public static void init(){
        try {
            whiteImage= ImageIO.read(ImageValue.class.getResource(path+"white.jpg"));
            blackImage= ImageIO.read(ImageValue.class.getResource(path+"black.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
