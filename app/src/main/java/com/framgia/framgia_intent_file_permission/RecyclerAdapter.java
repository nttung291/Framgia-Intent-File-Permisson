package com.framgia.framgia_intent_file_permission;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by nttungg on 1/26/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private File[] files;
    private Context context;

    public RecyclerAdapter(File[] files, Context context) {
        this.files = files;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View itemview = layoutInflater.inflate(R.layout.item_recyclerview,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(files[position]);
    }

    @Override
    public int getItemCount() {
        return files.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
        public void bindData(File file){
            new LoadImage(context,file,imageView).execute();
        }

    }
}
