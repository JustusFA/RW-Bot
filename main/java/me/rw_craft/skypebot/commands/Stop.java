package me.rw_craft.skypebot.commands;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.ChatMessage;
import com.samczsun.skype4j.exceptions.SkypeException;
import me.rw_craft.skypebot.Command;
import me.rw_craft.skypebot.GlobalAdmin;
import me.rw_craft.skypebot.MessageBuilder;

import java.io.IOException;

public class Stop extends Command {

    public String getName() {
        return "admin stop";
    }

    public void execute(Skype skype, ChatMessage msg) {
        if(!new GlobalAdmin().isAdmin(msg.getSender())) {
            try {
                msg.getChat().sendMessage(new MessageBuilder().create("You don't have permission for that!"));
            } catch(SkypeException e) {
                System.err.println(e.getMessage());
            }
            return;
        }
        System.out.println("Stopping...");
        try {
            skype.logout();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.exit(0);
    }
}
