package example.am.mvp_socket_server_local_chat.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import example.am.mvp_socket_server_local_chat.R;

public final class DialogUtil {

    public static void createDialog(Context context) {
        AlertDialog.Builder alertDialogBuilder;
        CharSequence[] options = {"Run as client", "Run as server"};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            alertDialogBuilder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
            alertDialogBuilder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        } else {
            alertDialogBuilder = new AlertDialog.Builder(context);
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

    }
}
