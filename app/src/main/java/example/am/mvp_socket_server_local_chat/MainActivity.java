package example.am.mvp_socket_server_local_chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import example.am.mvp_socket_server_local_chat.util.DialogUtil;
import example.am.mvp_socket_server_local_chat.view.impl.ChatClientActivity;
import example.am.mvp_socket_server_local_chat.view.impl.ChatServerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence[] options = {"Run as client", "Run as server"};
        DialogUtil.createDialog(MainActivity.this, options, new DialogUtil.WhatToDo() {
            @Override
            public void toDoAction(int selectedOptionIndex) {
                Intent intent;
                switch (selectedOptionIndex) {
                    case 0:
                        intent = new Intent(MainActivity.this, ChatClientActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ChatServerActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
