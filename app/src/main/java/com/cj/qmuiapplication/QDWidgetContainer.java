package com.cj.qmuiapplication;

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
import com.cj.qmuiapplication.fragment.components.QDQQFacePerformanceTestFragment;
import com.cj.qmuiapplication.fragment.components.QDQQFaceUsageFragment;
import com.cj.qmuiapplication.fragment.components.QDRadiusImageViewFragment;
import com.cj.qmuiapplication.fragment.components.QDSpanFragment;
import com.cj.qmuiapplication.fragment.components.QDSpanTouchFixTextViewFragment;
import com.cj.qmuiapplication.fragment.components.QDTabSegmentFixModeFragment;
import com.cj.qmuiapplication.fragment.components.QDTabSegmentFragment;
import com.cj.qmuiapplication.fragment.components.QDTabSegmentScrollableModeFragment;
import com.cj.qmuiapplication.fragment.components.QDTipDialogFragment;
import com.cj.qmuiapplication.fragment.components.QDVerticalTextViewFragment;
import com.cj.qmuiapplication.fragment.components.QDViewPagerFragment;
import com.cj.qmuiapplication.fragment.components.viewpager.QDFitSystemWindowViewPagerFragment;
import com.cj.qmuiapplication.fragment.components.viewpager.QDLoopViewPagerFragment;
import com.cj.qmuiapplication.fragment.lab.QDAnimationListViewFragment;
import com.cj.qmuiapplication.fragment.lab.QDSnapHelperFragment;
import com.cj.qmuiapplication.fragment.lab.QDSwipeDeleteListViewFragment;
import com.cj.qmuiapplication.fragment.util.QDColorHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDDeviceHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDDrawableHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDStatusBarHelperFragment;
import com.cj.qmuiapplication.fragment.util.QDViewHelperAnimationFadeFragment;
import com.cj.qmuiapplication.fragment.util.QDViewHelperAnimationSlideFragment;
import com.cj.qmuiapplication.fragment.util.QDViewHelperBackgroundAnimationBlinkFragment;
import com.cj.qmuiapplication.fragment.util.QDViewHelperBackgroundAnimationFullFragment;
import com.cj.qmuiapplication.fragment.util.QDViewHelperFragment;
import com.cj.qmuiapplication.model.QDItemDescription;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/1
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

public class QDWidgetContainer {
    private static QDWidgetContainer sInstance = new QDWidgetContainer();
    private Map<Class<? extends BaseFragment>, QDItemDescription> mWidgets = new HashMap();

