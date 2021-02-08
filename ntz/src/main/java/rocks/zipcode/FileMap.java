package rocks.zipcode;

import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileMap extends HashMap {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static final String DBNAME = "ntz.db";

    private Map<String, NoteList> hashmap = new HashMap<String, NoteList>();

    public boolean load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DBNAME));
            this.hashmap = (Map<String, NoteList>) ois.readObject();
            ois.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DBNAME));
            oos.writeObject(hashmap);
            oos.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}
