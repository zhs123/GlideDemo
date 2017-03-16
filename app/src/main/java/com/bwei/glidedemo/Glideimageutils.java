package com.bwei.glidedemo;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/3/16
 */


public class Glideimageutils {
    public static void Imagelode(Context context, String imageurl, ImageView imageView){
        Glide.with(context)
                .load(imageurl)
                .thumbnail(0.7f)//加载缩略图
                .override(800,600)
                .placeholder(R.mipmap.ic_launcher)//加载占位图
                .error(R.mipmap.ic_launcher)//加载错误图
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//设置缓存
                .skipMemoryCache(true)//跳过缓存
                .dontAnimate()//加载五动画
//                .centerCrop()//居中对齐
                .fitCenter()
                //转换不同图形的图片
                .bitmapTransform(new CropCircleTransformation(Glide.get(context).getBitmapPool()))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);

    }
}
