package com.itacademy.restapiexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.itacademy.restapiexample.model.Post;

import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter<Post> {


    int layoutResourceId;
    Context context;
    ArrayList<Post> data;

    public PostAdapter(Context context, int layoutResourceId, ArrayList<Post> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    /*Esta función es la que se encarga de dibujar las filas del listado una a una
        por cada posición en el ArrayList data
         */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        /*Los TextView corresponden a los creados en res/layout/row.xml */
        TextView tv_id = (TextView) row.findViewById(R.id.tv_id);
        //Utilizar el String.valueOf ya que el id es un INT y la función setText se espera un String.
        tv_id.setText(String.valueOf(data.get(position).getId()));

        TextView tv_title = (TextView) row.findViewById(R.id.tv_title);
        tv_title.setText(data.get(position).getTitle());


        return row;
    }


}
