package com.example.pivithuru.assignment06;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pivithuru on 8/8/17.
 */

public class MyUpdateImageHelper extends AsyncTask<String, Void, Bitmap> {

    private final WeakReference<ImageView> imageViewReference;

    public MyUpdateImageHelper(ImageView imageView){

        this.imageViewReference=new WeakReference<ImageView>(imageView);

    }


    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap bitmap=null;

        for(String url: urls){
            bitmap=MyUtility.downloadImageusingHTTPGetRequest(url);
        }
        return bitmap;
    }


    protected void onPostExecute(Bitmap bitmap){

        if (imageViewReference!=null){

            final ImageView imageView=imageViewReference.get();
            if(imageView!=null){
               imageView.setImageBitmap(bitmap);
            }

        }


    }
}

