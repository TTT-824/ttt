package com.ttt;

import javax.swing.*;

public class SimulatedProgressPar implements Runnable{

    private int time;   //等待时间
    private boolean flag = true;    //标识符 用来停止线程
    private JSlider slider;

    //构造方法
//    public SimulatedProgressPar(int time, JSlider slider){
//        this.time = time;
//        this.slider = slider;
//    }

    //stop改变线程flag让线程自己停止
    public void stop() {
        this.flag = false;
    }

    //set方法初始化变量
    public void setTimeandFlag(int times,boolean bool,JSlider slid){
        time = times;
        flag = bool;
        slider = slid;
    }

    //run方法体
    public void run() {
        int x = 0;
        //让进度条自己改变
        while (flag){

            System.out.println("进度条执行中："+x);
            try {//抛出sleep异常
                Thread.sleep(time/100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            slider.setValue(x);
            x++;
            if (x==101){
                break;
            }
        }
        System.out.println("执行完毕");
    }
}
