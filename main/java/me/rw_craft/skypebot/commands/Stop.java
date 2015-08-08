package me.rw_craft.skypebot.commands;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.ChatMessage;
import me.rw_craft.skypebot.Command;

import java.io.IOException;

public class Stop extends Command {

    public String getName() {
        return "stop";
    }

    public void execute(Skype skype, ChatMessage msg) {
        System.out.println("Stopping...");
        try {
            skype.logout();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.exit(0);
    }
}
