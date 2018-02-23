package com.cj.qmuiapplication.fragment.components;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：ProgressBar 的使用示例
 */

public class QDProgressBarFragment extends BaseFragment {

    protected static final int STOP = 0x10000;
    protected static final int NEXT = 0x10001;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.rectProgressBar)
    QMUIProgressBar mRectProgressBar;
    @BindView(R.id.circleProgressBar)
    QMUIProgressBar mCircleProgressBar;
    @BindView(R.id.startBtn)
    Button mStartBtn;
    @BindView(R.id.backBtn)
    Button mBackBtn;
    int count;

    private QDItemDescription mQDItemDescription;
    private ProgressHandler myHandler = new ProgressHandler();

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_progressbar, null);
        ButterKnife.bind(this, root);

        mQDItemDescription = QDDataManager.getInstance().getDescription(this.getClass());
        initTopBar();

        mRectProgressBar.setQMUIProgressBarTextGenerator(new QMUIProgressBar.QMUIProgressBarTextGenerator() {
            @Override
            public String generateText(QMUIProgressBar progressBar, int value, int maxValue) {
                return value + "/" + maxValue;
            }
        });

        mCircleProgressBar.setQMUIProgressBarTextGenerator(new QMUIProgressBar.QMUIProgressBarTextGenerator() {
            @Override
            public String generateText(QMUIProgressBar progressBar, int value, int maxValue) {
                return 100 * value / maxValue + "%";
            }
        });

        myHandler.setProgressBar(mRectProgressBar, mCircleProgressBar);

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= 20; i++) {
                            try {
                                count = (i + 1) * 5;
                                if (i == 20) {
                                    Message msg = new Message();
                                    msg.what = STOP;
                                    myHandler.sendMessage(msg);
                                } else {
                                    Message msg = new Message();
                                    msg.what = NEXT;
                                    msg.arg1 = count;
                                    myHandler.sendMessage(msg);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRectProgressBar.setProgress(0);
                mCircleProgressBar.setProgress(0);
            }
        });
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

    private static class ProgressHandler extends Handler {
        private WeakReference<QMUIProgressBar> weakRectProgressBar;
        private WeakReference<QMUIProgressBar> weakCircleProgressBar;

        void setProgressBar(QMUIProgressBar rectProgressBar, QMUIProgressBar circleProgressBar) {
            weakRectProgressBar = new WeakReference<>(rectProgressBar);
            weakCircleProgressBar = new WeakReference<>(circleProgressBar);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case STOP:
                    break;
                case NEXT:
                    if (!Thread.currentThread().isInterrupted()) {
                        if (weakRectProgressBar.get() != null && weakCircleProgressBar.get() != null) {
                            weakRectProgressBar.get().setProgress(msg.arg1);
                            weakCircleProgressBar.get().setProgress(msg.arg1);
                        }
                    }
            }

        }
    }

}
