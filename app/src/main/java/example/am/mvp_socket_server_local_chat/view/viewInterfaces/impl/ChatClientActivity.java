package example.am.mvp_socket_server_local_chat.view.viewInterfaces.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.am.mvp_socket_server_local_chat.R;
import example.am.mvp_socket_server_local_chat.view.viewInterfaces.IChatClientView;

public class ChatClientActivity extends AppCompatActivity implements IChatClientView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_client);
    }

    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void sendMessage() {

    }
}
