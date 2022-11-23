package ru.dmitrii.springcourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicPlayer {


    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    //private  Music music;
    private List<Music> musicList=new ArrayList<>();


    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;

    }

    private String name;
private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    //IoC
//    public  MusicPlayer(Music music){
//        this.music=music;
//
//    }
//    public void setMusic(Music music){
//        this.music=music;
//    }
    public MusicPlayer(){}


    public  void playMusic(){
        for(Music music:musicList)
            System.out.println("Playing "+music.getSong();
    }
}
