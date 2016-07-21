package com.example.climbachiya.customalertdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomAlertDialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSingleDoubleDialog(View view) {
        dialog = new CustomAlertDialog(this, "Custom Dialog With Loader");
        dialog.setOwnDialogClick(new DialogInterface() {
            @Override
            public void showWarningDialog(View view) {
                Toast.makeText(MainActivity.this, "Warning", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void showConfirmationDialog(String action) {
                if (action.equalsIgnoreCase(ConstantData.OK)) {
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else if (action.equalsIgnoreCase(ConstantData.CANCEL)) {
                    Toast.makeText(MainActivity.this, "CANCEL", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}