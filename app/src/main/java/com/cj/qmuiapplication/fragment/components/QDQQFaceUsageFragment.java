package com.cj.qmuiapplication.fragment.components;

import android.view.LayoutInflater;
import android.view.View;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.fragment.components.qqface.pageView.QDQQFaceView;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：QQ表情使用展示
 */

public class QDQQFaceUsageFragment extends BaseFragment {
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.qqface1) QDQQFaceView mQQFace1;
    @BindView(R.id.qqface2)
    QDQQFaceView mQQFace2;
    @BindView(R.id.qqface3) QDQQFaceView mQQFace3;
    @BindView(R.id.qqface4) QDQQFaceView mQQFace4;
    @BindView(R.id.qqface5) QDQQFaceView mQQFace5;
    @BindView(R.id.qqface6) QDQQFaceView mQQFace6;
    @BindView(R.id.qqface7) QDQQFaceView mQQFace7;
    @BindView(R.id.qqface8) QDQQFaceView mQQFace8;
    @BindView(R.id.qqface9) QDQQFaceView mQQFace9;
    @BindView(R.id.qqface10) QDQQFaceView mQQFace10;
    @BindView(R.id.qqface11) QDQQFaceView mQQFace11;
    @BindView(R.id.qqface12) QDQQFaceView mQQFace12;
    @BindView(R.id.qqface13) QDQQFaceView mQQFace13;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_qqface_layout, null);
        ButterKnife.bind(this, view);
        initTopBar();
        initData();
        return view;
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

    private void initData() {
        mQQFace1.setText("这是一行很长很长[微笑][微笑][微笑][微笑]的文本，但是[微笑][微笑][微笑][微笑]只能单行显示");
        mQQFace2.setText("这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行；" +
                "这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行；" +
                "这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行。");
        mQQFace3.setText("这是一行很长很长[微笑][微笑][微笑][微笑]的文本，但是[微笑][微笑][微笑][微笑]只能单行显示");
        mQQFace4.setText("这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行；" +
                "这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行；" +
                "这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行。");
        mQQFace5.setText("这是一行很长很长[微笑][微笑][微笑][微笑]的文本，但是[微笑][微笑][微笑][微笑]只能单行显示");
        mQQFace6.setText("这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行；" +
                "这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行；" +
                "这是一段很长很长[微笑][微笑][微笑][微笑]的文本，但是最多只能显示三行。");

        mQQFace7.setText("[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]");
        mQQFace8.setText("[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]");
        mQQFace9.setText("[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]");
        mQQFace10.setText("[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑]");
        mQQFace11.setText("[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑]");
        mQQFace12.setText("[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑]");
        mQQFace13.setText("表情可以和字体一起变大[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑][微笑]" +
                "[微笑][微笑][微笑][微笑][微笑]");
    }
}
