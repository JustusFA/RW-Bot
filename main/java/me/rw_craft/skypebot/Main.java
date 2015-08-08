package me.rw_craft.skypebot;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.exceptions.SkypeException;
import me.rw_craft.skypebot.eventhandlers.Join;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            Skype skype = Skype.login("rw00000", new TopLineReader(new File("C:/Users/Ryan/Desktop/Password.txt")).read());
            new GlobalAdmin().addAdmin(skype.getChat("8:rw_craft").getUser("rw_craft"));
            skype.getEventDispatcher().registerListener(new Join());
            new Commands().register(skype);
        } catch(SkypeException e) {
            System.err.println(e.getMessage());
        }
    }
}
//19:a06403e6a7d34589a358eafbcb639d3e@thread.skype