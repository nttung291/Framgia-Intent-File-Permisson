package com.framgia.framgia_intent_file_permission;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by nttungg on 1/29/18.
 */

public class LoadImage extends AsyncTask<Void,Void,Void> {
    private Context context;
    private File file;
    private ImageView imageView;

    public LoadImage(Context context, File file, ImageView imageView) {
        this.context = context;
        this.file = file;
        this.imageView = imageView;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        publishProgress();
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Glide.with(context).load(file).into(imageView);
        super.onProgressUpdate(values);
    }
}
