package example.am.mvp_socket_server_local_chat.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import example.am.mvp_socket_server_local_chat.presenter.impl.ChatClientPresenter;

/**
 * Created by Khach on 21-Jul-18.
 */

public class ChatClientThread extends Thread {
    private String userName;
    private String dstAddress;
    private int dstPort;

    private String msgToSend = "";
    private boolean goOut = false;

    private ChatClientPresenter.CallBack callBack;

    public ChatClientThread(String userName, String address, int port, ChatClientPresenter.CallBack callBack) {
        this.callBack = callBack;
        this.userName = userName;
        dstAddress = address;
        dstPort = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;

        try {
            socket = new Socket(dstAddress, dstPort);
            callBack.success();

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(userName);
            dataOutputStream.flush();
            String message;
            while (!goOut) {
                //read stream
                if (dataInputStream.available() > 0) {

                    message = dataInputStream.readUTF();
                    if (message.equals("serverGoOut")) {
                        callBack.printMessage("Server go out");
                        disconnect();
                        break;
                    }
                    callBack.printMessage(message);
                }

                //write to stream
                if (!msgToSend.equals("")) {
                    dataOutputStream.writeUTF(msgToSend);
                    dataOutputStream.flush();
                    msgToSend = "";
                }
            }
            dataOutputStream.writeUTF("clientGoOut");
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            callBack.error(dstAddress + ":" + dstPort + " unavailable");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            callBack.logout();
        }
    }

    public void disconnect() {
        goOut = true;
    }

    public void sendMessage(String message) {
        msgToSend = message;
    }
}
