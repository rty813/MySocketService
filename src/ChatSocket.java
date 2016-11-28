import java.io.IOException;
import java.io.OutputStream;
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
            OutputStream os = socket.getOutputStream();
            while (true) {
                os.write("hello world\n".getBytes("UTF-8"));
                sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
