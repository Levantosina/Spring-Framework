package ru.dmitrii.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

     //   Music music = context.getBean("musicBean", Music.class);
     //   MusicPlayer musicPlayer=new MusicPlayer(music)


//        MusicPlayer firstMusicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
//        MusicPlayer secondMusicPlayer=context.getBean("musicPlayer",MusicPlayer.class);
//
//       boolean comparison=firstMusicPlayer==secondMusicPlayer;
//
//        System.out.println(comparison);
//
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        firstMusicPlayer.setVolume(10);
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());

      //  musicPlayer.playMusic();
//


        Classicalmusic classicalmusic=context.getBean("musicBean",Classicalmusic.class);
        System.out.println(classicalmusic.getSong());

        context.close();
    }

}

