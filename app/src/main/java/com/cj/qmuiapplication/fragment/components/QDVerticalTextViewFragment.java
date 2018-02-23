package com.cj.qmuiapplication.fragment.components;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.cj.qmuiapplication.R;
import com.cj.qmuiapplication.base.BaseFragment;
import com.cj.qmuiapplication.manager.QDDataManager;
import com.cj.qmuiapplication.model.QDItemDescription;
import com.qmuiteam.qmui.util.QMUIKeyboardHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUIVerticalTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 陈骏
 * 创建时间： 2018/2/2
 * 博客： https://www.jianshu.com/u/c5ada9939f6d
 * Q Q： 200622550
 * 作用：VerticalTextView 例子
 */

public class QDVerticalTextViewFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.verticalTextView)
    QMUIVerticalTextView mVerticalTextView;
    @BindView(R.id.verticalTextView_editText)
    EditText mEditText;


    @Override
    protected View onCreateView() {
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_verticaltextview, null);
        ButterKnife.bind(this, rootView);

        initTopBar();
        initVerticalTextView();

        return rootView;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        QDItemDescription qdItemDescription = QDDataManager.getInstance().getDescription(this.getClass());
        mTopBar.setTitle(qdItemDescription.getName());
    }

    private void initVerticalTextView() {
        final String defaultText = String.format("%s 实现对文字的垂直排版。并且对非 CJK (中文、日文、韩文)字符做90度旋转排版。可以在下方的输入框中输入文字，体验不同文字垂直排版的效果。",
                QMUIVerticalTextView.class.getSimpleName());
        mVerticalTextView.setText(defaultText);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mVerticalTextView.setText(QMUILangHelper.isNullOrEmpty(s) ? defaultText : s);
            }
        });
    }

    @Override
    protected void popBackStack() {
        super.popBackStack();
        QMUIKeyboardHelper.hideKeyboard(mEditText);
    }
}
