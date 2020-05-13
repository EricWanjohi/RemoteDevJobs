package ke.co.droidsense.remotedev.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.dmoral.toasty.Toasty;
import ke.co.droidsense.remotedev.R;
import ke.co.droidsense.remotedev.model.RemoteOkResponse;

public class RemoteOkAdapter extends RecyclerView.Adapter<RemoteOkAdapter.ViewHolder> {
    //Member Variables...
    private List<RemoteOkResponse> remoteOkResponses;
    private Context context;

    //Constructor...
    public RemoteOkAdapter(List<RemoteOkResponse> remoteOkResponses, Context context) {
        this.remoteOkResponses = remoteOkResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create View item...
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.remote_job_item_layout, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Create Object holder...
        RemoteOkResponse remoteOkResponse = remoteOkResponses.get( position );

        //Bind data
        holder.position.setText( remoteOkResponse.getPosition() );

        //Set item tag
        holder.itemView.setTag( remoteOkResponse );

    }

    @Override
    public int getItemCount() {
        return remoteOkResponses.size();
    }

    //Create ViewHolder...
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Member Variables...
        private TextView position;

        //Constructor...
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            //Initializations...
            position = itemView.findViewById( R.id.remote_job_position );

            //Set Click Listener.
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View view) {
            //Handle click events...
            RemoteOkResponse remoteOkResponse = (RemoteOkResponse) view.getTag();

            Toasty.success( context, remoteOkResponse.getCompany(), Toasty.LENGTH_SHORT ).show();
        }
    }
}
