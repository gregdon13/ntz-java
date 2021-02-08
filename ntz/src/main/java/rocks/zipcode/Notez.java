package rocks.zipcode;

/**
 * ntz main command.
 */
public final class Notez {

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
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

        FileMap hashmap = new FileMap();
        hashmap.load();
        hashmap.put("General", new NoteList("The Very first Note"));
        hashmap.put("note2", new NoteList("A secret note"));
        hashmap.put("category3", new NoteList("Did you buy bread AND eggs?"));
        hashmap.put("anotherNote", new NoteList("Hello from ZipCode!"));
        hashmap.save();

        if (argv.length == 0) {
            System.out.println(hashmap);
        }

    }
}
