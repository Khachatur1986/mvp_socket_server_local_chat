package example.am.mvp_socket_server_local_chat.view.viewInterfaces;

/**
 * Created by Khach on 21-Jul-18.
 */

public interface IChatClientView {
    public void connect();

    public void disconnect();

    public void sendMessage();
}
