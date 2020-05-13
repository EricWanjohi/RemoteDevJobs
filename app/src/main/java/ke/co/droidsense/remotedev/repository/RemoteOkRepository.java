package ke.co.droidsense.remotedev.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import ke.co.droidsense.remotedev.RemoteOkApi.RemoteOkApi;
import ke.co.droidsense.remotedev.dao.RemoteOkDao;
import ke.co.droidsense.remotedev.database.RemoteOkDb;
import ke.co.droidsense.remotedev.model.RemoteOkResponse;
import ke.co.droidsense.remotedev.util.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class RemoteOkRepository {
    //Member Variables...
    private static RemoteOkRepository remoteOkRepository;
    private RemoteOkDb remoteOkDb;
    private RemoteOkDao remoteOkDao;
    private RemoteOkApi remoteOkApi;
    private LiveData<List<RemoteOkResponse>> remoteOkResponseLiveData;

    //RemoteOk Repository Constructor...
    private RemoteOkRepository(Context context) {
        //Initialization...
        remoteOkDb = RemoteOkDb.getRemoteOkDbInstance( context );
        remoteOkDao = remoteOkDb.getRemoteOkDao();
        remoteOkApi = RetrofitClient.getRetrofit().create( RemoteOkApi.class );
        remoteOkResponseLiveData = remoteOkDao.getAllRemoteOkJobs();
    }

    //Get RemoteOkRepository instance...
    public static RemoteOkRepository getRemoteOkRepository(Context context) {
        //Check if instance is null...
        if (remoteOkRepository == null) {
            //Create new Instance...
            remoteOkRepository = new RemoteOkRepository( context );
        }
        return remoteOkRepository;
    }

    //Get Remote Jobs.
    public MutableLiveData<RemoteOkResponse> getRemoteJobs() {
        //Create data holder object...
        MutableLiveData<RemoteOkResponse> okResponseMutableLiveData = new MutableLiveData<>();

        //Fetch data...
        remoteOkApi.getAllRemoteOkJobs().enqueue( new Callback<RemoteOkResponse>() {
            @Override
            public void onResponse(@NotNull Call<RemoteOkResponse> call, @NotNull Response<RemoteOkResponse> response) {
                //Check if response is successful.
                if (response.isSuccessful()) {
                    //Set data fetched to object...
                    okResponseMutableLiveData.postValue( response.body() );
                }
            }

            @Override
            public void onFailure(@NotNull Call<RemoteOkResponse> call, @NotNull Throwable throwable) {
                //Handle error response.
                Timber.e( throwable.getMessage() );
            }
        } );

        return okResponseMutableLiveData;
    }

    /*____________________________   ______________________________**/
}
