package main;

import java.awt.*;

public class Pointer {
    private int i=0;
    private int j=0;
    private int x=0;
    private int y=0;
    private int h=40;
    private boolean isShow=false;
    private int type=0;
    //构造
    public Pointer(int i,int j,int x,int y){
        this.i=i;
        this.j=j;
        this.x=x;
        this.y=y;
    }

    public Pointer() {
    }

    public Pointer(int i, int j, int x, int y, int h, boolean isShow) {
        this.i = i;
        this.j = j;
        this.x = x;
        this.y = y;
        this.h = h;
        this.isShow = isShow;
    }

    //绘制指示器
    public void  draw(Graphics g){
        g.setColor(new Color(255,0,0));
        if(isShow){
//            g.drawRect(x-h/2,y-h/2,h,h);
            drawPointer(g);
        }

    }
    //
    private void drawPointer(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.setStroke(new BasicStroke(2.0f));

        int x1=0;
        int y1=0;
        int x2=0;
        int y2=0;

        //左上角
        x1=this.x-h/2;
        y1=this.y-h/2;
        //横向
        x2=x1+h/4;
        y2=y1;
        g2d.drawLine(x1,y1,x2,y2);
        //竖向
        x2=x1;
        y2=y1+h/4;
        g2d.drawLine(x1,y1,x2,y2);

        //右上角
        x1=this.x+h/2;
        y1=this.y-h/2;
        //横向
        x2=x1-h/4;
        y2=y1;
        g2d.drawLine(x1,y1,x2,y2);
        //竖向
        x2=x1;
        y2=y1+h/4;
        g2d.drawLine(x1,y1,x2,y2);

        //右下角
        x1=this.x+h/2;
        y1=this.y+h/2;
        //横向
        x2=x1-h/4;
        y2=y1;
        g2d.drawLine(x1,y1,x2,y2);
        //竖向
        x2=x1;
        y2=y1-h/4;
        g2d.drawLine(x1,y1,x2,y2);

        //左下角
        x1=this.x-h/2;
        y1=this.y+h/2;
        //横向
        x2=x1+h/4;
        y2=y1;
        g2d.drawLine(x1,y1,x2,y2);
        //竖向
        x2=x1;
        y2=y1- h/4;
        g2d.drawLine(x1,y1,x2,y2);

    }
    //判断是否在指示器的范围内
    public boolean isPoint(int x,int y){
        int x1=this.x-h/2;
        int y1=this.y-h/2;
        int x2=this.x+h/2;
        int y2=this.y+h/2;

        return x>x1&&y>y1&&x<x2&&y<y2;
    }

    public boolean isShow(){
        return isShow;
    }
    public void setShow(boolean isShow){
        this.isShow=isShow;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }

    public int getType(){
        return  type;
    }

    public void setType(int type){
        this.type=type;
    }

}
