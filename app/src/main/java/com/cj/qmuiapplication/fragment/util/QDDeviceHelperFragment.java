package com.cj.qmuiapplication.fragment.util;

import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.cj.qmuiapplication.lib.Group;
import com.cj.qmuiapplication.lib.annotation.Widget;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.util.QMUIDeviceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：DeviceHelper} 的使用示例
 */

@Widget(group = Group.Helper, widgetClass = QMUIDeviceHelper.class, iconRes = R.mipmap.icon_grid_device_helper)
public class QDDeviceHelperFragment extends BaseFragment {

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

    private SpannableString getFormatItemValue(CharSequence value) {
        SpannableString result = new SpannableString(value);
        result.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.qmui_config_color_gray_5)), 0, value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

    private void initContent() {
        String isTabletText = booleanToString(QMUIDeviceHelper.isTablet(getContext()));
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_tablet_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s平板设备", isTabletText))), null)
                .addTo(mGroupListView);

        String isFlymeText = booleanToString(QMUIDeviceHelper.isFlyme());
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_flyme_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s Flyme 系统", isFlymeText))), null)
                .addTo(mGroupListView);

        String isMiuiText = booleanToString(QMUIDeviceHelper.isMIUI());
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_miui_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s MIUI 系统", isMiuiText))), null)
                .addTo(mGroupListView);

        String isMeizuText = booleanToString(QMUIDeviceHelper.isMeizu());
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(getString(R.string.deviceHelper_meizu_title)), null)
                .addItemView(mGroupListView.createItemView(getFormatItemValue(String.format("当前设备%1$s魅族手机", isMeizuText))), null)
                .addTo(mGroupListView);
    }

    private String booleanToString(boolean b) {
        return b ? "是" : "不是";
    }
}
