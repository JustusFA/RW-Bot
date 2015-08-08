package me.rw_craft.skypebot;

import com.samczsun.skype4j.formatting.Message;
import com.samczsun.skype4j.formatting.RichText;
import com.samczsun.skype4j.formatting.Text;

public class MessageBuilder {

    public Message create(String message, RichText... attributes) {
        Message m = Message.create();
        m.with(Text.rich().plain("RW Bot> "+message));
        for(RichText rt : attributes) m.with(rt);
        return m;
    }
}
