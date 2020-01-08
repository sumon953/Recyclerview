package com.example.recyclerviewincrement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<MyViewHolder> mycontract = new ArrayList<MyViewHolder>();
    onContractClickListner oncontractclicklistner;



    //Constructore;
    public RecyclerAdapter(ArrayList<MyViewHolder> mycontract,onContractClickListner oncontractclicklistner) {

        this.mycontract = mycontract;
        this.oncontractclicklistner = oncontractclicklistner;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rawlayout,parent,false);
        //ViewHolder vh = new ViewHolder(v);
        return new ViewHolder(view,oncontractclicklistner);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyViewHolder current = mycontract.get(position);
        holder.name.setText(current.getName());
        holder.phonenumber.setText(current.getNumber());

    }

    @Override
    public int getItemCount() {

        if (mycontract.isEmpty())
        {
            return 0;

        }

        return mycontract.size();
    }




    //MyView Holder Class;
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

      public TextView name,phonenumber;
      onContractClickListner onContractClickListner;

        public ViewHolder(@NonNull View itemView, onContractClickListner onContractClickListner) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phonenumber = itemView.findViewById(R.id.phone);
            this.onContractClickListner=onContractClickListner;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            onContractClickListner.onContractClick(getAdapterPosition());
        }
    }



    public interface onContractClickListner{

        void onContractClick(int position);
    }


}
