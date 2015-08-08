package me.rw_craft.skypebot.eventhandlers;

import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.ChatJoinedEvent;
import com.samczsun.skype4j.exceptions.SkypeException;
import me.rw_craft.skypebot.MessageBuilder;

public class Join implements Listener {

    @EventHandler
    public void onJoin(ChatJoinedEvent e) {
        try {
            e.getChat().sendMessage(new MessageBuilder().create("Hello! I am RW Bot. Type ,help for help."));
        } catch(SkypeException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
