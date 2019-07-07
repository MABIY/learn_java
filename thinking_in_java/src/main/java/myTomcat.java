import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

/**
 * @author lh
 **/
public class myTomcat {
    private static final String OUTPUT = "<h1>hello word!</h1>";
    private static final String OUTPUT_HEADERS = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html\r\n" +
            "Content-Length: ";
    private static final String OUTPUT_END_OF_HEADERS = "\r\n\r\n";
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8081);
        while (true) {
            Socket s=ss.accept();
            InputStream in = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                out.println(line);
                // this seems to be the key for me!
                // somehow I never get out of this loop if I don't
                // check for an empty line...
                if (line.isEmpty()) {
                    break;
                }
            }
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(s.getOutputStream()), "UTF-8")
            );
            out.write(OUTPUT_HEADERS + OUTPUT.length() + OUTPUT_END_OF_HEADERS + OUTPUT);
            out.flush();
            out.close();
            s.close();
        }
    }
}
