package com.ttt;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;
import javazoom.jl.player.Player;
import org.dom4j.DocumentException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.ttt.MainInterface.absolutelocal;

public class MusicPlayer {
    private static Player player = null;
    private static long ls;
    private static File file;
    private static MusicIsPlay musicisplay;
    private static int isplay;
    private static Timer tm;
    private static String play_file;
    private static Thread nn;
    private static GetXmlDom domxml;
    private static int x;
    private static ParsingXML parsingXML;

    public MusicPlayer(){
        musicisplay = new MusicIsPlay();
    }

    //关闭播放
    public static void stopPlay() throws IOException, DocumentException {
        //设置线程运行状态
        //修改播放状态false
        parsingXML = new ParsingXML();
        parsingXML.SetElementValue(absolutelocal,1,0,"false");
        //取消定时器
        tm.cancel();
        //关闭播放器
        player.close();
        //关闭线程
        nn.interrupt();
        //切换播放图标
        MainInterface.setPlayStatac(2);
    }

    //初始化播放器
    public static void setPlay_file(String play_file) throws EncoderException, EncoderException {
        MusicPlayer.play_file = play_file;
        file = new File(play_file);
        Encoder encoder = new Encoder();
        MultimediaInfo m = encoder.getInfo(file);
        ls = m.getDuration();
        //获取播放状态
        isplay = musicisplay.getisIsplay();
        System.out.println(isplay);
    }

    //开始播放
    public static void play() throws NullPointerException{
        nn = new Thread() {
            public void run() {
                try {
                    //new出ParsingXML对象
                    parsingXML = new ParsingXML();
                    //查询XML
                    String isplay = parsingXML.QueryElementValve(absolutelocal,1,"isplay");
                    if(isplay.equals("false")) {
                        System.out.println("1:"+ls);
                        long duration = ls / 1000;
                        //向xml设置当前音乐的时长
                        parsingXML.SetElementValue(absolutelocal,2,0,""+ls);
                        System.out.println("当前播放音乐时长为:" + ls / 60000 + "分" + (ls / 1000 - ls / 60000 * 60) + "秒！");
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream stream = new BufferedInputStream(fis);
                        player = new Player(stream);
                        //设置播放状态为播放中
                        System.out.println("设置播放状态为播放中");
                        //修改播放状态true
                        parsingXML.SetElementValue(absolutelocal,1,0,"true");
                        //设置线程运行状态
                        //切换播放图标
                        MainInterface.setPlayStatac(1);
                        musicisplay.setIsplay(1);

                        int i = musicisplay.getisIsplay();
                        System.out.println("设置后的播放状态" +"---"+i);
                        player.play();
                    }else {
                        //先关闭上一个线程的进度条事件
                        MainInterface.stopOrStart();
                        stopPlay();
                        //关闭播放
                        System.out.println("关闭播放");
                        //切换播放图标
                        MainInterface.setPlayStatac(3);
                        //重新启动开始播放
                        @SuppressWarnings("unused")
                        long duration = ls / 1000;
                        //向xml设置当前音乐的时长
                        parsingXML.SetElementValue(absolutelocal,2,0,""+ls);
                        System.out.println("当前播放音乐时长为:" + ls / 60000 + "分" + (ls / 1000 - ls / 60000 * 60) + "秒！");
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream stream = new BufferedInputStream(fis);
                        player = new Player(stream);
                        //切换播放图标
                        MainInterface.setPlayStatac(1);
                        //设置线程运行状态
                        //修改播放状态true
                        parsingXML.SetElementValue(absolutelocal,1,0,"true");
                        player.play();
                    }

                } catch (Exception e) {

                }
            };
        };
        nn.start();
        try {
            System.out.println("计时开始");
            tm = new Timer();
            tm.schedule(new TimerTask() {

                public void run() {
                    // TODO 自动生成的方法存根
                    System.out.println("计时结束");
                    System.out.println("2:"+ls);
                    //设置线程运行状态
                    //修改播放状态false
                    try {
                        parsingXML.SetElementValue(absolutelocal,1,0,"false");
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.close();
                    nn.interrupt();
                    System.out.println("main thread end...");
                    //切换播放图标
                    MainInterface.setPlayStatac(2);
                }
            }, ls+1000);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
