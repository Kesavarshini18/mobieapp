package com.example.speedygatewaytravels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter(List<ModelClass>userList){
        this.userList=userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int res=userList.get(position).getImageview1();
        String name=userList.get(position).getText1();
        String msg= userList.get(position).getText3();
        String time=userList.get(position).getText2();
        String line=userList.get(position).getDivider();

        holder.setData(res,name,msg,time,line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView text1;
        private TextView text2;
        private TextView text3;
        private TextView divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.imageview1);
            text1 =itemView.findViewById(R.id.text1);
            text2 =itemView.findViewById(R.id.text2);
            text3 =itemView.findViewById(R.id.text3);
            divider =itemView.findViewById(R.id.divider);}

        public void setData(int resourse,String name,String msg,String time,String line){

            imageView.setImageResource(resourse);
            text1.setText(name);
            text3.setText(msg);
            text2.setText(time);
            divider.setText(line);


        }

    }
}
