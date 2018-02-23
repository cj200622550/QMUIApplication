package com.cj.qmuiapplication.fragment.components.qqface.pageView;

import android.content.Context;
import android.util.AttributeSet;

import com.cj.qmuiapplication.QDQQFaceManager;
import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

public class QDQQFaceView extends QMUIQQFaceView {
    public QDQQFaceView(Context context) {
        this(context, null);
    }

    public QDQQFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCompiler(QMUIQQFaceCompiler.getInstance(QDQQFaceManager.getInstance()));
    }
}
