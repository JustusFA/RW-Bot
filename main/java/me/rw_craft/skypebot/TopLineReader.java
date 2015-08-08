package me.rw_craft.skypebot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TopLineReader {

    private File f;

    public TopLineReader(File f) {
        this.f = f;
    }

    public String read() {
        try {
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            String topLine  = br.readLine();
            br.close();
            reader.close();
            return topLine;
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
