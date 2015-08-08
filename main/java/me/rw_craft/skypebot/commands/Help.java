package me.rw_craft.skypebot.commands;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.ChatMessage;
import com.samczsun.skype4j.exceptions.SkypeException;
import me.rw_craft.skypebot.Command;
import me.rw_craft.skypebot.MessageBuilder;

public class Help extends Command {

    public String getName() {
        return "help";
    }

    public void execute(Skype skype, ChatMessage msg) {
        try {
            msg.getChat().sendMessage(new MessageBuilder().create("My commands are:\n,admin\n,help"));
        } catch(SkypeException e) {
            System.err.println(e.getMessage());
        }
    }
}
