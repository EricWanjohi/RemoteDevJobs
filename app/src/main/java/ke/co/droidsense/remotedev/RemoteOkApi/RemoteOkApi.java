package ke.co.droidsense.remotedev.RemoteOkApi;

import ke.co.droidsense.remotedev.model.RemoteOkResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteOkApi {
    //Create Retrofit call.
    @GET("api/")
    Call<RemoteOkResponse> getAllRemoteOkJobs();
}
