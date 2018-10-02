package com.kashyap.wallpapers.common;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.kashyap.wallpapers.R;
import com.kashyap.wallpapers.domain.models.Images;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (int i = 0; i < 10; i++) {
                    Images images = createImageObject(i);
                    realm.copyToRealmOrUpdate(images);
                }
            }
        });

    }

    public Images createImageObject(int i) {
        Images images = new Images();
        try {

            images.setId(i + "");
            File file = new File(getCacheDir(), "all");
            if (!file.exists()) {
                file.mkdir();

            }
            if (file.exists() && file.isDirectory()) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                File image = new File(file.getAbsolutePath(), "ic_launcher.png");
                FileOutputStream fOut = new FileOutputStream(image);

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();


                images.setFilePath(image.getPath());
                bitmap.recycle();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}
