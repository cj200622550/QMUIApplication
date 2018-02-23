package com.cj.qmuiapplication.fragment.home;

import android.content.Context;

import com.cj.qmuiapplication.manager.QDDataManager;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：主界面，关于 QMUI 控件 部分的展示。
 */

public class HomeComponentsController extends HomeController {

    public HomeComponentsController(Context context) {
        super(context);
    }

    @Override
    protected String getTitle() {
        return "控件实例";
    }

    @Override
    protected ItemAdapter getItemAdapter() {
        return new ItemAdapter(getContext(), QDDataManager.getInstance().getComponentsDescriptions());
    }
}
