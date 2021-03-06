package com.dream.NiuFaNet.Contract;


import com.dream.NiuFaNet.Base.BaseContract;
import com.dream.NiuFaNet.Bean.CommonBean;
import com.dream.NiuFaNet.Bean.VoiceRvBean;

/**
 * @author lfh.
 * @date 2018/8/6.
 */
public interface VoiceContentContract {

    interface View extends BaseContract.BaseView {

        void showVoiceContentData(VoiceRvBean dataBean);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void voicePrompt();
    }
}
