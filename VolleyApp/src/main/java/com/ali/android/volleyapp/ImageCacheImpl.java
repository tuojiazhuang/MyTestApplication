package com.ali.android.volleyapp;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2016/12/9.
 */
public class ImageCacheImpl implements ImageLoader.ImageCache {
    LruCache <String, Bitmap> lruCache;
    public ImageCacheImpl(){
        int maxSize =  10 * 1024 * 1024;//10M
        lruCache = new LruCache<String, Bitmap>(maxSize){

            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return lruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
            lruCache.put(url,bitmap);
    }
}
