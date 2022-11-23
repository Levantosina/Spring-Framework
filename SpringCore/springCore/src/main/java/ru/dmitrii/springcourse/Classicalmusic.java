package ru.dmitrii.springcourse;

public class Classicalmusic implements Music {

    private Classicalmusic(){}

    public static Classicalmusic getClassicalMusic()
    {
        return new Classicalmusic();
    }

    public void doMyInit(){
        System.out.println("Doing my initialization");

    }

    public  void doMyDestroi(){
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong(){
        return "Hungarian rapsody";
    }

}
