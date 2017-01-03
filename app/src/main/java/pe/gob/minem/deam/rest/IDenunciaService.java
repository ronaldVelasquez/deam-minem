package pe.gob.minem.deam.rest;

import pe.gob.minem.deam.rest.response.ListDenunciaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ronaldvelasquez on 2/01/17.
 */

public interface IDenunciaService {
    @GET("listardenuncias")
    Call<ListDenunciaResponse> getDenuncias();
}
