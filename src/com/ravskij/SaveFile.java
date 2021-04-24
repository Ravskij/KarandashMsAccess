package com.ravskij;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SaveFile {

    private String text;
    private String filename;

    public SaveFile(String text, String filename){
        this.text = text;
        this.filename = filename;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void Save() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
}
