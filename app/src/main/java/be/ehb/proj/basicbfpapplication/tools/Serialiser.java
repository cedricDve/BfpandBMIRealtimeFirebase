package be.ehb.proj.basicbfpapplication.tools;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public abstract  class Serialiser {
    public static  void serialise(String filename, Object object, Context context){
    try {
        FileOutputStream file = context.openFileOutput(filename, Context.MODE_PRIVATE);
        ObjectOutputStream ooa;
        try {
            ooa = new ObjectOutputStream(file);
            ooa.writeObject(object);
            ooa.flush();
            ooa.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }catch (FileNotFoundException e ) {
        e.printStackTrace();
    }
    }
    public static Object deSerialise(String filename, Context context){
    try {
        FileInputStream file = context.openFileInput(filename);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(file);
            try {
                Object object = ois.readObject();  // read an object
                ois.close();
                return object;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    return null;

    }
}