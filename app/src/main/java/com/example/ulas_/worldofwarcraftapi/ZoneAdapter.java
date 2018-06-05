package com.example.ulas_.worldofwarcraftapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ZoneAdapter extends RecyclerView.Adapter<ZoneAdapter.WordViewHolder>{



    class WordViewHolder extends RecyclerView.ViewHolder {
        TextView wordItemView;
        Button search_button;
        Button edit_button;


        public WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);

            search_button = (Button)itemView.findViewById(R.id.search_button);

        }
    }//viewholder

    private final LayoutInflater mInflater;
    Context mContext;
    ArrayList<Zone> lZones;
    public ZoneAdapter(Context context, ArrayList<Zone> listofZones) {
        lZones=listofZones;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.items, parent, false);
        return new WordViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(WordViewHolder holder, final int position) {
        final Zone d=lZones.get(position);

        final WordViewHolder h = holder;
        int logoIndex = d.getExpansionLogo();
        switch (logoIndex){
            case 0:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.vanilla64, 0, 0, 0);
                break;
            case 1:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.burning64, 0, 0, 0);
                break;
            case 2:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.lich64, 0, 0, 0);
                break;
            case 3:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.catacly64, 0, 0, 0);
                break;
            case 4:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.pandaria64, 0, 0, 0);
                break;
            case 5:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.warlords64, 0, 0, 0);
                break;
            case 6:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.legion64, 0, 0, 0);
                break;
            case 7:
                holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.battleof64, 0, 0, 0);
                break;
        }
        holder.wordItemView.setText(d.getName());
        holder.search_button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, EditZone.class);
                        //start intent
                        intent.putExtra("datasent", d);
                        mContext.startActivity(intent);
                    }
                });
    }
    @Override
    public int getItemCount() {
        return (int) lZones.size();
    }


}
