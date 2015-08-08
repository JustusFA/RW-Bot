package me.rw_craft.skypebot;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.Chat;
import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;
import com.samczsun.skype4j.exceptions.SkypeException;
import me.rw_craft.skypebot.commands.Help;
import me.rw_craft.skypebot.commands.Stop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Commands {

    private List<Command> commands = new ArrayList<Command>();

    public void register(final Skype skype) throws SkypeException {
        commands.add(new Help());
        commands.add(new Stop());
        skype.getEventDispatcher().registerListener(new Listener() {
            @EventHandler
            public void messageReceiveEvent(MessageReceivedEvent e) throws IOException {
                String msg = e.getMessage().getMessage().asPlaintext();
                if (!msg.startsWith(",")) return;
                String command = msg.substring(1);
                for (Command cmd : commands) {
                    if (command.equalsIgnoreCase(cmd.getName())) {
                        cmd.execute(skype, e.getMessage());
                        break;
                    }
                }
            }
        });
        try {
            skype.subscribe();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
