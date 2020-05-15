package ke.co.droidsense.remotedev.typeConverter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class RemoteOkResponseTagsListConverter {
    //Response list converter...
    @TypeConverter
    public static List<String> fromString(String value) {
        Type listType = new TypeToken<String>() {
        }.getType();
        return new Gson().fromJson( value, listType );
    }

    @TypeConverter
    public static String fromList(List<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson( list );
        return json;
    }
}
