package Controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.marvelapp.R;
import com.squareup.picasso.Picasso;

import Model.CharacterCollection;
import Model.Image;
import Utils.Constants;

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

        String heroThumbnailUrl = "";
        Image heroThumbnail =  CharacterCollection.getCharactersList().get(position).getThumbnail();

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.hero_thumbnail, null);
        }

        ImageView imgHeroThumbnail = convertView.findViewById(R.id.imgHeroThumbnail);
        heroThumbnailUrl = heroThumbnail.getPath() + "/" + Constants.IMAGE_VARIANT_MEDIUM + "." + heroThumbnail.getExtension();

        Picasso.get()
                .load(heroThumbnailUrl)
                .into(imgHeroThumbnail);

        return convertView;
    }
}
