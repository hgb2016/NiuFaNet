package com.dream.NiuFaNet.Presenter;

import android.util.Log;

import com.dream.NiuFaNet.Api.NFApi;
import com.dream.NiuFaNet.Base.RxPresenter;
import com.dream.NiuFaNet.Bean.CommonBean;
import com.dream.NiuFaNet.Bean.RegisterBean;
import com.dream.NiuFaNet.Contract.CodeContract;
import com.dream.NiuFaNet.Contract.RegisterContract;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author lfh.
 * @date 2016/8/6.
 */
public class CodePresenter extends RxPresenter<CodeContract.View> implements CodeContract.Presenter<CodeContract.View>{

    private NFApi itApi;

    private static final String TAG = "CodePresenter";

    @Inject
    public CodePresenter(NFApi bookApi) {
        this.itApi = bookApi;
    }


    @Override
    public void getYzCode(String mobilePhone,String type) {
        Subscription rxSubscription = itApi.getYzCode(mobilePhone,type).subscribeOn(Schedulers.io())//放在异步中执行
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
