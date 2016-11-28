import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 * Created by zhang on 16-11-28.
 */
public class ChatSocket extends Thread {
    private Socket socket;
    public ChatSocket(Socket S){
        this.socket = S;
    }

    @Override
    public void run() {
        try {
            int count = 0;
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            while (count <= 20) {
                count ++;
                bw.write("hello world"+count);
                bw.flush();
                sleep(1000);
            }
            bw.close();
            osw.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
