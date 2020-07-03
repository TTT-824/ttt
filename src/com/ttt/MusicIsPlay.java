package com.ttt;

public class MusicIsPlay {
    //音乐播放的状态
    private int isplay;
    //音乐播放的id
    private int playid;
    //当前播放线程是否运行中
    private static int isrun;

    public void MusicIsPlay(int x){
        this.isrun = x;
    }

    //getset方法
    public int getisIsplay() {
        return isplay;
    }
    public void setIsplay(int isplay) {
        this.isplay = isplay;
    }
    public int getPlayid() {
        return playid;
    }
    public void setPlayid(int playid) {
        this.playid = playid;
    }
    public int getIsrun() {

        return isrun;
    }
    public void setIsrun(int isrun) {
        this.isrun = isrun;
    }
}
