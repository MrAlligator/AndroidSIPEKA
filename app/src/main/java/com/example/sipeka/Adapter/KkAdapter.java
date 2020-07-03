package com.example.sipeka.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.LihatKeluarga;
import com.example.sipeka.Model.Kk.Kk;
import com.example.sipeka.R;

import java.util.List;

public class KkAdapter extends RecyclerView.Adapter<KkAdapter.MyViewHolder> {
    List<Kk> mKkList;

    public KkAdapter(List <Kk> KkList) {
        mKkList = KkList;
    }

    @Override
    public KkAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kk_list, parent, false);
        KkAdapter.MyViewHolder mViewHolder = new KkAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.mTextViewNoKk.setText("No Kk = " + mKkList.get(position).getNoKk());
            holder.mTextViewNamaKk.setText("Nama KK = " + mKkList.get(position).getNamaKk());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = new Intent(view.getContext(), LihatKeluarga.class);
                    mIntent.putExtra("No KK", mKkList.get(position).getNoKk());
                    mIntent.putExtra("Nama KK", mKkList.get(position).getNamaKk());
                    mIntent.putExtra("Alamat", mKkList.get(position).getAlamat());
                    mIntent.putExtra("Kelurahan" , mKkList.get(position).getKelurahan());
                    mIntent.putExtra("Kecamatan" , mKkList.get(position).getKecamatan());
                    mIntent.putExtra("Kabupaten" , mKkList.get(position).getKabupaten());
                    mIntent.putExtra("Kode Pos" , mKkList.get(position).getKodePos());
                    mIntent.putExtra("Provinsi" , mKkList.get(position).getProvinsi());
                    mIntent.putExtra("Tanggal" , mKkList.get(position).getDikeluarkanTanggal());
                    mIntent.putExtra("Kode RT" , mKkList.get(position).getKodeRt());
                    view.getContext().startActivity(mIntent);
                }
            });
    }


    @Override
    public int getItemCount() {
        return mKkList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNoKk, mTextViewNamaKk;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNoKk = (TextView) itemView.findViewById(R.id.tvNoKk);
            mTextViewNamaKk = (TextView) itemView.findViewById(R.id.tvNamaKk);
        }
    }
}
