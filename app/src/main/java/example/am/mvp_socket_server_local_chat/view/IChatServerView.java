package example.am.mvp_socket_server_local_chat.view;

/**
 * Created by Khach on 21-Jul-18.
 */

public interface IChatServerView {
    public void startServer();

    public void stopServer();

    public void broadcastMessage();

    public void sendMessage();
}
