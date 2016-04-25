package com.app.androidtestapp.androidtestapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import dbtable.Contact;
import dbtable.Links;
import dbtable.News;
import dbtable.Notifications;


/**
 * Created by Nibin on 18-06-2015.
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    public static String DBNAME = "tnp";
    public static int DBVERSION = 2;
    Context mContext;

    public DbOpenHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Contact.CREATE_CONTACT);
        db.execSQL(Links.CREATE_LINKS);
        db.execSQL(Notifications.CREATE_NOTIFICATIONS);
        db.execSQL(News.CREATE_NEWS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 2) {

            db.execSQL(News.CREATE_NEWS);
            db.execSQL(Contact.ADD_COLUMN_DATE_ADDED);
            db.execSQL(Contact.ADD_COLUMN_DATE_UPDATED);
            db.execSQL(Contact.ADD_COLUMN_E_SERVER_TAG);
            db.execSQL(Notifications.DROP_NOTIFICATIONS);
            db.execSQL(Notifications.CREATE_NOTIFICATIONS);
            db.execSQL(Links.DROP_LINKS);
            db.execSQL(Links.CREATE_LINKS);
            db.execSQL(Contact.CREATE_CONTACT_TMP);
            db.execSQL(Contact.DROP_CONTACT);
            db.execSQL(Contact.CREATE_CONTACT);
            db.execSQL(Contact.INSERT_INTO_CONTACT_FROM_CONTACT_TMP);
            db.execSQL(Contact.DROP_CONTACT_TMP);

        }
    }
}
