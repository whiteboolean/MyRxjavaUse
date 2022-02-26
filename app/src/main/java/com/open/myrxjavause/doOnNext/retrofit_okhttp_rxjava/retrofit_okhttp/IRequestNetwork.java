package com.open.myrxjavause.doOnNext.retrofit_okhttp_rxjava.retrofit_okhttp;

import io.reactivex.Observable;
import retrofit2.http.Body;

// 请求接口 API
public interface IRequestNetwork {

    public Observable<RegisterResponse> registerAction(@Body RegisterRequest registerRequest);

    public Observable<LoginResponse> loginAction(@Body LoginRequest loginRequest);

}
