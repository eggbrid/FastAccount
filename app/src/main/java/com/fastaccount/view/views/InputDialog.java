package com.fastaccount.view.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fastaccount.R;

/**
 * Created by xus on 2017/10/16.
 */

public class InputDialog extends Dialog implements View.OnClickListener {
    protected EditText input;
    protected Button chance;
    protected Button ok;
    private OnInputFinishListener onInputFinishListener;

    public void setOnInputFinishListener(OnInputFinishListener onInputFinishListener) {
        this.onInputFinishListener = onInputFinishListener;
    }

    public InputDialog(@NonNull Context context) {
        super(context,R.style.fa_dialog);
    }

    public InputDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.fa_dialog);
    }

    protected InputDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_input);
        initView();
    }

    private void initView() {
        input = (EditText) findViewById(R.id.input);
        chance = (Button) findViewById(R.id.chance);
        ok = (Button) findViewById(R.id.ok);
        chance.setOnClickListener(this);
        ok.setOnClickListener(this);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(input.getText())) {
                    ok.setEnabled(false);
                } else {
                    ok.setEnabled(true);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chance:
                this.dismiss();
                break;
            case R.id.ok:
                if (!TextUtils.isEmpty(input.getText())) {
                    onInputFinishListener.onInputFinish(input.getText().toString());
                }
                this.dismiss();
                break;
        }
    }

    public interface OnInputFinishListener {
        void onInputFinish(String text);
    }
}
