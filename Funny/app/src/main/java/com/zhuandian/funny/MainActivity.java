package com.zhuandian.funny;

import android.graphics.Color;
import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jauker.widget.BadgeView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private TextView mTextView;
    private TextView message;
    private BadgeView messageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        看一下badgeview中常用的方法：
//        1. setTargetView(View) --> 设置哪个控件显示数字提醒，参数就是一个view对象
//        2. setBadgeCount(int) --> 设置提醒的数字
//        3. setBadgeGravity(Gravity) --> 设置badgeview的显示位置
//        4. setBackgroundColor() --> 设置badgeview的背景色，当然还可以设置背景图片
//        5. setBackgroundResource() --> 设置背景图片
//        6. setTypeface() --> 设置显示的字体
//        7. setShadowLayer() --> 设置字体的阴影
        message = (TextView) findViewById(R.id.message);
        BadgeView badgeView = new com.jauker.widget.BadgeView(this);
        badgeView.setTargetView(message);
        badgeView.setBadgeCount(3);



        mTextView = new TextView(this);
        addContentView(mTextView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

       /* String str=" 改变部分字体的颜色。。。。。";
        SpannableStringBuilder mSpannableStringBuilder=new SpannableStringBuilder(str);

        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(Color.RED), 1, 3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(Color.GREEN), 5, 9, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mTextView.setText(mSpannableStringBuilder);
*/
//        http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1009/3553.html


        MyEditText myEditText = (MyEditText) findViewById(R.id.my_edit_text);
        myEditText.setMyEditTextDataChangeListener();



        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date curDate = new Date(System.currentTimeMillis());

        String time = sdf.format(curDate);
        System.out.println(time);

        testSpannableString();
    }

    private void testSpannableString() {

        SpannableString words = new SpannableString("dddfdasfdfafdafdsfsdfsdafasdfsdafdsd");

        SpannableStringBuilder ssb = new SpannableStringBuilder("ff");
        ssb.append("aa");
        ssb.append("dd");


        //设置字体颜色
        ForegroundColorSpan span  =  new ForegroundColorSpan(Color.BLUE);
        words.setSpan(span,2,5 , Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        //设置字体背景
        BackgroundColorSpan spanBg = new BackgroundColorSpan(Color.RED);
        words.setSpan(spanBg,5,7,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        //设置字体大小
        AbsoluteSizeSpan spanSize = new AbsoluteSizeSpan(44);
        words.setSpan(spanSize,8,10,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        words.setSpan(new MyTextSpan(),1,16,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        mTextView.setText(words);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());


    }


}
