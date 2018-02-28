package com.postapp.rxjava;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.postapp.rxjava.Contant.DELETED;
import static com.postapp.rxjava.Contant.FOLLOW_LOGIN;
import static com.postapp.rxjava.Contant.LOAD_FAILED;
import static com.postapp.rxjava.Contant.NOT_FOLLOW;
import static com.postapp.rxjava.Contant.NOT_FOLLOW_FANS;
import static com.postapp.rxjava.Contant.NOT_LOVER;
import static com.postapp.rxjava.Contant.NOT_MESSAGE;
import static com.postapp.rxjava.Contant.NOT_ODER;
import static com.postapp.rxjava.Contant.NOT_PUBLISH;
import static com.postapp.rxjava.Contant.NOT_SEARCH;
import static com.postapp.rxjava.Contant.NOT_WORDS;


/**
 * Created by Administrator on 2017/1/19.
 * 三种状态的LinearLayout，用于切换当前的页面显示
 * ERROR,CONTENT,LOADING
 */

public class MyProgressLayout extends LinearLayout {
    private LayoutParams layoutParams;
    private LayoutInflater layoutInflater;
    private View loadingView, errorView;
    private LinearLayout ProgreeLayoutView;
    private TextView btn_error;
    private TextView tv_error;
    private ImageView img_error;
    private TextView erro_back;
    Animation animation;

    public MyProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        showLoadingView();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (btn_error != null) {
            btn_error.setOnClickListener(null);
        }
    }

    public void showLoading() {
        this.showLoadingView();
    }

    /**
     * 显示加载中布局
     */
    private void showLoadingView() {
        if (ProgreeLayoutView == null) {
            ProgreeLayoutView = (LinearLayout) layoutInflater.inflate(R.layout.layout_my_progress_view, null);
            btn_error = (TextView) ProgreeLayoutView.findViewById(R.id.btn_try);
            tv_error = (TextView) ProgreeLayoutView.findViewById(R.id.erro_text);
            img_error = (ImageView) ProgreeLayoutView.findViewById(R.id.erro_img);
            loadingView = ProgreeLayoutView.findViewById(R.id.loading_view);
            errorView = ProgreeLayoutView.findViewById(R.id.error_view);
            erro_back = (TextView) ProgreeLayoutView.findViewById(R.id.erro_back);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(ProgreeLayoutView, layoutParams);
        } else {
            ProgreeLayoutView.setVisibility(VISIBLE);
        }
        erro_back.setVisibility(GONE);
        loadingView.setVisibility(VISIBLE);
        errorView.setVisibility(GONE);

    }


    private void hideLoadingView() {
        if (loadingView != null && loadingView.getVisibility() != GONE) {
            animation = new AlphaAnimation(1f, 0f);
            animation.setDuration(400);
            loadingView.startAnimation(animation);
            loadingView.setVisibility(GONE);
        }
    }

    public void showErrorView(int errorType, String butErrorStr, String errorStr, OnClickListener click) {
        if (ProgreeLayoutView == null) {
            ProgreeLayoutView = (LinearLayout) layoutInflater.inflate(R.layout.layout_my_progress_view, null);
            btn_error = (TextView) ProgreeLayoutView.findViewById(R.id.btn_try);
            tv_error = (TextView) ProgreeLayoutView.findViewById(R.id.erro_text);
            img_error = (ImageView) ProgreeLayoutView.findViewById(R.id.erro_img);
            loadingView = ProgreeLayoutView.findViewById(R.id.loading_view);
            errorView = ProgreeLayoutView.findViewById(R.id.error_view);
            erro_back = (TextView) ProgreeLayoutView.findViewById(R.id.erro_back);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(ProgreeLayoutView, layoutParams);
        } else {
            ProgreeLayoutView.setVisibility(VISIBLE);
        }
        hideLoadingView();
        errorView.setVisibility(VISIBLE);
        erro_back.setVisibility(GONE);
        if (StringUtils.isEmpty(butErrorStr)) {
            btn_error.setVisibility(GONE);
        } else {
            btn_error.setVisibility(VISIBLE);
            btn_error.setText(butErrorStr);
        }
        this.btn_error.setOnClickListener(click);
        tv_error.setText(errorStr);
        //这里我用了同一个图片 您可以根据不痛的状态显示不同的图片
        switch (errorType) {

            case DELETED:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case FOLLOW_LOGIN:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case LOAD_FAILED:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_FOLLOW_FANS:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_FOLLOW:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_LOVER:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_MESSAGE:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_ODER:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_PUBLISH:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_SEARCH:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_WORDS:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;

        }
    }

    /**
     * 全屏显示错误
     *
     * @param errorType   错误类型
     * @param butErrorStr 错误按钮字符串
     * @param errorStr    错误字符串
     * @param click
     */
    public void showErrorView(boolean isHasBack, int errorType, String butErrorStr, String errorStr, OnClickListener click) {
        if (ProgreeLayoutView == null) {
            ProgreeLayoutView = (LinearLayout) layoutInflater.inflate(R.layout.layout_my_progress_view, null);
            btn_error = (TextView) ProgreeLayoutView.findViewById(R.id.btn_try);
            tv_error = (TextView) ProgreeLayoutView.findViewById(R.id.erro_text);
            img_error = (ImageView) ProgreeLayoutView.findViewById(R.id.erro_img);
            loadingView = ProgreeLayoutView.findViewById(R.id.loading_view);
            errorView = ProgreeLayoutView.findViewById(R.id.error_view);
            erro_back = (TextView) ProgreeLayoutView.findViewById(R.id.erro_back);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(ProgreeLayoutView, layoutParams);
        } else {
            ProgreeLayoutView.setVisibility(VISIBLE);
        }
        hideLoadingView();
        errorView.setVisibility(VISIBLE);

        if (isHasBack) {
            erro_back.setVisibility(VISIBLE);
        } else {
            erro_back.setVisibility(GONE);
        }

        if (StringUtils.isEmpty(butErrorStr)) {
            btn_error.setVisibility(GONE);
        } else {
            btn_error.setVisibility(VISIBLE);
            btn_error.setText(butErrorStr);
        }
        this.btn_error.setOnClickListener(click);
        this.erro_back.setOnClickListener(click);
        tv_error.setText(errorStr);

        switch (errorType) {

            case DELETED:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case FOLLOW_LOGIN:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case LOAD_FAILED:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_FOLLOW_FANS:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_FOLLOW:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_LOVER:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_MESSAGE:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_ODER:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_PUBLISH:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_SEARCH:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;
            case NOT_WORDS:
                img_error.setBackgroundResource(R.mipmap.deleted_logo);
                break;

        }
    }

    private void hideErrorView() {
        if (loadingView != null && loadingView.getVisibility() != GONE) {
            errorView.setVisibility(GONE);
        }
    }

}
