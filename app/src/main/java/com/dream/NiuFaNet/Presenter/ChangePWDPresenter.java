package com.dream.NiuFaNet.Presenter;

import android.util.Log;

import com.dream.NiuFaNet.Api.NFApi;
import com.dream.NiuFaNet.Base.RxPresenter;
import com.dream.NiuFaNet.Bean.CommonBean;
import com.dream.NiuFaNet.Contract.ChangePWDContract;
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
public class ChangePWDPresenter extends RxPresenter<ChangePWDContract.View> implements ChangePWDContract.Presenter<ChangePWDContract.View>{

    private NFApi itApi;

    private static final String TAG = "ChangePWDPresenter";

    @Inject
    public ChangePWDPresenter(NFApi bookApi) {
        this.itApi = bookApi;
    }


    @Override
    public void changePWD(String userId, String oldPassword, String newPassword) {
        Subscription rxSubscription = itApi.editPWD(userId,oldPassword,newPassword).subscribeOn(Schedulers.io())//放在异步中执行
                .observeOn(AndroidSchedulers.mainThread())//回到主线程
                .subscribe(new Observer<CommonBean>() {
                    @Override
                    public void onNext(CommonBean dataBean) {
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
