package com.retrofit.api;


import com.retrofit.base.BaseRespon;
import com.retrofit.model.request.QueryUser;
import com.retrofit.model.response.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIServer {
    @POST("/users/login")
    Observable<BaseRespon<User>> login(@Body QueryUser queryUser);
}
