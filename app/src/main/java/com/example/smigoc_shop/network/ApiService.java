package com.example.smigoc_shop.network;



import com.example.smigoc_shop.models.LoginRequest;
import com.example.smigoc_shop.models.LoginResopnse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

  @POST("api/login")
    Observable<LoginResopnse> validateLogin(@Header("Token") String token, @Body LoginRequest login);
//
//    @POST("api/signup")
//    Observable<SignupResponse> validatesignup(@Header("Token") String token, @Body NewUser signup);
//
//    @POST("api/requestOrder")
//    Observable<BaseResponse> placeMilkOrder(@Header("Token") String token, @Body Orderreq orderreq);
//
//    @Headers({"Accept: application/json"})
//    @POST("api/getMilkSale")
//    Observable<ActiveSale> getActiveSale(@Header("Token") String token);
//
//    @Headers({"Accept: application/json"})
//    @POST("api/updateOrderRequest")
//    Observable<BaseResponse> updateOrderRequestStatus(@Header("Token") String token, @Body UpdateOrderRequest updateOrderRequest);
//
//    @POST("api/saveMilkSale")
//    Observable<BaseResponse> newmilksale(@Header("Token")String token, @Body HashMap<String, String> milksalepojo);
/////Dream Home Api
//
//    @POST("api/loginHome")
//    Observable<com.smigoc.dreamhome.model.LoginResp> validatelogin (@Header("Token") String token, @Body com.smigoc.dreamhome.model.Login login);
//
//    @Headers({"Accept: application/json"})
//    @POST("api/getClients")
//    Observable<FetchclientResponse> getClients(@Header("Token") String token);
//
//    @POST("api/saveClient")
//    Observable<com.smigoc.dreamhome.model.BaseResponse> savenewclient (@Header("Token") String token, @Body com.smigoc.dreamhome.model.NewClient newclient);
//
//    @POST("api/savePurchase")
//    Observable<com.smigoc.dreamhome.model.BaseResponse> savepurchase (@Header("Token") String token, @Body com.smigoc.dreamhome.model.NewExpenditure purchase);
//
//    @Headers({"Accept: application/json"})
//    @POST("api/getUserHomes")
//    Observable<FetchPaymentresponse> getclientpayment(@Header("Token") String token);
//
//    @POST("api/getClientInfo")
//    Observable<Clients> getclientinfo(@Header("Token") String token, @Body HashMap<String,String> clientid);
//
//    @POST("api/getPaymentInfo")
//    Observable<DetailedInfo> getpaymentinfo (@Header("Token") String token, @Body HashMap<String,String> paymentid);
//
//    @POST("api/addPayment")
//    Observable<com.smigoc.dreamhome.model.BaseResponse> addpayment (@Header("Token") String token, @Body AddPayment addPayment);




}
