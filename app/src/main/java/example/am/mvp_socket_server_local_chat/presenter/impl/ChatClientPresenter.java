package example.am.mvp_socket_server_local_chat.presenter.impl;

import example.am.mvp_socket_server_local_chat.model.ChatClientThread;
import example.am.mvp_socket_server_local_chat.presenter.IChatClientPresenter;
import example.am.mvp_socket_server_local_chat.view.IChatClientView;

/**
 * Created by Khach on 21-Jul-18.
 */

public class ChatClientPresenter implements IChatClientPresenter {
    private IChatClientView iChatClientView;
    private ChatClientThread model;

    private String userName;
    private String serverIp;
    private Integer serverPort;
    private CallBack callBack;

    public void init(String userName, String serverIp, Integer serverPort) {
        callBack = new CallBack() {
            @Override
            public void printMessage(String message) {
                iChatClientView.printMsg(message);
            }

            @Override
            public void success() {
                iChatClientView.success();
            }

            @Override
            public void error(String message) {
                iChatClientView.error(message);
            }

            @Override
            public void logout() {
                iChatClientView.logout();
            }
        };
        this.userName = userName;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void connect() {
        onCreate();
    }


    public interface CallBack {
        public void printMessage(String message);

        public void success();

        public void error(String message);

        public void logout();
    }

    public ChatClientPresenter(IChatClientView iChatClientView) {
        this.iChatClientView = iChatClientView;
    }

    @Override
    public void onCreate() {
        model = new ChatClientThread(userName, serverIp, serverPort, callBack);
        model.start();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void disconnect() {
        model.disconnect();
    }

    public void sendMessage(String message) {
        model.sendMessage(message);
    }
}
