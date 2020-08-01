package Controller;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import Model.CharacterCollection;

public class BooksGridAdapter extends BaseAdapter {
    private final Context mContext;

    public BooksGridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return CharacterCollection.getCharactersList().size();
    }

    @Override
    public Object getItem(int position) {
        return CharacterCollection.getCharactersList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return CharacterCollection.getCharactersList().get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtHeroName = new TextView(mContext);
        String heroName = CharacterCollection.getCharactersList().get(position).getName();
        txtHeroName.setText(heroName);
        txtHeroName.setTextColor(Color.parseColor("#000000"));
        return txtHeroName;
    }
}
