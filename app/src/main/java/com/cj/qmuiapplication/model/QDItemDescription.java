package com.cj.qmuiapplication.model;

import com.cj.qmuiapplication.base.BaseFragment;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/1
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：
 */

public class QDItemDescription {
    private int mIconRes;
    private Class<? extends BaseFragment> mKitDemoClass;
    private String mKitDetailDescription;
    private String mKitName;

    public QDItemDescription(Class<? extends BaseFragment> cls, String str) {
        this(cls, str, 0);
    }

    public QDItemDescription(Class<? extends BaseFragment> cls, String str, int i) {
        this.mKitDemoClass = cls;
        this.mKitName = str;
        this.mIconRes = i;
    }

    public QDItemDescription(Class<? extends BaseFragment> cls, String str, String str2, int i) {
        this.mKitDemoClass = cls;
        this.mKitName = str;
        this.mKitDetailDescription = str2;
        this.mIconRes = i;
    }

    public Class<? extends BaseFragment> getDemoClass() {
        return this.mKitDemoClass;
    }

    public int getIconRes() {
        return this.mIconRes;
    }

    public String getItemDetailDescription() {
        return this.mKitDetailDescription;
    }

    public String getName() {
        return this.mKitName;
    }

    public void setItemDetailDescription(String str) {
        this.mKitDetailDescription = str;
    }

}
