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

        FileMap filemap = new FileMap();
        filemap.load();
        filemap.put("General", new NoteList("The Very first Note"));
        filemap.put("note2", new NoteList("A secret second note"));
        filemap.put("category3", new NoteList("Did you buy bread AND eggs?"));
        filemap.put("anotherNote", new NoteList("Hello from ZipCode!"));
        filemap.save();

        if (argv.length == 0) {
            System.out.println(filemap.toString());
        }

    }
}
