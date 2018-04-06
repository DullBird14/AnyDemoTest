package com.cys.test.mail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;

public class JavaGuiDemo extends JFrame {

    JButton jb1= null;

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        //JFramerame 是一个底层容器(可以添加其他swing组件的类)
        JavaGuiDemo demo1 = new JavaGuiDemo();
    }

    //构造函数
    public JavaGuiDemo()
    {

        jb1 = new JButton("我是按钮");   //创建按钮
        jb1.setLocation(50,50);
        jb1.setSize(20,30);
        FileChooser fileChooser = new FileChooser();
        jb1.addActionListener(new FileChooser());
//        jb1.setAction();
//        jb1.setAction(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("I'am on Click!");
//            }
//        });
        //给窗体设置标题
        this.setTitle("Hello thisrame!");

        //设置窗体大小 以像素为单位(像素是密度单位)
        this.setSize(500, 500);

        //添加JButton组件
        this.add(jb1);
//        this.add(fileChooser);
        //设置初始位置
        this.setLocation(300, 200);

        //当设置关闭窗口时，保证jvm也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示
        this.setVisible(true);
    }
}


@SuppressWarnings("serial")
class FileChooser implements ActionListener {
    JButton open=null;
//    public FileChooser(){
//        open=new JButton("open");
//        this.add(open);
//        this.setBounds(400, 200, 100, 100);
//        this.setVisible(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        open.addActionListener(this);
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        if (file == null) {
            return ;
        }
        if (file.isDirectory()) {
            System.out.println("文件夹:"+file.getAbsolutePath());
        } else if(file.isFile()) {
            System.out.println("文件:"+file.getAbsolutePath());
        }
        System.out.println(jfc.getSelectedFile().getName());

    }



}