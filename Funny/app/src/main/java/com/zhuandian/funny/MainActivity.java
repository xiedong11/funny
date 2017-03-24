package com.zhuandian.funny;

import android.graphics.Color;
import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextView = new TextView(this);
        addContentView(mTextView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        String str=" 改变部分字体的颜色。。。。。";
        SpannableStringBuilder mSpannableStringBuilder=new SpannableStringBuilder(str);

        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(Color.RED), 1, 3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(Color.GREEN), 5, 9, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mTextView.setText(mSpannableStringBuilder);

//        http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1009/3553.html


        MyEditText myEditText = (MyEditText) findViewById(R.id.my_edit_text);
        myEditText.setMyEditTextDataChangeListener();
    }


}
