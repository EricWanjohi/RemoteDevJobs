package ke.co.droidsense.remotedev.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ke.co.droidsense.remotedev.R;
import ke.co.droidsense.remotedev.adapter.RemoteOkAdapter;
import ke.co.droidsense.remotedev.model.RemoteOkResponse;
import ke.co.droidsense.remotedev.viewModel.RemoteOkViewModel;

public class MainActivity extends AppCompatActivity {
    //Member Variables...
    private RemoteOkAdapter remoteOkAdapter;
    private RemoteOkViewModel remoteOkViewModel;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private List<RemoteOkResponse> remoteOkResponseList;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Initializations...
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        //ProgressDialog...
        progressDialog = new ProgressDialog( this );
        progressDialog.setMessage( "Fetching jobs..." );
        progressDialog.show();

        //Init ArrayList.
        remoteOkResponseList = new ArrayList<>();

        //RecyclerView...
        setUpRecyclerView();

        //ViewModel...
        setUpViewModel();
    }

    //Set up ViewModel...
    private void setUpViewModel() {
        //Get ViewModel...
        remoteOkViewModel = ViewModelProviders.of( this ).get( RemoteOkViewModel.class );
        remoteOkViewModel.getRemoteOkResponseLiveData().observe( this, new Observer<List<RemoteOkResponse>>() {
            @Override
            public void onChanged(List<RemoteOkResponse> remoteOkResponses) {
                //Handle data response...
                //Clear previous data...
//                remoteOkResponseList.clear();
                //Add new List...
                remoteOkResponseList.addAll( remoteOkResponses );
                //Notify adapter of data change...
                remoteOkAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        } );
    }

    //Set up RecyclerView...
    private void setUpRecyclerView() {
        //Check if adapter is null...
        if (remoteOkAdapter == null) {
            //Get instance...
            recyclerView = findViewById( R.id.recyclerView );
            remoteOkAdapter = new RemoteOkAdapter( remoteOkResponseList, this );
            linearLayoutManager = new LinearLayoutManager( this );

            //Set RecyclerView...
            recyclerView.setLayoutManager( linearLayoutManager );
            recyclerView.setAdapter( remoteOkAdapter );
            recyclerView.setHasFixedSize( true );
        } else {
            remoteOkAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Get item id...
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}
