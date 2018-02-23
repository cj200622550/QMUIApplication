package com.cj.qmuiapplication.fragment.util;

import android.view.LayoutInflater;
import android.view.View;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：ViewHelper} 内各种方法的使用示例
 */

public class QDViewHelperFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;
    private QDItemDescription mQDItemDescription;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_grouplistview, null);
        ButterKnife.bind(this, root);

        mQDItemDescription = QDDataManager.getInstance().getDescription(this.getClass());
        initTopBar();

        initContentView();

        return root;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        mTopBar.setTitle(mQDItemDescription.getName());
    }

    private void initContentView() {
        QMUIGroupListView.newSection(getContext())
                .setTitle("背景动画")
                .addItemView(mGroupListView.createItemView(QDDataManager.getInstance().getName(QDViewHelperBackgroundAnimationBlinkFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDViewHelperBackgroundAnimationBlinkFragment fragment = new QDViewHelperBackgroundAnimationBlinkFragment();
                        startFragment(fragment);
                    }
                })
                .addItemView(mGroupListView.createItemView(QDDataManager.getInstance().getName(QDViewHelperBackgroundAnimationFullFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDViewHelperBackgroundAnimationFullFragment fragment = new QDViewHelperBackgroundAnimationFullFragment();
                        startFragment(fragment);
                    }
                })
                .addTo(mGroupListView);

        QMUIGroupListView.newSection(getContext())
                .setTitle("进退场动画")
                .addItemView(mGroupListView.createItemView(QDDataManager.getInstance().getName(QDViewHelperAnimationFadeFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDViewHelperAnimationFadeFragment fragment = new QDViewHelperAnimationFadeFragment();
                        startFragment(fragment);
                    }
                })
                .addItemView(mGroupListView.createItemView(QDDataManager.getInstance().getName(QDViewHelperAnimationSlideFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        QDViewHelperAnimationSlideFragment fragment = new QDViewHelperAnimationSlideFragment();
                        startFragment(fragment);
                    }
                })
                .addTo(mGroupListView);
    }

}
