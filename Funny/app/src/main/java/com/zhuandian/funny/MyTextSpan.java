package com.zhuandian.funny;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

/**
 * Created by xiedong on 2017/4/24.
 */

public class MyTextSpan extends ClickableSpan {



    @Override
    public void onClick(View widget) {

        System.out.println("sdfa");
    }


    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.WHITE);
        ds.setUnderlineText(false);  //取消下划线
    }
}
