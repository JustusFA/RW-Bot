package me.rw_craft.skypebot;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.exceptions.SkypeException;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            new Commands().register(Skype.login("rw00000", new TopLineReader(new File("C:/Users/Ryan/Desktop/Password.txt")).read()));
        } catch(SkypeException e) {
            System.err.println(e.getMessage());
        }
    }
}
//19:a06403e6a7d34589a358eafbcb639d3e@thread.skype