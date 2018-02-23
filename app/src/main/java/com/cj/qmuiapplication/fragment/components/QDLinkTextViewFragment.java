package com.cj.qmuiapplication.fragment.components;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.textview.QMUILinkTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：LinkTextView
 */

public class QDLinkTextViewFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.link_text_view)
    QMUILinkTextView mLinkTextView;


    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_link_texview_layout, null);
        ButterKnife.bind(this, view);
        initTopBar();
        mLinkTextView.setOnLinkClickListener(mOnLinkClickListener);
        return view;
    }

    private void initTopBar() {
        mTopBar.setTitle(QDDataManager.getInstance().getDescription(this.getClass()).getName());
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
    }

    private QMUILinkTextView.OnLinkClickListener mOnLinkClickListener = new QMUILinkTextView.OnLinkClickListener() {
        @Override
        public void onTelLinkClick(String phoneNumber) {
            Toast.makeText(getContext(), "识别到电话号码是：" + phoneNumber, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onMailLinkClick(String mailAddress) {
            Toast.makeText(getContext(), "识别到邮件地址是：" + mailAddress, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onWebUrlLinkClick(String url) {
            Toast.makeText(getContext(), "识别到网页链接是：" + url, Toast.LENGTH_SHORT).show();
        }
    };
}