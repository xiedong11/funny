package com.zhuandian.funny;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by xiedong on 2017/3/24.
 */

public class MyEditText extends LinearLayout {

    private Context mContext;
    private TextView mTitle;
    private EditText mEditText;
    private ImageView mMore;

    private String mTitleText;
    private  String mEditTextHint;
    private boolean mShowIcon;
    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        TypedArray ta = mContext.obtainStyledAttributes(attrs , R.styleable.MyEditText);
        mTitleText = ta.getString(R.styleable.MyEditText_left_text);
        mEditTextHint = ta.getString(R.styleable.MyEditText_edit_hint);
        mShowIcon = ta.getBoolean(R.styleable.MyEditText_show_more_icon,false);

        ta.recycle();

        initView();
    }

    private void initView() {
        View.inflate(mContext,R.layout.my_edittext_layout,this);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mEditText = (EditText) findViewById(R.id.ed_hint);
        mMore = (ImageView) findViewById(R.id.img_more);

        mTitle.setText(mTitleText);
        mEditText.setHint(mEditTextHint);
        mMore.setVisibility(mShowIcon ? VISIBLE : INVISIBLE);

        mMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText("");  //点击清空输入内容
            }
        });
    }



    public void setMyEditTextDataChangeListener(){
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length()>6){
//                    mEditText.setEnabled(false);   //长度大于6位以后不可输入
                    String str = s.toString().substring(0,5);
                    mEditText.setText(str);
                    mEditText.setSelection(str.length());   //设置输入光标在最后，默认光标会回到最前面

                }
                System.out.println(s+"   --------     ");
            }
        });
    }
}
