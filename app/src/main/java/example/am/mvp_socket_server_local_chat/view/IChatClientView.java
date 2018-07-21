package example.am.mvp_socket_server_local_chat.view;

/**
 * Created by Khach on 21-Jul-18.
 */

public interface IChatClientView {
    public void connect();

    public void disconnect();

    public void sendMessage(String message);

    public void printMsg(String message);

    public void error(String message);

    public void logout();
}
