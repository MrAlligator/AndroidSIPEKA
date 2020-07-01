package com.example.sipeka.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.LihatPenduduk;
import com.example.sipeka.Model.Rt.Rt;
import com.example.sipeka.R;

import java.util.List;

//import com.example.bismillah.EditActivity;

public class RtAdapter extends RecyclerView.Adapter<RtAdapter.MyViewHolder>{
    List<Rt> mRtList;

    public RtAdapter(List<Rt> RtList) {
        mRtList = RtList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rt_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mRtList.get(position).getKodeRt());
        holder.mTextViewNama.setText("Nama = " + mRtList.get(position).getRt());
        holder.mTextViewNomor.setText("Nomor = " + mRtList.get(position).getRw());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), LihatPenduduk.class);
                mIntent.putExtra("Kode RT", mRtList.get(position).getKodeRt());
                mIntent.putExtra("RT", mRtList.get(position).getRt());
                mIntent.putExtra("RW", mRtList.get(position).getRw());
                view.getContext().startActivity(mIntent);
        }
        });
    }

    @Override
    public int getItemCount () {
        return mRtList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
//            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
        }
    }
}
