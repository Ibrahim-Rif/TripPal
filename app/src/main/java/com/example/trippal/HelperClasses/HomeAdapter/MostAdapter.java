package com.example.trippal.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trippal.R;

import java.util.ArrayList;

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MostViewHolder> {

    ArrayList<MostHelperClass> mostView;


    public MostAdapter(ArrayList<MostHelperClass> mostView) {
        this.mostView = mostView;
    }

    @NonNull
    @Override
    public MostAdapter.MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.most_viewed_card_design,parent,false);
        MostAdapter.MostViewHolder mostViewHolder = new MostAdapter.MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {


        MostHelperClass mostHelperClass = mostView.get( position );

        holder.image.setImageResource(mostHelperClass.getImage());
        holder.title.setText(mostHelperClass.getTitle());
        holder.desc.setText(mostHelperClass.getDescription());



    }

    @Override
    public int getItemCount() {
        return mostView.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;


        public  MostViewHolder(@NonNull View itemView) {
            super( itemView );

            //hooks
            image = itemView.findViewById( R.id.mv_imag);
            title = itemView.findViewById( R.id.mv_title );
            desc = itemView.findViewById( R.id.mv_desc );
        }
    }
}