package com.example.tiaapplication;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static List<User> localDataSet;
    private static OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    //custom interface 정의
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public CustomAdapter(List<User> testDataSet) {
        localDataSet = testDataSet;
    }

    public User getItem(int position) {
        return localDataSet.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView userName;
        private final TextView phoneNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name_title);
            phoneNumber = itemView.findViewById(R.id.user_phone_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickPos = getAdapterPosition();
                    if(clickPos != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(v, clickPos);
                    }
                }
            });
        }
        public TextView getUserName() {
            return userName;
        }
        public TextView getPhoneNumber() {
            return phoneNumber;
        }
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nestedscrollview_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.userName.setText(localDataSet.get(position).getName());
        holder.phoneNumber.setText(localDataSet.get(position).getPhoneNumber());
        Log.d(TAG, "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
