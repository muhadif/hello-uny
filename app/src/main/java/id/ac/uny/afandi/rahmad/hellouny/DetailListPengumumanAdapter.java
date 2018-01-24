package id.ac.uny.afandi.rahmad.hellouny;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Created by rmd on 1/18/2018.
 */

class DetailListPengumumanAdapter extends RecyclerView.Adapter<DetailListPengumumanAdapter.ViewHolder> {

    private Context context;
    private List<DetailListPengumuman> list;

    public DetailListPengumumanAdapter(Context context, List<DetailListPengumuman> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_pengumuman,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        JSONArray konten = list.get(position).getKonten();
        for (int i = 0; i < konten.length() ; i++) {
            try {
                Log.d("url",konten.getString(i));
                Picasso.with(context).load(konten.getString(i)).into(holder.imageView);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONArray lampiran = list.get(position).getLampiran();
        JSONArray judul_lampiran = list.get(position).getJudul_lampiran();
        for (int i = 0; i < lampiran.length() ; i++) {
            try {
                holder.textKonten.setText(judul_lampiran.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textKonten;
        public ImageView imageView;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textKonten = itemView.findViewById(R.id.konten);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