    private QDWidgetContainer() {
        this.mWidgets.put(QDButtonFragment.class, new QDItemDescription(QDButtonFragment.class, "RoundButton", R.mipmap.icon_grid_button));
        this.mWidgets.put(QDDialogFragment.class, new QDItemDescription(QDDialogFragment.class, "QMUIDialog", R.mipmap.icon_grid_dialog));
        this.mWidgets.put(QDFloatLayoutFragment.class, new QDItemDescription(QDFloatLayoutFragment.class, "QMUIFloatLayout", R.mipmap.icon_grid_float_layout));
        this.mWidgets.put(QDEmptyViewFragment.class, new QDItemDescription(QDEmptyViewFragment.class, "QMUIEmptyView", R.mipmap.icon_grid_empty_view));
        this.mWidgets.put(QDTabSegmentFragment.class, new QDItemDescription(QDTabSegmentFragment.class, "QMUITabSegment", R.mipmap.icon_grid_tab_segment));
        this.mWidgets.put(QDProgressBarFragment.class, new QDItemDescription(QDProgressBarFragment.class, "QMUIProgressBar", R.mipmap.icon_grid_progress_bar));
        this.mWidgets.put(QDBottomSheetFragment.class, new QDItemDescription(QDBottomSheetFragment.class, "QMUIBottomSheet", R.mipmap.icon_grid_botton_sheet));
        this.mWidgets.put(QDGroupListViewFragment.class, new QDItemDescription(QDGroupListViewFragment.class, "QMUIGroupListView", R.mipmap.icon_grid_group_list_view));
        this.mWidgets.put(QDTipDialogFragment.class, new QDItemDescription(QDTipDialogFragment.class, "QMUITipDialog", R.mipmap.icon_grid_tip_dialog));
        this.mWidgets.put(QDRadiusImageViewFragment.class, new QDItemDescription(QDRadiusImageViewFragment.class, "QMUIRadiusImageView", R.mipmap.icon_grid_radius_image_view));
        this.mWidgets.put(QDVerticalTextViewFragment.class, new QDItemDescription(QDVerticalTextViewFragment.class, "QMUIVerticalTextView", R.mipmap.icon_grid_vertical_text_view));
        this.mWidgets.put(QDPullRefreshFragment.class, new QDItemDescription(QDPullRefreshFragment.class, "QMUIPullRefreshLayout", R.mipmap.icon_grid_pull_refresh_layout));
        this.mWidgets.put(QDPopupFragment.class, new QDItemDescription(QDPopupFragment.class, "QMUIPopup", R.mipmap.icon_grid_popup));
        this.mWidgets.put(QDSpanTouchFixTextViewFragment.class, new QDItemDescription(QDSpanTouchFixTextViewFragment.class, "QMUISpanTouchFixTextView", R.mipmap.icon_grid_span_touch_fix_text_view));
        this.mWidgets.put(QDLinkTextViewFragment.class, new QDItemDescription(QDLinkTextViewFragment.class, "QMUILinkTextView", R.mipmap.icon_grid_link_text_view));
        this.mWidgets.put(QDQQFaceFragment.class, new QDItemDescription(QDQQFaceFragment.class, "QMUIQQFaceView", R.mipmap.icon_grid_qq_face_view));
        this.mWidgets.put(QDSpanFragment.class, new QDItemDescription(QDSpanFragment.class, "Span", R.mipmap.icon_grid_span));
        this.mWidgets.put(QDCollapsingTopBarLayoutFragment.class, new QDItemDescription(QDCollapsingTopBarLayoutFragment.class, "QMUICollapsingTopBarLayout", R.mipmap.icon_grid_collapse_top_bar));
        this.mWidgets.put(QDViewPagerFragment.class, new QDItemDescription(QDViewPagerFragment.class, "QMUIViewPager", R.mipmap.icon_grid_pager_layout_manager));
        this.mWidgets.put(QDSnapHelperFragment.class, new QDItemDescription(QDSnapHelperFragment.class, "用SnapHelper实现RecyclerView按页滚动", R.mipmap.icon_grid_pager_layout_manager));
        this.mWidgets.put(QDAnimationListViewFragment.class, new QDItemDescription(QDAnimationListViewFragment.class, "QMUIAnimationListView", R.mipmap.icon_grid_anim_list_view));
        this.mWidgets.put(QDColorHelperFragment.class, new QDItemDescription(QDColorHelperFragment.class, "QMUIColorHelper", R.mipmap.icon_grid_color_helper));
        this.mWidgets.put(QDDeviceHelperFragment.class, new QDItemDescription(QDDeviceHelperFragment.class, "QMUIDeviceHelper", R.mipmap.icon_grid_device_helper));
        this.mWidgets.put(QDDrawableHelperFragment.class, new QDItemDescription(QDDrawableHelperFragment.class, "QMUIDrawableHelper", R.mipmap.icon_grid_drawable_helper));
        this.mWidgets.put(QDStatusBarHelperFragment.class, new QDItemDescription(QDStatusBarHelperFragment.class, "QMUIStatusBarHelper", R.mipmap.icon_grid_status_bar_helper));
        this.mWidgets.put(QDViewHelperFragment.class, new QDItemDescription(QDViewHelperFragment.class, "QMUIViewHelper", R.mipmap.icon_grid_view_helper));
        this.mWidgets.put(QDViewHelperBackgroundAnimationBlinkFragment.class, new QDItemDescription(QDViewHelperBackgroundAnimationBlinkFragment.class, "做背景闪动动画", 0));
        this.mWidgets.put(QDViewHelperAnimationSlideFragment.class, new QDItemDescription(QDViewHelperAnimationSlideFragment.class, "Slide 进退场动画", 0));
        this.mWidgets.put(QDViewHelperAnimationFadeFragment.class, new QDItemDescription(QDViewHelperAnimationFadeFragment.class, "Fade 进退场动画", 0));
        this.mWidgets.put(QDViewHelperBackgroundAnimationFullFragment.class, new QDItemDescription(QDViewHelperBackgroundAnimationFullFragment.class, "做背景变化动画", 0));
        this.mWidgets.put(QDSwipeDeleteListViewFragment.class, new QDItemDescription(QDSwipeDeleteListViewFragment.class, "ListView滑动删除", 0));
        this.mWidgets.put(QDFitSystemWindowViewPagerFragment.class, new QDItemDescription(QDFitSystemWindowViewPagerFragment.class, "QDFitSystemWindowViewPagerFragment", 0));
        this.mWidgets.put(QDLoopViewPagerFragment.class, new QDItemDescription(QDLoopViewPagerFragment.class, "QDLoopViewPagerFragment", 0));
        this.mWidgets.put(QDQQFacePerformanceTestFragment.class, new QDItemDescription(QDQQFacePerformanceTestFragment.class, "性能观测", 0));
        this.mWidgets.put(QDQQFaceUsageFragment.class, new QDItemDescription(QDQQFaceUsageFragment.class, "QQ表情使用展示", 0));
        this.mWidgets.put(QDTabSegmentFixModeFragment.class, new QDItemDescription(QDTabSegmentFixModeFragment.class, "固定宽度，内容均分", 0));
        this.mWidgets.put(QDTabSegmentScrollableModeFragment.class, new QDItemDescription(QDTabSegmentScrollableModeFragment.class, "内容自适应，超过父容器则滚动", 0));

    }

    public static QDWidgetContainer getInstance() {
        return sInstance;
    }

    public QDItemDescription get(Class<? extends BaseFragment> cls) {
        return (QDItemDescription) this.mWidgets.get(cls);
    }

}
