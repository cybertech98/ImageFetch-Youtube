package com.example.imagefetch_youtube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<DataAdapter> dataAdapters;
    ImageLoader imageLoader;

    public RecyclerViewAdapter(List<DataAdapter> getDataAdapter, Context context){

        super();
        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        DataAdapter dataAdapterOBJ =  dataAdapters.get(position);

        imageLoader = ImageAdapter.getInstance(context).getImageLoader();

        imageLoader.get(dataAdapterOBJ.getImageUrl(),
                ImageLoader.getImageListener(
                        Viewholder.VollyImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );

        Viewholder.VollyImageView.setImageUrl(dataAdapterOBJ.getImageUrl(), imageLoader);

        Viewholder.ImageTitleTextView.setText(dataAdapterOBJ.getImageTitle());
        Viewholder.ImagePriceTextView.setText(dataAdapterOBJ.getImagePrice());
        Viewholder.ImageDescTextView.setText(dataAdapterOBJ.getImageDesc());
    }

    @Override
    public int getItemCount() {

        return dataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView ImageTitleTextView;
        public TextView ImagePriceTextView;
        public TextView ImageDescTextView;
        public NetworkImageView VollyImageView ;

        public ViewHolder(View itemView) {

            super(itemView);

            ImageTitleTextView = (TextView) itemView.findViewById(R.id.Category) ;
            ImagePriceTextView = (TextView) itemView.findViewById(R.id.imagePrice) ;
            ImageDescTextView = (TextView) itemView.findViewById(R.id.imageDesc) ;

            VollyImageView = (NetworkImageView) itemView.findViewById(R.id.VolleyImageView) ;

        }
    }
}