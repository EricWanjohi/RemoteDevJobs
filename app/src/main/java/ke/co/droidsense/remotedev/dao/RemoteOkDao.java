package ke.co.droidsense.remotedev.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ke.co.droidsense.remotedev.model.RemoteOkResponse;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface RemoteOkDao {

    //Query All RemoteOkResponse objects.
    @Query("SELECT * FROM RemoteOk ORDER BY (id) ASC ")
    LiveData<List<RemoteOkResponse>> getAllRemoteOkJobs();

    //Update Jobs...
    @Update
    void upDateRemoteOk(RemoteOkResponse remoteOkResponse);

    //Insert new Jobs...
    @Insert(onConflict = REPLACE)
    void insertRemoteOk(RemoteOkResponse remoteOkResponse);

    //Delete Jobs...
    @Delete
    void deleteRemoteOk(RemoteOkResponse remoteOkResponse);
}
