package com.app.androidtestapp.androidtestapp;

/*
 * Description  : Content Provider class
 *
 * Author  		: Nibin Salim, Media Systems, Inc.
 * Date   		: 18/06/15
 * Reviewed By  :
 */

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import dbtable.Contact;
import dbtable.Links;
import dbtable.News;
import dbtable.Notifications;


public class TnpProvider extends ContentProvider {

    //member variables
    private DbOpenHelper mDbHelper;
    private SQLiteDatabase mDb;
    // registered with Android when the application is installed.
    public static String AUTHORITY = "com.mediaindia.tnp.TnpProvider";

    //Provide a constant for all the tables/queries going to be handled by the provider.
    public static final int CONTACT = 101;
    public static final int LINKS = 102;
    public static final int NEWS = 103;
    public static final int NOTIFICATIONS = 104;


    // URI corresponds to a query/service.
    public static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        mUriMatcher.addURI(AUTHORITY, Contact.CONTACT, CONTACT);
        mUriMatcher.addURI(AUTHORITY, Links.LINKS, LINKS);
        mUriMatcher.addURI(AUTHORITY, Notifications.NOTIFICATIONS, NOTIFICATIONS);
        mUriMatcher.addURI(AUTHORITY, News.NEWS, NEWS);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new DbOpenHelper(getContext());
        mDb = mDbHelper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        //to notify content resolver & result is returned in cursor object
        Cursor cursor = mDb.rawQuery(selection, selectionArgs);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    //Insert method called when there is any data insert request
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = mUriMatcher.match(uri);
        long id=0;
        switch (uriType) {
            case CONTACT:
                id = mDb.insertOrThrow(Contact.CONTACT, null, values);
                break;
            case LINKS:
                id = mDb.insertOrThrow(Links.LINKS, null, values);
                break;
            case NEWS:
                id = mDb.insertOrThrow(News.NEWS, null, values);
                break;
            case NOTIFICATIONS:
                id = mDb.insertOrThrow(Notifications.NOTIFICATIONS, null, values);
                break;
             default:
                throw new IllegalArgumentException("Unknown URI : " + uri);
        }
        Uri itemUri = ContentUris.withAppendedId(uri, id);
        getContext().getContentResolver().notifyChange(itemUri, null);
        return itemUri;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {

        return super.bulkInsert(uri, values);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rowsDeleted = 0;
        switch (mUriMatcher.match(uri)){
            case CONTACT:
                rowsDeleted = mDb.delete(Contact.CONTACT, selection, selectionArgs);
                break;
            case LINKS:
                rowsDeleted = mDb.delete(Links.LINKS, selection, selectionArgs);
                break;
            case NEWS:
                rowsDeleted = mDb.delete(News.NEWS, selection, selectionArgs);
                break;
            case NOTIFICATIONS:
                rowsDeleted = mDb.delete(Notifications.NOTIFICATIONS, selection, selectionArgs);
                break;
      }

        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int rowsUpdated = 0;
        if (values.size() == 0) {
            mDb.execSQL(String.format(selection, (Object[]) selectionArgs));
            getContext().getContentResolver().notifyChange(uri, null);
            return 0;
        }
        switch (mUriMatcher.match(uri)){
            case CONTACT:
                rowsUpdated = mDb.update(Contact.CONTACT, values, selection, selectionArgs);

                break;
            case LINKS:
                rowsUpdated = mDb.update(Links.LINKS, values, selection, selectionArgs);
                break;
            case NEWS:
                rowsUpdated = mDb.update(News.NEWS, values, selection, selectionArgs);
                break;
            case NOTIFICATIONS:
                rowsUpdated = mDb.update(Notifications.NOTIFICATIONS, values, selection, selectionArgs);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }

}
