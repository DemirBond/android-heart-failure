package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomEditText;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class StringEditTextDependantCell extends LinearLayout implements CellItem {
    private CustomTextView textView;
    private CustomEditText editText;
    private LinearLayout primaryContainerView;
    private CustomTextView optionalHintTextView;
    private boolean isCorrect;

    public StringEditTextDependantCell(Context context) {
        super(context);
        inflate(context);
    }

    public StringEditTextDependantCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public StringEditTextDependantCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public StringEditTextDependantCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }

    private void inflate(Context context) {
        inflate(context, R.layout.string_edit_text_cell_dependent, this);
        initView();
    }

    private void initView() {
        textView = (CustomTextView) findViewById(R.id.name);
        editText = (CustomEditText) findViewById(R.id.edit_text);
        optionalHintTextView = findViewById(R.id.optional_hint);
        primaryContainerView = findViewById(R.id.primary_container);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {
        editText.setHint(text);
    }

    public void setNumeric(boolean isWhole) {
        if (isWhole) {
            editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        } else {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }
    }

    public void setNumeric() {
        setNumeric(false);
    }

    public CustomEditText getEditText() {
        return editText;
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    public void setImeOptions(int imeAction) {
        editText.setImeOptions(imeAction);
    }

    public void setEnabled(boolean isEnabled) {
        if (isEnabled) {
            textView.setAlpha(1);
        } else {
            textView.setAlpha(0.4f);
        }
        editText.setEnabled(isEnabled);
    }

    public CustomTextView getOptionalHintTextView() {
        return optionalHintTextView;
    }

    public LinearLayout getPrimaryContainerView() {
        return primaryContainerView;
    }


    public boolean isCorrect() {
        return isCorrect;
    }

    public void setEditable(boolean isEditable) {
        editText.setEnabled(isEditable);
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
        if (isCorrect) {
            textView.setTextColor(Color.parseColor("#7b7b7b"));
        } else {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.snackbar_red));
        }
    }
}