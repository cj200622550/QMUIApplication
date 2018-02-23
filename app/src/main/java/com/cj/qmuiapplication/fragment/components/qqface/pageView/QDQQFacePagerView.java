package com.cj.qmuiapplication.fragment.components.qqface.pageView;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

import com.cj.qmuiapplication.QDQQFaceManager;
import com.cj.qmuiapplication.R;
import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

public class QDQQFacePagerView extends QDQQFaceBasePagerView {
    public QDQQFacePagerView(Context context) {
        super(context);
    }

    @Override
    protected View getView(int position, View convertView, ViewGroup parent) {
        QMUIQQFaceView qmuiqqFaceView;
        if (convertView == null || !(convertView instanceof QMUIQQFaceView)) {
            qmuiqqFaceView = new QMUIQQFaceView(getContext());
            qmuiqqFaceView.setCompiler(QMUIQQFaceCompiler.getInstance(QDQQFaceManager.getInstance()));
            int padding = QMUIDisplayHelper.dp2px(getContext(), 16);
            ViewCompat.setBackground(qmuiqqFaceView, QMUIResHelper.getAttrDrawable(
                    getContext(), R.attr.qmui_s_list_item_bg_with_border_bottom));
            qmuiqqFaceView.setPadding(padding, padding, padding, padding);
            qmuiqqFaceView.setLineSpace(QMUIDisplayHelper.dp2px(getContext(), 10));
            qmuiqqFaceView.setTextColor(Color.BLACK);
            qmuiqqFaceView.setMaxLine(8);
            convertView = qmuiqqFaceView;
        } else {
            qmuiqqFaceView = (QMUIQQFaceView) convertView;
        }
        qmuiqqFaceView.setText(getItem(position));
        return convertView;
    }
}