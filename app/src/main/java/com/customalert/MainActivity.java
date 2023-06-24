package com.customalert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tareq.alertdialog.AlertMsg;
import com.tareq.alertdialog.YesNoDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlertMsgInfo = findViewById(R.id.btnAlertMsgInfo);
        Button btnAlertMsgError = findViewById(R.id.btnAlertMsgError);
        Button btnAlertMsgSuccess = findViewById(R.id.btnAlertMsgSuccess);

        Button btnYesNoAlertMsg = findViewById(R.id.btnAlertYesNoMsg);

        btnYesNoAlertMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showYesNoDialog();
            }
        });

        btnAlertMsgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMsgDialogInfo();
            }
        });


        btnAlertMsgError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMsgDialogError();
            }
        });

        btnAlertMsgSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMsgDialogSuccess();
            }
        });

    }

    public void showMsgDialogSuccess() {
        AlertMsg dialog = new AlertMsg(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Ok")
                .setMsgType(AlertMsg.SUCCESS_MSG)
                .setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
                    @Override
                    public void onPosButtonClicked() {
                        Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        dialog.show();
    }

    public void showMsgDialogError() {
        AlertMsg dialog = new AlertMsg(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Ok")
                .setMsgType(AlertMsg.ERROR_MSG)
                .setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
                    @Override
                    public void onPosButtonClicked() {
                        Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        dialog.show();
    }

    public void showMsgDialogInfo() {
        AlertMsg dialog = new AlertMsg(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Ok")
                .setMsgType(AlertMsg.INFO_MSG)
                .setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
                    @Override
                    public void onPosButtonClicked() {
                        Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        dialog.show();
    }

    public void showYesNoDialog() {
        YesNoDialog yesNoDialog = (YesNoDialog) new YesNoDialog(this)
                .setTitle("Custom Alert")
                .setMessage("This is a custom alert dialog!")
                .setPosButtonText("Yes")
                .setMsgType(AlertMsg.INFO_MSG);

        yesNoDialog.setNegButtonClickListener(new YesNoDialog.OnNegButtonClickListener() {
            @Override
            public void onNegButtonClicked() {
                Toast.makeText(MainActivity.this, "Neg button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        yesNoDialog.setPosClickListener(new AlertMsg.OnPosButtonClickListener() {
            @Override
            public void onPosButtonClicked() {
                Toast.makeText(MainActivity.this, "Pos button clicked", Toast.LENGTH_SHORT).show();

            }
        });

        yesNoDialog.show();
    }
}