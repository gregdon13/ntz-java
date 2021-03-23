package rocks.zipcode;

import java.util.Scanner;

/**
 * ntz main command.
 */
public final class Notez {

    public FileMap filemap;

    public Notez() {
        this.filemap  = new FileMap();
    }
    /**
     * Says hello to the world.
     *
     * param args The arguments of the program.
     */
    public static void main(String argv[]) {
        boolean _debug = true;
        // for help in handling the command line flags and data!
        if (_debug) {
            System.err.print("Argv: [");
            for (String a : argv) {
                System.err.print(a+" ");
            }
            System.err.println("]");
        }

        Notez ntzEngine = new Notez();

        ntzEngine.loadDatabase();

        /*
         * You will spend a lot of time right here.
         *
         * instead of loadDemoEntries, you will implement a series
         * of method calls that manipulate the Notez engine.
         * See the first one:
         */



        //ntzEngine.loadDemoEntries();



        if (argv.length == 0) { // there are no commandline arguments
            //just print the contents of the filemap.
            ntzEngine.printResults();
        } else {
            if (argv[0].equals("-r")) {
                String noteToAdd = ntzEngine.argvToString(argv);
                ntzEngine.addToCategory("General", noteToAdd);
            } else if (argv[0].equals("-c")) {
                String noteToAdd = ntzEngine.argvToString(argv);
                ntzEngine.addToCategory(argv[1], noteToAdd);
            } else if (argv[0].equals("-f")) {
                ntzEngine.removeNote(argv[1], Integer.parseInt(argv[2]));
            } else if (argv[0].equals("-e")) {
                String noteToAdd = "";
                for (int i = 3; i < argv.length-1; i++) {
                    noteToAdd += argv[i] + " ";
                }
                noteToAdd += argv[argv.length-1];
                ntzEngine.editNote(argv[1], Integer.parseInt(argv[2]), noteToAdd);
            }
            // this should give you an idea about how to TEST the Notez engine
              // without having to spend lots of time messing with command line arguments.
        }
        /*
         * what other method calls do you need here to implement the other commands??
         */

        ntzEngine.saveDatabase();
    }

    public String argvToString(String[] argv) {
        String noteToAdd = "";
        for (int i = 2; i < argv.length-1; i++) {
            noteToAdd += argv[i] + " ";
        }
        noteToAdd += argv[argv.length-1];
        return noteToAdd;
    }

    public void addToCategory(String key, String note) {
        if (filemap.containsKey(key)) {
            filemap.get(key).add(note);
        } else {
            //catches if key doesn't exist
            NoteList noteList = new NoteList(note);
            filemap.put(key, noteList);
        }
    }

    public void removeNote(String category, int removeNum) {
        filemap.get(category).remove(removeNum-1);
    }

    public void editNote(String category, int editIndex, String newNote) {
        filemap.get(category).set(editIndex-1, newNote);
    }

    private void saveDatabase() {
        filemap.save();
    }

    private void loadDatabase() {
        filemap.load();
    }

    public void printResults() {
        System.out.println(this.filemap.toString());
    }

    public void loadDemoEntries() {
        filemap.put("General", new NoteList("The Very first Note"));
        filemap.put("note2", new NoteList("A secret second note"));
        filemap.put("category3", new NoteList("Did you buy bread AND eggs?"));
        filemap.put("anotherNote", new NoteList("Hello from ZipCode!"));
    }
    /*
     * Put all your additional methods that implement commands like forget here...
     */

}
