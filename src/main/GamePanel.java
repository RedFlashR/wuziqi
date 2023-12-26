package main;

import common.ImageValue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.List;

public class GamePanel extends JPanel implements ActionListener {
    private JMenuBar jmb =null;
    private GameFrame mainFrame=null;

    private final int ROWS=15;
    private final int COLS=15;

    private String gameFlag="start";//游戏状态
    //创建指示器二维数组
    Pointer[][] pointers=new Pointer[ROWS][COLS];
    //存棋子集合
    private ArrayList<Qizi> qizis=new ArrayList<Qizi>();

    public GamePanel(GameFrame mainFrame){
        this.setLayout(null);
        this.setOpaque(false);
        this.mainFrame=mainFrame;
        //图片的加载
        ImageValue.init();
        //创建菜单
        createMenu();
        //创建鼠标监听
        createMouseListener();
        //创建数组内容
        createPointers();
    }
    //
    public void createPointers(){
        int x=0;
        int y=0;
        int start=26;
        Pointer pointer;
        for (int i = 0; i <ROWS ; i++) {
            for (int j = 0; j <COLS  ; j++) {
                x=j*40+start;
                y=i*40+start;
                pointer=new Pointer(i,j,x,y);
                pointers[i][j]=pointer;
            }
        }
    }

    private void createMouseListener(){
        MouseAdapter mouseAdapter=new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(!"start".equals(gameFlag)) return;
                //获取鼠标坐标
                int x=e.getX();
                int y=e.getY();
                //循环指示器二维数组
                Pointer pointer;
                for (int i = 0; i <ROWS ; i++) {
                    for (int j = 0; j <COLS  ; j++) {
                        //得到每一个指示器
                        pointer=pointers[i][j];
                        if(pointer.isPoint(x,y)&&pointer.getType()==0){
                            Qizi qizi=new Qizi(pointer.getX(),pointer.getY(),2);
                            qizis.add(qizi);
                            pointer.setType(2);
                            //重绘画布
                            repaint();

                            return;
                        }
                    }
                }
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                if(!"start".equals(gameFlag)) return;
                //获取鼠标坐标
                int x=e.getX();
                int y=e.getY();
                //循环指示器二维数组
               Pointer pointer;
                for (int i = 0; i <ROWS ; i++) {
                    for (int j = 0; j <COLS  ; j++) {
                        //得到每一个指示器
                        pointer=pointers[i][j];
                        if(pointer.isPoint(x,y)&&pointer.getType()==0){
                            pointer.setShow(true);
                        }else {
                            pointer.setShow(false);
                        }
                    }
                }
                //重绘画布
                repaint();
            }
        };
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制网格
        drawGrid(g);
        //绘制黑点
        draw5Point(g);
        //指示器
        drawPointer(g);
        //绘制棋子
        drawQizi(g);
    }
    //绘制棋子
    private void drawQizi(Graphics g){
        Qizi qizi;
        for (int i = 0; i < qizis.size(); i++) {
            qizi=qizis.get(i);
            qizi.draw(g);
        }
    }


    //绘制指示器
    private void drawPointer(Graphics g){
        Pointer pointer;
        for (int i=0;i<ROWS;i++){
            for (int j = 0; j <COLS ; j++) {
                pointer=pointers[i][j];
                if(pointer!=null){
                    pointer.draw(g);
                }
            }
        }
    }
    //绘制黑点
    private void draw5Point(Graphics g){
        //左上
        int x=142;
        int y=142;
        g.fillArc(x,y,8,8,0,360);
        //右上
        x=462;
        g.fillArc(x,y,8,8,0,360);
        //坐下
        x=142;
        y=462;
        g.fillArc(x,y,8,8,0,360);
        //右下
        x=462;
        g.fillArc(x,y,8,8,0,360);
        //中心
        x=302;
        y=302;
        g.fillArc(x,y,8,8,0,360);
    }

    //绘制网格
    public void drawGrid(Graphics g){
        int start=26;
        int x1=26;
        int y1=26;
        int x2=586;
        int y2=26;
        int dis=40;
        //绘制横线
        for (int i = 0; i < ROWS; i++) {
            y1=i*dis+start;
            y2=y1;
            g.drawLine(x1,y1,x2,y2);
        }
        //绘制竖线
        y1=26;
        y2=586;
        for (int i = 0; i < COLS; i++) {
            x1=i*dis+start;
            x2=x1;
            g.drawLine(x1,y1,x2,y2);
        }
    }

    private Font creatFont(){
        return  new Font("思源宋体",Font.BOLD,18);
    }
    private void createMenu(){
        jmb=new JMenuBar();
        //取得字体
        Font tFont = creatFont();
        //创建选项
        JMenu jMenu1 =new JMenu("游戏");
        jMenu1.setFont(tFont);
        JMenu jMenu2 =new JMenu("帮助");
        jMenu2.setFont(tFont);

        JMenuItem jmi1 = new JMenuItem("新游戏");
        jmi1.setFont(tFont);
        JMenuItem jmi2= new JMenuItem("退出");
        jmi2.setFont(tFont);
        jMenu1.add(jmi1);
        jMenu1.add(jmi2);

        JMenuItem jmi3= new JMenuItem("操作帮助");
        jmi3.setFont(tFont);
        JMenuItem jmi4= new JMenuItem("胜利条件");
        jmi4.setFont(tFont);
        jMenu2.add(jmi3);
        jMenu2.add(jmi4);

        jmb.add(jMenu1);
        jmb.add(jMenu2);
        mainFrame.setJMenuBar(jmb);

        //添加监听
        jmi1.addActionListener(this);
        jmi2.addActionListener(this);
        jmi3.addActionListener(this);
        jmi4.addActionListener(this);
        //设置指令
        jmi1.setActionCommand("restart");
        jmi2.setActionCommand("exit");
        jmi3.setActionCommand("help");
        jmi4.setActionCommand("win");
    }
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
    }
}
