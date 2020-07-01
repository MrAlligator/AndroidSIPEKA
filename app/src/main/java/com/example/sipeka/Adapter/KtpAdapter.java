package com.example.sipeka.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.LihatPenduduk;
import com.example.sipeka.Model.Ktp.Ktp;
import com.example.sipeka.R;

import java.util.List;

public class KtpAdapter extends RecyclerView.Adapter<KtpAdapter.MyViewHolder> {
    List<Ktp> mKtpList;

    public KtpAdapter(List <Ktp> KtpList) {
        mKtpList = KtpList;
    }


    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ktp_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("NIK = " + mKtpList.get(position).getNik());
        holder.mTextViewNama.setText("Nama = " + mKtpList.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), LihatPenduduk.class);
                mIntent.putExtra("Prov", mKtpList.get(position).getProvinsi());
                mIntent.putExtra("Kab", mKtpList.get(position).getKabupaten());
                mIntent.putExtra("NIK", mKtpList.get(position).getNik());
                mIntent.putExtra("NIKK", mKtpList.get(position).getNoKk());
                mIntent.putExtra("Nama", mKtpList.get(position).getNama());
                mIntent.putExtra("Tempat Lahir", mKtpList.get(position).getTempatLahir());
                mIntent.putExtra("Tanggal Lahir", mKtpList.get(position).getTanggalLahir());
                mIntent.putExtra("Jenis Kelamin", mKtpList.get(position).getJenisKelamin());
                mIntent.putExtra("Gol Darah", mKtpList.get(position).getGolDarah());
                mIntent.putExtra("Alamat", mKtpList.get(position).getAlamat());
                mIntent.putExtra("Kode RT", mKtpList.get(position).getKodeRt());
                mIntent.putExtra("Kelurahan", mKtpList.get(position).getKelurahan());
                mIntent.putExtra("Kecamatan", mKtpList.get(position).getKecamatan());
                mIntent.putExtra("Agama", mKtpList.get(position).getAgama());
                mIntent.putExtra("Status Perkawinan", mKtpList.get(position).getStatusPerkawinan());
                mIntent.putExtra("Pekerjaan", mKtpList.get(position).getPekerjaan());
                mIntent.putExtra("Kewarganegaraan", mKtpList.get(position).getKewarganegaraan());
                mIntent.putExtra("Berlaku Hingga", mKtpList.get(position).getBerlakuHingga());
                mIntent.putExtra("Gambar", mKtpList.get(position).getGambar_Ktp());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mKtpList.size();
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
