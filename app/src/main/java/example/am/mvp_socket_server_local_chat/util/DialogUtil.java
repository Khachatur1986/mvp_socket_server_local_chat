package example.am.mvp_socket_server_local_chat.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import example.am.mvp_socket_server_local_chat.R;

public final class DialogUtil {
    public interface WhatToDo {
        public void toDoAction(int selectedOptionIndex);
    }

    public static void createDialog(Activity activity, CharSequence[] options, final WhatToDo whatToDo) {
        AlertDialog.Builder alertDialogBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            alertDialogBuilder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
            alertDialogBuilder = new AlertDialog.Builder(activity, R.style.MyDialogTheme);
        } else {
            alertDialogBuilder = new AlertDialog.Builder(activity);
        }

        alertDialogBuilder.setTitle("Run as")
//                .setMessage("Are you sure you want to delete this entry?")
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // continue with delete
//                    }
//                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert);

        alertDialogBuilder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                whatToDo.toDoAction(which);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
