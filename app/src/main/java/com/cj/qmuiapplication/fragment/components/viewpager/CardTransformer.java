package com.cj.qmuiapplication.fragment.components.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

public class CardTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        // 刷新数据notifyDataSetChange之后也会调用到transformPage，但此时的position可能不在[-1, 1]之间
        if (position <= -1 || position >= 1f) {
            page.setRotation(0);
        } else {
            page.setRotation(position * 30);
            page.setPivotX(page.getWidth() * .5f);
            page.setPivotY(page.getHeight() * 1f);
        }
    }
}