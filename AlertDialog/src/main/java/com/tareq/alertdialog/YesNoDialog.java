package com.tareq.alertdialog;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

public class YesNoDialog extends AlertMsg{

    private String negButtonText;
    private Button negButton;
    private OnNegButtonClickListener negButtonClickListener;


    public YesNoDialog(Context context) {
        super(context, R.layout.yes_no_dialog);

        this.negButtonText = "No";
        this.posButtonText = "Yes";
        this.negButton = findViewById(R.id.noButton);
        this.negButton.setOnClickListener(this);
    }


    public YesNoDialog setNegButtonClickListener(OnNegButtonClickListener negButtonClickListener) {
        this.negButtonClickListener = negButtonClickListener;
        return this;
    }

    public interface OnNegButtonClickListener {
        void onNegButtonClicked();
    }

    public YesNoDialog setNegButtonText(String negButtonText) {
        this.negButtonText = negButtonText;
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

        if(v.getId() == R.id.noButton) {
            if (negButtonClickListener != null) {
                negButtonClickListener.onNegButtonClicked();
            }
            dismiss();
        }
    }


    @Override
    public void show() {
        super.show();
        switch (this.msgType) {
            case SUCCESS_MSG:
                this.msgTypeImage.setImageResource(R.drawable.checked);
                break;
            case ERROR_MSG:
                this.msgTypeImage.setImageResource(R.drawable.error);
                break;
            case INFO_MSG:
                this.msgTypeImage.setImageResource(R.drawable.info);
                break;
            default:
                this.msgTypeImage.setImageResource(R.drawable.info);
        }
        this.posButton.setText(this.posButtonText);
        this.negButton.setText(this.negButtonText);
        this.posButton.setBackgroundColor(getContext().getResources().getColor(R.color.successMsg));
        this.posButton.setTextColor(Color.WHITE);
    }
}
