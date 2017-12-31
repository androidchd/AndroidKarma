package com.KarmaLakeLand1;

import android.content.Context;
import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.Drawable;
import android.os.Environment;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//
//import com.squareup.picasso.Picasso;

import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.lang.ref.WeakReference;

///**
// * Created by Android Developer on 12/22/2016.
// */
public class SD_Directory {
    File file;
//    String mPath;

    Context context;
    private File cacheDir;
    public static String dir_name = "Karma Photos";

    public SD_Directory(Context context) {
        this.context = context;
        FileCache();
    }

   /* public void SD_Directory(final String url, final ImageView img_pht, final ProgressBar pr_bar, final Button button_act) {

        Bitmap bm = getBitmap(url);

        if (bm != null) {
            img_pht.setImageBitmap(bm);
            pr_bar.setVisibility(View.GONE);
            button_act.setVisibility(View.GONE);
        } else {
            button_act.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pr_bar.setVisibility(View.VISIBLE);
                    button_act.setVisibility(View.GONE);
                    ImageViewTarget mTarget = new ImageViewTarget(img_pht, pr_bar, url.hashCode() + ".jpg");
                    Picasso.with(context).load(url).into(mTarget);
                }
            });*/
    // }


    // ImageViewTarget mTarget = new ImageViewTarget(img_pht,pr_bar,url.hashCode()+".jpg");
    //Picasso.with(context).load(url).into(mTarget);
//}

    public void FileCache() {
        //Find the dir to save cached images
        try {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
                cacheDir = new File(Environment.getExternalStorageDirectory(), dir_name);
            else
                cacheDir = context.getCacheDir();
            if (!cacheDir.exists())
                cacheDir.mkdirs();
        } catch (NullPointerException e) {
        }
    }

//    public File getFile(String url) {
//        //I identify images by hashcode. Not a perfect solution, good for the menu_list.
//        String filename = String.valueOf(url.hashCode()) + ".jpg";
//        //Another possible solution (thanks to grantland)
//        //String filename = URLEncoder.encode(url);
//        File f = new File(cacheDir, filename);
//        return f;
//    }


//    public Bitmap getBitmap(String url) {
//        Bitmap bitmap = null;
//        File f = getFile(url);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        try {
//            bitmap = BitmapFactory.decodeStream(new FileInputStream(f), null, options);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return bitmap;
//    }

//    public void deleteFiles(String url) {
//        String filename = String.valueOf(url.hashCode()) + ".jpg";
//        File f = new File(cacheDir, filename);
//            f.delete();
//
//            /*String[] children = file.list();
//            for (int i = 0; i < children.length; i++) {
//                new File(file, children[i]).delete();*/
//
//        }

       /* if (file.exists()) {
            String deleteCmd = "rm -r " + file1;
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(deleteCmd);
            } catch (IOException e) {
            }
        }*/


    public void putBitmap(final Bitmap bitmap, String url) {

        final Bitmap tmp_bitmap = bitmap;
        final String f_url = String.valueOf(url.hashCode()) + "profile.jpg";

        new Thread(new Runnable() {
            @Override
            public void run() {
                file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + dir_name + "/" + f_url);
                try {
                    file.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(file);
                    tmp_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

//    private static class ImageViewTarget implements com.squareup.picasso.Target {
//
//        private WeakReference<ImageView> mImageViewReference;
//        private WeakReference<ProgressBar> mProgressBarReference;
//        private WeakReference<String> mFile_name;
//
//        public ImageViewTarget(ImageView imageView, ProgressBar progressBar, String file_name) {
//            this.mImageViewReference = new WeakReference<>(imageView);
//            this.mProgressBarReference = new WeakReference<>(progressBar);
//            this.mFile_name = new WeakReference<>(file_name);
//        }
//
//        @Override
//        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//
//            //you can use this bitmap to load image in image view or save it in image file like the one in the above question.
//            ImageView imageView = mImageViewReference.get();
//            if (imageView != null) {
//                imageView.setImageBitmap(bitmap);
//            }
//
//            ProgressBar progressBar = mProgressBarReference.get();
//            if (progressBar != null) {
//                progressBar.setVisibility(View.GONE);
//            }
//
//            final Bitmap tmp_bitmap = bitmap;
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + dir_name + "/" + mFile_name.get());
//                    try {
//                        file.createNewFile();
//                        FileOutputStream ostream = new FileOutputStream(file);
//                        tmp_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
//                        ostream.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//
//        @Override
//        public void onBitmapFailed(Drawable errorDrawable) {
//            ImageView imageView = mImageViewReference.get();
//            if (imageView != null) {
//                imageView.setImageDrawable(errorDrawable);
//            }
//
//            ProgressBar progressBar = mProgressBarReference.get();
//            if (progressBar != null) {
//                progressBar.setVisibility(View.GONE);
//            }
//        }
//
//        @Override
//        public void onPrepareLoad(Drawable placeHolderDrawable) {
//            ImageView imageView = mImageViewReference.get();
//            if (imageView != null) {
//                imageView.setImageDrawable(placeHolderDrawable);
//            }
//
//            ProgressBar progressBar = mProgressBarReference.get();
//            if (progressBar != null) {
//                progressBar.setVisibility(View.VISIBLE);
//            }
//        }
//    }
}