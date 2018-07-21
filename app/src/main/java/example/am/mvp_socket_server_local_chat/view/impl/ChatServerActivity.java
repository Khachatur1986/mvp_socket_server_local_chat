package example.am.mvp_socket_server_local_chat.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.am.mvp_socket_server_local_chat.R;
import example.am.mvp_socket_server_local_chat.view.IChatServerView;

public class ChatServerActivity extends AppCompatActivity implements IChatServerView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_server);
    }

    @Override
    public void startServer() {

    }

    @Override
    public void stopServer() {

    }

    @Override
    public void broadcastMessage() {

    }

    @Override
    public void sendMessage() {

    }
}
