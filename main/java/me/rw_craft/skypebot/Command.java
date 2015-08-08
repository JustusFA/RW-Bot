package me.rw_craft.skypebot;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.ChatMessage;

public abstract class Command {

    public abstract String getName();

    public abstract void execute(final Skype skype, ChatMessage msg);
}
