package com.dream.NiuFaNet.Presenter;

import android.util.Log;

import com.dream.NiuFaNet.Api.NFApi;
import com.dream.NiuFaNet.Base.RxPresenter;
import com.dream.NiuFaNet.Bean.CommonBean;
import com.dream.NiuFaNet.Bean.LoginBean;
import com.dream.NiuFaNet.Contract.BindPhoneContract;
import com.dream.NiuFaNet.Contract.CodeContract;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author lfh.
 * @date 2016/8/6.
 */
public class BindPhonePresenter extends RxPresenter<BindPhoneContract.View> implements BindPhoneContract.Presenter<BindPhoneContract.View>{

    private NFApi itApi;

    private static final String TAG = "BindPhonePresenter";

    @Inject
    public BindPhonePresenter(NFApi bookApi) {
        this.itApi = bookApi;
    }


    @Override
    public void bindPhone(String mobilePhone, String captcha, String userId) {
        Subscription rxSubscription = itApi.bindPhone(mobilePhone,captcha,userId).subscribeOn(Schedulers.io())//放在异步中执行
                .observeOn(AndroidSchedulers.mainThread())//回到主线程
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onNext(LoginBean dataBean) {
                        if (dataBean != null && mView != null) {
                            mView.showData(dataBean);
                        }
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e(TAG, "onError: " + e);
                        mView.showError();
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
