import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlaskaApi {

    @POST("/bear")
    Call<Integer> create(@Body Bear bear);

    @GET("/bear")
    Call<List<Bear>> getAllBear();

    @GET("/bear/{id}")
    Call<Bear> getBear(@Path("id") int id);

    @PUT("/bear")
    Call<Bear> update(@Body Bear bear);

    @DELETE("/bear")
    Call<String> removeAll();

    @DELETE("/bear/{id}")
    Call<String> remove(@Path("id") int id);
}