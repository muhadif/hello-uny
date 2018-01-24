package id.ac.uny.afandi.rahmad.hellouny;

import org.json.JSONArray;


/**
 * Created by rmd on 1/18/2018.
 */

class DetailListPengumuman {

    private JSONArray konten;
    private JSONArray lampiran;
    private JSONArray judul_lampiran;

    public DetailListPengumuman(JSONArray konten, JSONArray lampiran, JSONArray judul_lampiran) {
        this.konten = konten;
        this.lampiran = lampiran;
        this.judul_lampiran = judul_lampiran;
    }

    public JSONArray getKonten() {
        return konten;
    }

    public JSONArray getLampiran() {
        return lampiran;
    }

    public JSONArray getJudul_lampiran() {
        return judul_lampiran;
    }
}

