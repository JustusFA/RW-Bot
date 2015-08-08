package me.rw_craft.skypebot.commands;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.ChatMessage;
import com.samczsun.skype4j.exceptions.SkypeException;
import me.rw_craft.skypebot.Command;
import me.rw_craft.skypebot.GlobalAdmin;
import me.rw_craft.skypebot.MessageBuilder;

public class Admin extends Command {

    public String getName() {
        return "admin";
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
        try {
            msg.getChat().sendMessage(new MessageBuilder().create("My admin commands are:\n,admin stop"));
        } catch(SkypeException e) {
            System.err.println(e.getMessage());
        }
    }
}
