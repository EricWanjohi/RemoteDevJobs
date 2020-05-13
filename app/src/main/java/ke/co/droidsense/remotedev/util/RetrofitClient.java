package ke.co.droidsense.remotedev.util;

import ke.co.droidsense.remotedev.constant.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Member Variables...
    private static Retrofit retrofit;
    private static String Base_Url = Constants.BASE_URL;

    public static Retrofit getRetrofit() {
        //Check if retrofit instance is null...
        if (retrofit == null) {
            //Create new Instance...
            retrofit = new Retrofit.Builder()
                    .baseUrl( Base_Url )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
        }
        return retrofit;
    }
}
