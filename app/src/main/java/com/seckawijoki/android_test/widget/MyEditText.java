package com.seckawijoki.android_test.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seckawijoki.android_test.R;
import com.seckawijoki.android_test.util.DensityUtil;

/**
 * Created by seckawijoki on 18-5-3 at 下午1:52.
 */
public class MyEditText extends RelativeLayout {
    private static final int DEFAULT_TITLE_COLOR = Color.BLACK;
    private static final int DEFAULT_TITLE_SIZE = 16;
    private static final int DEFAULT_CONTENT_COLOR = Color.BLACK;
    private static final int DEFAULT_CONTENT_SIZE = 16;
    private static final int DEFAULT_HINT_RES = R.string.my_edit_text_hint;
    private static final int DEFAULT_CLEAR_BUTTON_RES = R.mipmap.ic_clear;
    private TextView tvTitle;
    private EditText et;
    private ImageView imgClear;
    private final OnClickListener CLEAR_LISTENER = new OnClickListener() {
        @Override
        public void onClick(View v) {
            clear();
        }
    };
    private final TextWatcher DEFAULT_TEXT_WATCHER = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() <= 0 || TextUtils.isEmpty(s)){
                imgClear.setVisibility(GONE);
            } else {
                imgClear.setVisibility(VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public MyEditText(Context context) {
        super(context, null);
        initView(context);
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        initView(context);
        initAttr(context, attrs);
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttr(context, attrs);

    }

    private void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.my_edit_text, this);
        tvTitle = view.findViewById(R.id.my_edit_text_title);
        et = view.findViewById(R.id.my_edit_text);
        imgClear = view.findViewById(R.id.my_edit_text_clear_text);
    }

    private void initAttr(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyEditText);
        String titleText = ta.getString(R.styleable.MyEditText_TitleText);
        setTitle(titleText);
        tvTitle.setTextColor(ta.getColor(R.styleable.MyEditText_TitleTextColor, DEFAULT_TITLE_COLOR));
        tvTitle.setTextSize(ta.getDimension(R.styleable.MyEditText_TitleTextSize, DEFAULT_TITLE_SIZE));
        et.setHint(ta.getResourceId(R.styleable.MyEditText_EditHint, DEFAULT_HINT_RES));
        et.setTextColor(ta.getColor(R.styleable.MyEditText_EditTextColor, DEFAULT_CONTENT_COLOR));
        et.setTextSize(ta.getColor(R.styleable.MyEditText_EditTextSize, DEFAULT_CONTENT_SIZE));
        et.addTextChangedListener(DEFAULT_TEXT_WATCHER);
        boolean singleLine = ta.getBoolean(R.styleable.MyEditText_SingleLine, false);
        if (singleLine){
            et.setMaxLines(1);
        } else {
            et.setMaxLines(Integer.MAX_VALUE);
        }
        imgClear.setImageResource(ta.getResourceId(R.styleable.MyEditText_ClearButton, DEFAULT_CLEAR_BUTTON_RES));
        imgClear.setVisibility(GONE);
        imgClear.setOnClickListener(CLEAR_LISTENER);
        ta.recycle();
    }

    public void setTitle(String title){
        if(TextUtils.isEmpty(title)){
            tvTitle.setVisibility(GONE);
        } else {
            tvTitle.setVisibility(VISIBLE);
            tvTitle.setText(title);
        }
    }

    public void setTitle(@StringRes int titleRes){
        setTitle(getResources().getString(titleRes));
    }

    public void addTextChangedListener(TextWatcher textWatcher){
        et.addTextChangedListener(textWatcher);
    }

    public void setHint(String hint){
        et.setHint(hint);
    }

    public void setHint(@StringRes int hintRes){
        et.setHint(hintRes);
    }

    public void clear(){
        et.setText("");
        imgClear.setVisibility(GONE);
    }

}
