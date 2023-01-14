package com.example.taomenu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CustomDialog extends Dialog{
    interface FullNameListener {
        public void fullNameEntered();
    }
    public Context context;
    private Button buttonOK;
    private Button buttonCancel;
    private CustomDialog.FullNameListener listener;

    public CustomDialog(Context context, CustomDialog.FullNameListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);

        this.buttonOK = (Button) findViewById(R.id.button_ok);
        this.buttonCancel  = (Button) findViewById(R.id.button_cancel);

        this.buttonOK .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOKClick();
            }
        });
        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCancelClick();
            }
        });
    }
    // User click "OK" button.
    private void buttonOKClick()  {
        this.dismiss(); // Close Dialog
        if(this.listener!= null)  {
            this.listener.fullNameEntered();
        }
    }
    // User click "Cancel" button.
    private void buttonCancelClick()  {
        this.dismiss();
    }
}
