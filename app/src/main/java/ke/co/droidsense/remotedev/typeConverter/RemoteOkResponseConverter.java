package ke.co.droidsense.remotedev.typeConverter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import ke.co.droidsense.remotedev.model.RemoteOkResponse;


public class RemoteOkResponseConverter {
    //Response list converter...
    @TypeConverter
    public static List<RemoteOkResponse> fromRemoteOkResponseString(String value) {
        Type listType = new TypeToken<RemoteOkResponse>() {
        }.getType();
        return new Gson().fromJson( value, listType );
    }

    @TypeConverter
    public static String fromRemoteOkResponseList(List<RemoteOkResponse> list) {
        Gson gson = new Gson();
        String json = gson.toJson( list );
        return json;
    }
}
