package ke.co.droidsense.remotedev.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import ke.co.droidsense.remotedev.dao.RemoteOkDao;
import ke.co.droidsense.remotedev.model.RemoteOkResponse;
import ke.co.droidsense.remotedev.typeConverter.RemoteOkResponseConverter;
import ke.co.droidsense.remotedev.typeConverter.RemoteOkResponseTagsListConverter;

@TypeConverters({RemoteOkResponseConverter.class, RemoteOkResponseTagsListConverter.class})
@Database(entities = {RemoteOkResponse.class}, version = 1, exportSchema = false)
public abstract class RemoteOkDb extends RoomDatabase {

    //Member Variables...
    private static RemoteOkDb INSTANCE;
    private static String Database = "RemoteOkDb";

    //Get Database instance...
    public static RemoteOkDb getRemoteOkDbInstance(Context context) {
        //Check if instance is null...
        if (INSTANCE == null) {
            //Create new Instance...
            INSTANCE = Room.databaseBuilder( context, RemoteOkDb.class, Database )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    //Create RemoteOkDao...
    public abstract RemoteOkDao getRemoteOkDao();
}
