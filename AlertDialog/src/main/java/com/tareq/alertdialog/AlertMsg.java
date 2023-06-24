package com.tareq.alertdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertMsg extends Dialog implements View.OnClickListener {

    public static final int SUCCESS_MSG = 0;
    public static final int ERROR_MSG = 1;
    public static final int INFO_MSG = 2;

    protected int msgType;
    protected String posButtonText;
    protected OnPosButtonClickListener posClickListener;
    protected Button posButton;
    protected ImageView msgTypeImage;

    private TextView titleTextView;
    private TextView messageTextView;

    public AlertMsg(Context context) {
        super(context, R.style.CustomAlertDialogStyle);
        setContentView(R.layout.alert_dialog);

        this.msgType = INFO_MSG;
        this.posButtonText = "Ok";
        this.titleTextView = findViewById(R.id.titleTextView);
        this.messageTextView = findViewById(R.id.messageTextView);
        this.msgTypeImage = findViewById(R.id.msgTypeImage);
        this.posButton = findViewById(R.id.okButton);
        this.posButton.setOnClickListener(this);
    }

    public AlertMsg(Context context, int layout) {
        super(context, R.style.CustomAlertDialogStyle);
        setContentView(layout);
        this.msgType = INFO_MSG;
        this.posButtonText = "Ok";
        this.titleTextView = findViewById(R.id.titleTextView);
        this.messageTextView = findViewById(R.id.messageTextView);
        this.msgTypeImage = findViewById(R.id.msgTypeImage);
        this.posButton = findViewById(R.id.okButton);
        this.posButton.setOnClickListener(this);
    }

    public AlertMsg setTitle(String title) {
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(title);
        return this;
    }

    public AlertMsg setMessage(String message) {
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);
        return this;
    }

    public AlertMsg setPosClickListener(OnPosButtonClickListener listener) {
        this.posClickListener = listener;
        return this;
    }

    public AlertMsg setPosButtonText(String okButtonText) {
        this.posButtonText = okButtonText;
        return this;
    }

    public AlertMsg setMsgType(int msgType) {
        this.msgType = msgType;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.okButton) {
            if (posClickListener != null) {
                posClickListener.onPosButtonClicked();
            }
            dismiss();
        }
    }

    public interface OnPosButtonClickListener {
        void onPosButtonClicked();
    }

    @Override
    public void show() {
        switch (this.msgType) {
            case SUCCESS_MSG:
                this.msgTypeImage.setImageResource(R.drawable.checked);
                this.posButton.setBackgroundColor(getContext().getResources().getColor(R.color.successMsg));
                this.posButton.setTextColor(Color.WHITE);
                break;
            case ERROR_MSG:
                this.msgTypeImage.setImageResource(R.drawable.error);
                this.posButton.setBackgroundColor(getContext().getResources().getColor(R.color.errorMsg));
                this.posButton.setTextColor(Color.WHITE);
                break;
            case INFO_MSG:
                this.msgTypeImage.setImageResource(R.drawable.info);
                this.posButton.setBackgroundColor(getContext().getResources().getColor(R.color.infoMsg));
                this.posButton.setTextColor(Color.WHITE);
                break;
            default:
                this.msgTypeImage.setImageResource(R.drawable.info);
                this.posButton.setBackgroundColor(getContext().getResources().getColor(R.color.infoMsg));
                this.posButton.setTextColor(Color.WHITE);

        }
        this.posButton.setText(this.posButtonText);


        super.show();
    }
}
