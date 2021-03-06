package id.ac.uny.afandi.rahmad.hellouny;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rmd on 1/18/2018.
 */

class ListPengumumanAdapter extends RecyclerView.Adapter<ListPengumumanAdapter.ViewHolder> {

    private Context context;
    private List<ListPengumuman> list;

    public ListPengumumanAdapter(Context context, List<ListPengumuman> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pengumuman,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textTanggal.setText(list.get(position).getTanggal());
        holder.textJudul.setText(list.get(position).getJudul());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity compatActivity = (AppCompatActivity) v.getContext();
                DetailPengumumanFragment detailPengumumanFragment = new DetailPengumumanFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url", list.get(position).getLink());
                detailPengumumanFragment.setArguments(bundle);
                compatActivity.getFragmentManager().beginTransaction().replace(R.id.content_main,detailPengumumanFragment).commit();
                DrawerLayout drawer = compatActivity.findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textJudul;
        public TextView textTanggal;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textJudul = itemView.findViewById(R.id.judul);
            textTanggal = itemView.findViewById(R.id.tanggal);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

