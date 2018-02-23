package com.cj.qmuiapplication.fragment.util;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：ViewHelper#playBackgroundBlinkAnimation(View, int)} 的使用示例
 */

public class QDViewHelperBackgroundAnimationBlinkFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.actiontBtn)
    QMUIRoundButton mActionButton;
    @BindView(R.id.container)
    ViewGroup mContainer;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewhelper_background_animation, null);
        ButterKnife.bind(this, root);

        initTopBar();
        initContent();

        return root;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        mTopBar.setTitle(QDDataManager.getInstance().getName(this.getClass()));
    }

    private void initContent() {
        mActionButton.setText("点击后开始闪动");
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QMUIViewHelper.playBackgroundBlinkAnimation(mContainer, ContextCompat.getColor(getContext(), R.color.app_color_theme_3));
            }
        });
    }
}
