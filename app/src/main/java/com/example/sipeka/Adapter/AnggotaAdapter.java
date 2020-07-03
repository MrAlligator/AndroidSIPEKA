package com.example.sipeka.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.LihatPenduduk;
import com.example.sipeka.Model.Anggota.Anggota;
import com.example.sipeka.R;

import java.util.List;

public class AnggotaAdapter extends RecyclerView.Adapter<com.example.sipeka.Adapter.AnggotaAdapter.MyViewHolder>{
    List<Anggota> mAnggotaList;

    public AnggotaAdapter(List <Anggota> AnggotaList) {
        mAnggotaList = AnggotaList;
    }

    @Override
    public AnggotaAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.anggota_list, parent, false);
        AnggotaAdapter.MyViewHolder mViewHolder = new AnggotaAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (AnggotaAdapter.MyViewHolder holder, final int position){
        holder.mTextViewId.setText("NIK = " + mAnggotaList.get(position).getNik());
        holder.mTextViewNama.setText("Nama = " + mAnggotaList.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), LihatPenduduk.class);
                mIntent.putExtra("Prov", mAnggotaList.get(position).getProvinsi());
                mIntent.putExtra("Kab", mAnggotaList.get(position).getKabupaten());
                mIntent.putExtra("NIK", mAnggotaList.get(position).getNik());
                mIntent.putExtra("NIKK", mAnggotaList.get(position).getNoKk());
                mIntent.putExtra("Nama", mAnggotaList.get(position).getNama());
                mIntent.putExtra("Tempat Lahir", mAnggotaList.get(position).getTempatLahir());
                mIntent.putExtra("Tanggal Lahir", mAnggotaList.get(position).getTanggalLahir());
                mIntent.putExtra("Jenis Kelamin", mAnggotaList.get(position).getJenisKelamin());
                mIntent.putExtra("Gol Darah", mAnggotaList.get(position).getGolDarah());
                mIntent.putExtra("Alamat", mAnggotaList.get(position).getAlamat());
                mIntent.putExtra("Kode RT", mAnggotaList.get(position).getKodeRt());
                mIntent.putExtra("Kelurahan", mAnggotaList.get(position).getKelurahan());
                mIntent.putExtra("Kecamatan", mAnggotaList.get(position).getKecamatan());
                mIntent.putExtra("Agama", mAnggotaList.get(position).getAgama());
                mIntent.putExtra("Status Perkawinan", mAnggotaList.get(position).getStatusPerkawinan());
                mIntent.putExtra("Pekerjaan", mAnggotaList.get(position).getPekerjaan());
                mIntent.putExtra("Kewarganegaraan", mAnggotaList.get(position).getKewarganegaraan());
                mIntent.putExtra("Berlaku Hingga", mAnggotaList.get(position).getBerlakuHingga());
                mIntent.putExtra("Gambar", mAnggotaList.get(position).getGambar_Ktp());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mAnggotaList.size();
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
