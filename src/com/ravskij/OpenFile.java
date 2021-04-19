package com.ravskij;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OpenFile {

    private String text;
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

    public String Open(){
        try {
            FileOutputStream os = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(text);
            oos.close();
            os.close();
        }
        catch (IOException ex) {
            System.out.println("Исключение при сериализации:   " + ex);
        }
        return text;
    }
}
