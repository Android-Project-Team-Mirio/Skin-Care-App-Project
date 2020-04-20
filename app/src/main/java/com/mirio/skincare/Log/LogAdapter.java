package com.mirio.skincare.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirio.skincare.R;

import java.util.ArrayList;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.LogViewHolder> {

    private ArrayList<LogItem> mLogList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemCLickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class LogViewHolder extends RecyclerView.ViewHolder{

        public Button button;
        public EditText editText;
        public ScrollView scrollView;

        public ImageView imageView1;
        public ImageView imageView2;
        public ImageView imageView3;
        public ImageView imageView4;
        public ImageView imageView5;

        public LogViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);



           // scrollView = itemView.findViewById(R.id.scroll);
            button = itemView.findViewById(R.id.button);
            editText = itemView.findViewById(R.id.editText);
           imageView1 = itemView.findViewById(R.id.imageView3);
           imageView2 = itemView.findViewById(R.id.imageView4);
           imageView3 = itemView.findViewById(R.id.imageView5);
           imageView4 = itemView.findViewById(R.id.imageView6);
           imageView5 = itemView.findViewById(R.id.imageView7);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
               }
           });
        }
    }

    public LogAdapter(ArrayList<LogItem> logList){

        mLogList = logList;
    }

    @NonNull
    @Override
    public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_item, parent, false);
     LogViewHolder lvh = new LogViewHolder(v,mListener);

     return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LogViewHolder holder, int position) {
        LogItem currentItem = mLogList.get(position);
        holder.imageView1.setImageResource(currentItem.getImageScr());
      holder.imageView2.setImageResource(currentItem.getImageScr());
      holder.imageView3.setImageResource(currentItem.getImageScr());
      holder.imageView4.setImageResource(currentItem.getImageScr());
        holder.imageView5.setImageResource(currentItem.getImageScr());
        holder.editText.setText(currentItem.getmText());
    }



    @Override
    public int getItemCount() {
        return mLogList.size();
    }
}
