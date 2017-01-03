package pe.gob.minem.deam.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ronaldvelasquez on 2/01/17.
 */

public class ApiClient {
    private static IDenunciaService serviceInterface;

    public static IDenunciaService getServiceApiClient() {
        if (serviceInterface == null) {
            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl("http://demo0728145.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            serviceInterface = restAdapter.create(IDenunciaService.class);
        }
        return serviceInterface;
    }
}
