package com.ty.imtoken.rx;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.ty.imtoken.config.Const;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ 创建者:   ty
 * @ 时间:    2018/12/15 10:05
 * @ 描述:
 */
public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> compose() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    if (!NetworkUtils.isConnected()) {
                        ToastUtils.showShort(Const.NO_NETWORK);
                    }
                }).observeOn(AndroidSchedulers.mainThread());
    }


}
