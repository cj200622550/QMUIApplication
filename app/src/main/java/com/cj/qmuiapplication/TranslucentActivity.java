package com.cj.qmuiapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：沉浸式状态栏的调用示例。
 */

public class TranslucentActivity extends AppCompatActivity {

    private final static String ARG_CHANGE_TRANSLUCENT = "ARG_CHANGE_TRANSLUCENT";
    private final static String ARG_STATUSBAR_MODE = "ARG_STATUSBAR_MODE";
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

    public static Intent createActivity(Context context, boolean isTranslucent) {
        Intent intent = new Intent(context, TranslucentActivity.class);
        intent.putExtra(ARG_CHANGE_TRANSLUCENT, isTranslucent);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            boolean isTranslucent = intent.getBooleanExtra(ARG_CHANGE_TRANSLUCENT, true);
            if (isTranslucent) {
                QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
            }
        }

        View root = LayoutInflater.from(this).inflate(R.layout.activity_translucent, null);
        ButterKnife.bind(this, root);
        initTopBar();
        setContentView(root);

    }

    private void initTopBar() {
        mTopBar.setBackgroundColor(ContextCompat.getColor(this, R.color.app_color_theme_4));
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });

        mTopBar.setTitle("沉浸式状态栏示例");
    }
}
