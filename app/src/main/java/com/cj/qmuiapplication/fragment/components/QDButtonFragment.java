package com.cj.qmuiapplication.fragment.components;

import android.view.LayoutInflater;
import android.view.View;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/1
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：Button 列子
 */

public class QDButtonFragment extends BaseFragment {
    private QDItemDescription mQDItemDescription;

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

    @Override
    protected View onCreateView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_button, null);
        ButterKnife.bind(this, inflate);
        mQDItemDescription = QDDataManager.getInstance().getDescription(getClass());
        initTopBar();
        return inflate;
    }

    private void initTopBar() {
        //点击返回按钮
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QDButtonFragment.this.popBackStack();
            }
        });
        mTopBar.setTitle(this.mQDItemDescription.getName());
    }

}
