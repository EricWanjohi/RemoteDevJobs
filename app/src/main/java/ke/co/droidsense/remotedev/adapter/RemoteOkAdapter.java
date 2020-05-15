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
    private static final int MAX_WIDTH = 40;
    private static final int MAX_HEIGHT = 40;
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
        holder.company_name.setText( remoteOkResponse.getCompany() );
        holder.position.setText( remoteOkResponse.getPosition() );
        holder.date_posted.setText( remoteOkResponse.getDate() );

        //Bind Logo image using Picasso...
//        Picasso.get().load( remoteOkResponse.getLogo() )
//                .resize( MAX_WIDTH, MAX_HEIGHT )
//                .centerCrop()
//                .into( holder.company_logo );

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
        private TextView company_name, position, date_posted;
//        private ImageView company_logo;

        //Constructor...
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            //Initializations...
            company_name = itemView.findViewById( R.id.remote_job_company );
            position = itemView.findViewById( R.id.remote_job_position );
            date_posted = itemView.findViewById( R.id.remote_job_date );
//            company_logo = itemView.findViewById( R.id.company_logo );

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
