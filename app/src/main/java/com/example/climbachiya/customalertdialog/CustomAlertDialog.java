package com.example.climbachiya.customalertdialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

public class CustomAlertDialog extends AlertDialog {

    DialogInterface onOwnDialog;
    TextView txtMessage;
    String message;
    TextView btnOK, btnCancel;
    Context mContext;

    protected CustomAlertDialog(Context context, String message) {
        super(context);
        this.mContext = context;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_view);

        txtMessage = (TextView) findViewById(R.id.txt_message);
        btnOK = (TextView) findViewById(R.id.button_ok);
        btnCancel = (TextView) findViewById(R.id.button_cancel);

        setMessageText();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOwnDialog.showConfirmationDialog(ConstantData.OK);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOwnDialog.showConfirmationDialog(ConstantData.CANCEL);
            }
        });

        setMessageText();
    }

    public void setMessageText() {
        txtMessage.setText(message);
    }

    public void setOwnDialogClick(DialogInterface myInterface) {
        this.onOwnDialog = myInterface;
    }
}