package com.postapp.rxjava;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by POST on 2017/11/13.
 */

public class Contant {

    //页面过度页面的错误code
    public static final int DELETED = 1; //已删除
    public static final int FOLLOW_LOGIN = 2; //未登录
    public static final int LOAD_FAILED = 3; //加载失败 请求失败
    public static final int NOT_FOLLOW_FANS = 4; //没有追踪或者粉丝
    public static final int NOT_FOLLOW = 5; //没有追踪
    public static final int NOT_LOVER = 6; //没有赞
    public static final int NOT_MESSAGE = 7; //没有通知
    public static final int NOT_ODER = 8; //没有订单
    public static final int NOT_PUBLISH = 9; //没有发布
    public static final int NOT_SEARCH = 10; //搜索无结果
    public static final int NOT_WORDS = 11; //无作品


    public static void showContent(View view) {
        if (view != null && view.getVisibility() != View.GONE) {
            Animation animation = new AlphaAnimation(1f, 0f);
            animation.setDuration(400);
            view.startAnimation(animation);
            view.setVisibility(View.GONE);
        }
    }

    public static void showReload(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

}
