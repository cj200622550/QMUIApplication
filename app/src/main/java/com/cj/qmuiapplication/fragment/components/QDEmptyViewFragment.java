package com.cj.qmuiapplication.fragment.components;

import android.view.LayoutInflater;
import android.view.View;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：EmptyView 的使用示例
 */

public class QDEmptyViewFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.emptyView)
    QMUIEmptyView mEmptyView;

    private QDItemDescription mQDItemDescription;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_emptyview, null);
        ButterKnife.bind(this, root);

        mQDItemDescription = QDDataManager.getInstance().getDescription(this.getClass());
        initTopBar();

        return root;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        // 切换其他情况的按钮
        mTopBar.addRightImageButton(R.mipmap.icon_topbar_overflow, R.id.topbar_right_change_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetList();
            }
        });

        mTopBar.setTitle(mQDItemDescription.getName());
    }

    private void showBottomSheetList() {
        new QMUIBottomSheet.BottomListSheetBuilder(getActivity())
                .addItem(getResources().getString(R.string.emptyView_mode_title_double_text))
                .addItem(getResources().getString(R.string.emptyView_mode_title_single_text))
                .addItem(getResources().getString(R.string.emptyView_mode_title_loading))
                .addItem(getResources().getString(R.string.emptyView_mode_title_single_text_and_button))
                .addItem(getResources().getString(R.string.emptyView_mode_title_double_text_and_button))
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                        dialog.dismiss();
                        switch (position) {
                            case 0:
                                mEmptyView.show(getResources().getString(R.string.emptyView_mode_desc_double), getResources().getString(R.string.emptyView_mode_desc_detail_double));
                                break;
                            case 1:
                                mEmptyView.show(getResources().getString(R.string.emptyView_mode_desc_single), null);
                                break;
                            case 2:
                                mEmptyView.show(true);
                                break;
                            case 3:
                                mEmptyView.show(false, getResources().getString(R.string.emptyView_mode_desc_fail_title), null, getResources().getString(R.string.emptyView_mode_desc_retry), null);
                                break;
                            case 4:
                                mEmptyView.show(false, getResources().getString(R.string.emptyView_mode_desc_fail_title), getResources().getString(R.string.emptyView_mode_desc_fail_desc), getResources().getString(R.string.emptyView_mode_desc_retry), null);
                                break;
                            default:
                                break;
                        }
                    }
                })
                .build()
                .show();
    }
}

