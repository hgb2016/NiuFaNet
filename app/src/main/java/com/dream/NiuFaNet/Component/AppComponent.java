package com.dream.NiuFaNet.Component;

import android.content.Context;

import com.dream.NiuFaNet.Api.NFApi;
import com.dream.NiuFaNet.Module.AppModule;
import com.dream.NiuFaNet.Module.NFApiModule;

import dagger.Component;

/**
 * @author yuyh.
 * @date 2016/8/3.
 */
@Component(modules = {AppModule.class, NFApiModule.class})
public interface AppComponent {

    Context getContext();

    NFApi getNFApi();

}