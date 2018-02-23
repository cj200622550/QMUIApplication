package com.cj.qmuiapplication.manager;

import com.cj.qmuiapplication.QDWidgetContainer;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.fragment.components.QDBottomSheetFragment;
import com.cj.qmuiapplication.fragment.components.QDButtonFragment;
import com.cj.qmuiapplication.fragment.components.QDCollapsingTopBarLayoutFragment;
import com.cj.qmuiapplication.fragment.components.QDDialogFragment;
import com.cj.qmuiapplication.fragment.components.QDEmptyViewFragment;
import com.cj.qmuiapplication.fragment.components.QDFloatLayoutFragment;
import com.cj.qmuiapplication.fragment.components.QDGroupListViewFragment;
import com.cj.qmuiapplication.fragment.components.QDLinkTextViewFragment;
import com.cj.qmuiapplication.fragment.components.QDPopupFragment;
import com.cj.qmuiapplication.fragment.components.QDProgressBarFragment;
import com.cj.qmuiapplication.fragment.components.QDPullRefreshFragment;
import com.cj.qmuiapplication.fragment.components.QDQQFaceFragment;
import com.cj.qmuiapplication.fragment.components.QDRadiusImageViewFragment;
import com.cj.qmuiapplication.fragment.components.QDSpanFragment;
import com.cj.qmuiapplication.fragment.components.QDSpanTouchFixTextViewFragment;
import com.cj.qmuiapplication.fragment.components.QDTabSegmentFragment;
import com.cj.qmuiapplication.fragment.components.QDTipDialogFragment;
import com.cj.qmuiapplication.fragment.components.QDVerticalTextViewFragment;
import com.cj.qmuiapplication.fragment.components.QDViewPagerFragment;
import com.cj.qmuiapplication.fragment.lab.QDAnimationListViewFragment;
import com.cj.qmuiapplication.fragment.lab.QDSnapHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDColorHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDDeviceHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDDrawableHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDStatusBarHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDViewHelperFragment;
import com.cj.qmuiapplication.model.QDItemDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：数据管理
 */

public class QDDataManager {
    private static QDDataManager _sInstance;
    private QDWidgetContainer mWidgetContainer;

    private List<Class<? extends BaseFragment>> mComponentsNames;
    private List<Class<? extends BaseFragment>> mUtilNames;
    private List<Class<? extends BaseFragment>> mLabNames;

    public QDDataManager() {
        mWidgetContainer = QDWidgetContainer.getInstance();
        initComponentsDesc();
        initUtilDesc();
        initLabDesc();
    }

    /**
     * 单列
     * @return
     */
    public static QDDataManager getInstance() {
        if (_sInstance == null) {
            _sInstance = new QDDataManager();
        }
        return _sInstance;
    }


    /**
     * Components
     */
    private void initComponentsDesc() {
        mComponentsNames = new ArrayList<>();
        mComponentsNames.add(QDButtonFragment.class);
        mComponentsNames.add(QDDialogFragment.class);
        mComponentsNames.add(QDFloatLayoutFragment.class);
        mComponentsNames.add(QDEmptyViewFragment.class);
        mComponentsNames.add(QDTabSegmentFragment.class);
        mComponentsNames.add(QDProgressBarFragment.class);
        mComponentsNames.add(QDBottomSheetFragment.class);
        mComponentsNames.add(QDGroupListViewFragment.class);
        mComponentsNames.add(QDTipDialogFragment.class);
        mComponentsNames.add(QDRadiusImageViewFragment.class);
        mComponentsNames.add(QDVerticalTextViewFragment.class);
        mComponentsNames.add(QDPullRefreshFragment.class);
        mComponentsNames.add(QDPopupFragment.class);
        mComponentsNames.add(QDSpanTouchFixTextViewFragment.class);
        mComponentsNames.add(QDLinkTextViewFragment.class);
        mComponentsNames.add(QDQQFaceFragment.class);
        mComponentsNames.add(QDSpanFragment.class);
        mComponentsNames.add(QDCollapsingTopBarLayoutFragment.class);
        mComponentsNames.add(QDViewPagerFragment.class);
    }

    /**
     * Helper
     */
    private void initUtilDesc() {
        mUtilNames = new ArrayList<>();
        mUtilNames.add(QDColorHelperFragment.class);
        mUtilNames.add(QDDeviceHelperFragment.class);
        mUtilNames.add(QDDrawableHelperFragment.class);
        mUtilNames.add(QDStatusBarHelperFragment.class);
        mUtilNames.add(QDViewHelperFragment.class);
    }

    /**
     * Lab
     */
    private void initLabDesc() {
        mLabNames = new ArrayList<>();
        mLabNames.add(QDAnimationListViewFragment.class);
        mLabNames.add(QDSnapHelperFragment.class);
    }

    public QDItemDescription getDescription(Class<? extends BaseFragment> cls) {
        return mWidgetContainer.get(cls);
    }

    public String getName(Class<? extends BaseFragment> cls) {
        QDItemDescription itemDescription = getDescription(cls);
        if (itemDescription == null) {
            return null;
        }
        return itemDescription.getName();
    }

    public List<QDItemDescription> getComponentsDescriptions() {
        List<QDItemDescription> list = new ArrayList<>();
        for (int i = 0; i < mComponentsNames.size(); i++) {
            list.add(mWidgetContainer.get(mComponentsNames.get(i)));
        }
        return list;
    }

    public List<QDItemDescription> getUtilDescriptions() {
        List<QDItemDescription> list = new ArrayList<>();
        for (int i = 0; i < mUtilNames.size(); i++) {
            list.add(mWidgetContainer.get(mUtilNames.get(i)));
        }
        return list;
    }

    public List<QDItemDescription> getLabDescriptions() {
        List<QDItemDescription> list = new ArrayList<>();
        for (int i = 0; i < mLabNames.size(); i++) {
            list.add(mWidgetContainer.get(mLabNames.get(i)));
        }
        return list;
    }
}
