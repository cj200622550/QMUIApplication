package com.cj.qmuiapplication.fragment.components.qqface.pageView;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.fragment.components.qqface.emojicon.EmojiconTextView;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

public class QDEmojiconPagerView extends QDQQFaceBasePagerView {
    public QDEmojiconPagerView(Context context) {
        super(context);
    }

    @Override
    protected View getView(int position, View convertView, ViewGroup parent) {
        EmojiconTextView emojiconTextView;
        if (convertView == null || !(convertView instanceof EmojiconTextView)) {
            emojiconTextView = new EmojiconTextView(getContext());
            emojiconTextView.setTextSize(14);
            int padding = QMUIDisplayHelper.dp2px(getContext(), 16);
            ViewCompat.setBackground(emojiconTextView, QMUIResHelper.getAttrDrawable(
                    getContext(), R.attr.qmui_s_list_item_bg_with_border_bottom));
            emojiconTextView.setPadding(padding, padding, padding, padding);
            emojiconTextView.setMaxLines(8);
            emojiconTextView.setTextColor(Color.BLACK);
            emojiconTextView.setMovementMethodDefault();
            convertView = emojiconTextView;
        } else {
            emojiconTextView = (EmojiconTextView) convertView;
        }
        emojiconTextView.setText(getItem(position));
        return convertView;
    }
}
