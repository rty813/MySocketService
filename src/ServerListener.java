import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhang on 16-11-28.
 */
public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket socket = serverSocket.accept();  //block
                JOptionPane.showMessageDialog(null, "有客户端连接到了本机的12345端口");
                new ChatSocket(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
