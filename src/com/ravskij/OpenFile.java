package com.ravskij;

import java.io.IOException;
import java.io.FileInputStream;

public class OpenFile {

    private String text = "";
    private String filename;

    public OpenFile(String filename){
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

    public String Open() throws IOException{
        int i = 0;
        FileInputStream fileInputStream = new FileInputStream(filename);
        while (((i = fileInputStream.read()) != -1)){
            text = text + (char)i;
        }
        return text;
    }
}
