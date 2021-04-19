package com.ravskij;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

    public void Save() {
        try {
            FileOutputStream os = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(text);
            oos.close();
            os.close();
        }
        catch (IOException ex) {
            System.out.println("Исключение при сериализации");
        }
    }
}
