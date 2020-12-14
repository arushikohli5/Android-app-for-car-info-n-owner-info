package com.example.challangefragmentsrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>
{
    ArrayList<Car> cars;
    ItemClicked activity;
    public interface ItemClicked{
        void OnItemClicked(int index);
    }
    public CarAdapter(Context context,ArrayList<Car> list)
    {
        cars=list;
        activity=(ItemClicked) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivlogo;
        TextView tvcarname,tvname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivlogo=itemView.findViewById(R.id.ivlogo);
            tvcarname=itemView.findViewById(R.id.tvcarname);
            tvname=itemView.findViewById(R.id.tvname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.OnItemClicked(cars.indexOf((Car)view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(cars.get(position));

        holder.tvname.setText(cars.get(position).getName());
        holder.tvcarname.setText(cars.get(position).getCarname());

        if(cars.get(position).getLogo().equals("mercedes"))
        {
            holder.ivlogo.setImageResource(R.drawable.mercedes);
        }
        else if(cars.get(position).getLogo().equals("nissan"))
        {
            holder.ivlogo.setImageResource(R.drawable.nissan);
        }
        else{
            holder.ivlogo.setImageResource(R.drawable.volkswagen);
        }


    }
    @Override
    public int getItemCount() {
        return cars.size();
    }
}
