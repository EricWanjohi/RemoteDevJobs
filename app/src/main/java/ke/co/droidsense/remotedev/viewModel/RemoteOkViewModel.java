package ke.co.droidsense.remotedev.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ke.co.droidsense.remotedev.model.RemoteOkResponse;
import ke.co.droidsense.remotedev.repository.RemoteOkRepository;

public class RemoteOkViewModel extends AndroidViewModel {
    //Member Variables...
    private RemoteOkRepository remoteOkRepository;
    private LiveData<List<RemoteOkResponse>> remoteOkResponseLiveData;
    private Application application;

    //Create Constructor...
    public RemoteOkViewModel(Application application) {
        super( application );
        this.application = application;

        //Initialize ViewModel.
        initializeViewModel();
    }

    //Init ViewModel...
    private void initializeViewModel() {
        //Check if liveData is null...
        if (remoteOkResponseLiveData == null) {
            //Get liveData Instance from repository...
            remoteOkRepository = RemoteOkRepository.getRemoteOkRepository( application );
            remoteOkResponseLiveData = remoteOkRepository.getRemoteJobs();
        }
    }

    //LiveData object getter
    public LiveData<List<RemoteOkResponse>> getRemoteOkResponseLiveData() {
        return remoteOkResponseLiveData;
    }
}
