package pe.gob.minem.deam.rest;

import java.util.HashMap;

import pe.gob.minem.deam.rest.response.BaseResponse;
import pe.gob.minem.deam.rest.response.ListDenunciaResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ronaldvelasquez on 2/01/17.
 */

public interface IDenunciaService {
    @GET("listardenuncias")
    Call<ListDenunciaResponse> getDenuncias();

    @POST("registrar_denuncia")
    Call<BaseResponse<Object>> sendDenuncia(@Body HashMap<String, Object> map);
}
