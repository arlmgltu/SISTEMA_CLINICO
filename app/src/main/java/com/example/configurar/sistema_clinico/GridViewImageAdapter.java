package com.example.configurar.sistema_clinico;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridViewImageAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<Integer> listPhoto = new ArrayList<Integer>();
    /** Constructor de clase */
    public GridViewImageAdapter(Context c){
        mContext = c;
        //se cargan las miniaturas
        listPhoto.add(R.drawable.hematologia);
        listPhoto.add(R.drawable.inmunologia);
        listPhoto.add(R.drawable.bioquimica1);
        listPhoto.add(R.drawable.microbio);
        listPhoto.add(R.drawable.orina);
        listPhoto.add(R.drawable.pop);
    }

    @Override
    public int getCount() {
        return listPhoto.size();
    }

    @Override
    public Object getItem(int position) {
        return listPhoto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewgroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource( listPhoto.get(position) );
        imageView.setScaleType( ImageView.ScaleType.CENTER_CROP );
        imageView.setLayoutParams( new GridView.LayoutParams(150, 180) );
        return imageView;
    }
}
