package com.example.sipeka.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.LihatPenduduk;
import com.example.sipeka.Model.Kk.Kk;
import com.example.sipeka.R;

import java.util.List;

public class KkAdapter {
    List<Kk> mKkList;

    public KkAdapter(List <Kk> KkList) {
        mKkList = KkList;
    }

    @Override
    public KkAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ktp_list, parent, false);
        KkAdapter.MyViewHolder mViewHolder = new KkAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (KtpAdapter.MyViewHolder holder, final int position){
        holder.mTextViewId.setText("NIK = " + mKkList.get(position).getNoKk());
        holder.mTextViewNama.setText("Nama = " + mKkList.get(position).getNamaKk());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), LihatPenduduk.class);
                mIntent.putExtra("No KK", mKkList.get(position).getNoKk());
                mIntent.putExtra("Nama KK", mKkList.get(position).getNamaKk());
                mIntent.putExtra("Alamat", mKkList.get(position).getAlamat());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
        }
    }
}
