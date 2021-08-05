package com.ncertguruji.objectboxnote;
import android.content.Context;
import com.ncertguruji.objectboxnote.entity.MyObjectBox;
import io.objectbox.BoxStore;

public class ObjectBox {
    private static BoxStore boxStore;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();
    }

    public static BoxStore get() { return boxStore; }
}
