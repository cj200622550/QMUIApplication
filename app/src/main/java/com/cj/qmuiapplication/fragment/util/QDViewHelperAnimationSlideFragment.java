package com.cj.qmuiapplication.fragment.util;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.qmuiteam.qmui.util.QMUIDirection;
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
 * 作用： ViewHelper#slideIn(View, int, Animation.AnimationListener, boolean, QMUIDirection) 与
 * ViewHelper#slideOut(View, int, Animation.AnimationListener, boolean, QMUIDirection) 的使用示例。
 * Slide 进退场动画
 */

public class QDViewHelperAnimationSlideFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.actiontBtn)
    QMUIRoundButton mActionButton;
    @BindView(R.id.popup)
    TextView mPopupView;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viewhelper_animation_show_and_hide, null);
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
        mActionButton.setText("点击显示浮层");
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupView.getVisibility() == View.GONE) {
                    mActionButton.setText("点击关闭浮层");
                    mPopupView.setText("以 Slide 动画显示本浮层");
                    QMUIViewHelper.slideIn(mPopupView, 500, null, true, QMUIDirection.TOP_TO_BOTTOM);
                } else {
                    mActionButton.setText("点击显示浮层");
                    mPopupView.setText("以 Slide 动画隐藏本浮层");
                    QMUIViewHelper.slideOut(mPopupView, 500, null, true, QMUIDirection.BOTTOM_TO_TOP);

                }
            }
        });
    }
}
