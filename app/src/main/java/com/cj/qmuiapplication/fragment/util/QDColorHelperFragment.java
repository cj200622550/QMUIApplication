package com.cj.qmuiapplication.fragment.util;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.util.QMUIColorHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：ColorHelper} 的使用示例
 */

public class QDColorHelperFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.square_alpha)
    View mAlphaView;
    @BindView(R.id.square_desc_alpha)
    TextView mAlphaTextView;
    @BindView(R.id.ratioSeekBar)
    SeekBar mRatioSeekBar;
    @BindView(R.id.transformTextView) TextView mTransformTextView;
    @BindView(R.id.ratioSeekBarWrap)
    LinearLayout mRatioSeekBarWrap;

    private QDItemDescription mQDItemDescription;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_colorhelper, null);
        ButterKnife.bind(this, root);

        mQDItemDescription = QDDataManager.getInstance().getDescription(this.getClass());
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

        mTopBar.setTitle(mQDItemDescription.getName());
    }

    private void initContent() {
        // 设置颜色的 alpha 值
        float alpha = 0.5f;
        int alphaColor = QMUIColorHelper.setColorAlpha(ContextCompat.getColor(getContext(), R.color.colorHelper_square_alpha_background), alpha);
        mAlphaView.setBackgroundColor(alphaColor);
        mAlphaTextView.setText(String.format(getResources().getString(R.string.colorHelper_squqre_alpha), alpha));

        // 根据比例，在两个 color 值之间计算出一个 color 值
        final int fromColor = ContextCompat.getColor(getContext(), R.color.colorHelper_square_from_ratio_background);
        final int toColor = ContextCompat.getColor(getContext(), R.color.colorHelper_square_to_ratio_background);

        mRatioSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int ratioColor = QMUIColorHelper.computeColor(fromColor, toColor, (float) progress / 100);
                mRatioSeekBarWrap.setBackgroundColor(ratioColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mRatioSeekBar.setProgress(50);

        // 将 color 颜色值转换为字符串
        String transformColor = QMUIColorHelper.colorToString(mTransformTextView.getCurrentTextColor());
        mTransformTextView.setText(String.format("这个 TextView 的字体颜色是：%1$s", transformColor));
    }
}
