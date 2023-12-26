package main;

import common.ImageValue;

import java.awt.*;

public class Qizi {
    private int x=0;
    private int y=0;
    private int h=36;
    private int type=1;//1白2黑

    public Qizi(int x,int y,int type){
        this.x=x;
        this.y=y;
        this.type=type;
    }

    public void draw(Graphics g){
        if(type==1){
            g.drawImage(ImageValue.whiteImage,x-h/2,y-h/2,h,h,null);
        }else {
            g.drawImage(ImageValue.blackImage,x-h/2,y-h/2,h,h,null);
        }
    }
}
