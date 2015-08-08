package me.rw_craft.skypebot;

import com.samczsun.skype4j.user.User;

import java.util.ArrayList;
import java.util.List;

public class GlobalAdmin {

    private static List<User> admins = new ArrayList<User>();

    public boolean isAdmin(User u) {
        if(admins.contains(u)) return true;
        else return false;
    }

    public void addAdmin(User u) {
        admins.add(u);
    }

    public void removeAdmin(User u) {
        admins.remove(u);
    }
}
