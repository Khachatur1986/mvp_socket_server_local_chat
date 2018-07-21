package example.am.mvp_socket_server_local_chat.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import example.am.mvp_socket_server_local_chat.R;
import example.am.mvp_socket_server_local_chat.presenter.impl.ChatClientPresenter;
import example.am.mvp_socket_server_local_chat.view.IChatClientView;

public class ChatClientActivity extends AppCompatActivity implements IChatClientView, View.OnClickListener {
    private ChatClientPresenter presenter = new ChatClientPresenter(this);

    private LinearLayout ll_chat_client_login_panel;
    private EditText et_chat_client_userName;
    private EditText et_chat_client_serverIp;
    private EditText et_chat_client_serverPort;
    private Button btn_chat_client_connect;

    private LinearLayout ll_chat_client_chatPanel;
    private Button btn_chat_client_disconnect;
    private EditText et_chat_client_msg;
    private Button btn_chat_client_sendMsg;
    private TextView tv_chat_client_messages;

    private String userName;
    private String serverIp;
    private String serverPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_client);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        btn_chat_client_connect.setOnClickListener(this);
        btn_chat_client_disconnect.setOnClickListener(this);
        btn_chat_client_sendMsg.setOnClickListener(this);
    }

    private void initViews() {
        ll_chat_client_login_panel = findViewById(R.id.ll_chat_client_login_panel);
        et_chat_client_userName = findViewById(R.id.et_chat_client_userName);
        et_chat_client_userName = findViewById(R.id.et_chat_client_userName);
        et_chat_client_serverIp = findViewById(R.id.et_chat_client_serverIp);
        et_chat_client_serverPort = findViewById(R.id.et_chat_client_serverPort);
        btn_chat_client_connect = findViewById(R.id.btn_chat_client_connect);

        ll_chat_client_chatPanel = findViewById(R.id.ll_chat_client_chatPanel);
        btn_chat_client_disconnect = findViewById(R.id.btn_chat_client_disconnect);
        et_chat_client_msg = findViewById(R.id.et_chat_client_msg);
        btn_chat_client_sendMsg = findViewById(R.id.btn_chat_client_sendMsg);
        tv_chat_client_messages = findViewById(R.id.tv_chat_client_messages);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void printMsg(String message) {
        tv_chat_client_messages.append(message + "\n");
    }

    @Override
    public void error(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ChatClientActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void logout() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_chat_client_messages.setText("");
                ll_chat_client_login_panel.setVisibility(View.VISIBLE);
                ll_chat_client_chatPanel.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_chat_client_connect:
                userName = et_chat_client_userName.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(ChatClientActivity.this, "Enter User name", Toast.LENGTH_SHORT).show();
                    return;
                }
                serverIp = et_chat_client_serverIp.getText().toString();
                if (TextUtils.isEmpty(serverIp)) {
                    Toast.makeText(ChatClientActivity.this, "Enter destination address", Toast.LENGTH_SHORT).show();
                    return;
                }
                serverPort = et_chat_client_serverPort.getText().toString();
                if (TextUtils.isEmpty(serverPort)) {
                    Toast.makeText(ChatClientActivity.this, "Enter port number", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.init(userName, serverIp, Integer.valueOf(serverPort));
                presenter.onCreate();
                break;
            case R.id.btn_chat_client_disconnect:
                presenter.disconnect();
                ll_chat_client_login_panel.setVisibility(View.VISIBLE);
                ll_chat_client_chatPanel.setVisibility(View.GONE);
                break;
            case R.id.btn_chat_client_sendMsg:
                String message = et_chat_client_msg.getText().toString();
                if (!TextUtils.isEmpty(message)) {
                    presenter.sendMessage(message);
                    et_chat_client_msg.setText("");
                }
                break;
        }
    }
}
