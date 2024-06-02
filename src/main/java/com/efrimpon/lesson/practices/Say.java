package com.efrimpon.lesson.practices;

public class Say {

    private String time;

    public Say(String time) {
        this.time = time;
    }

    public String Greet(){
        return "Good " + time;
    }
}
