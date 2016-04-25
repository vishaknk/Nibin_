package dbtable;

import android.net.Uri;

import com.app.androidtestapp.androidtestapp.TnpProvider;

/**
 * Created by Nibin on 24-06-2015.
 */
public class News {

    //Define constants for table name, drop, create and column names.
    public static final String NEWS = "News";
    public static final String ID = "_id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE_NAME = "image_name";
    public static final String DATE_ADDED = "date_added";
    public static final String DATE_UPDATED = "date_updated";
    public static final String PUBLISHED_ON = "published_on";
    public static final String AUTHOR = "author";
    public static final String SERVER_ID = "server_id";

    //CONTENT_URI to be used by clients for getting data from this table.
    public static final Uri CONTENT_URI = Uri.parse("content://" + TnpProvider.AUTHORITY + "/" + NEWS);

    //creates the table
    public static final String CREATE_NEWS = "CREATE TABLE "
            + NEWS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + TITLE + " TEXT,"
            + DESCRIPTION + " TEXT, "
            + IMAGE_NAME + " TEXT, "
            + DATE_ADDED + " DATETIME, "
            + AUTHOR + " TEXT, "
            + DATE_UPDATED + " TEXT, "
            + SERVER_ID + " TEXT UNIQUE, "
            + PUBLISHED_ON + " TEXT"  + ")";

    // to refer server id content
    public static final String REFER_SERVER_ID = SERVER_ID + " = ?";

    //to get all the notification content, is read and date
    public static final String GET_SERVER_ID = " SELECT "
            + SERVER_ID
            + " FROM "
            + NEWS + " WHERE " + SERVER_ID + " = "  + " ?";


    // Get all news with header, image name and news date
    public static final String GET_ALL_NEWS_HEADER = " SELECT "
            + ID  + ", "
            + TITLE  + ", "
            + IMAGE_NAME  + ", "
            + SERVER_ID  + ", "
            + PUBLISHED_ON  +
            " FROM "  + NEWS
            + " ORDER BY " + "DATETIME(" + DATE_ADDED +")" + " DESC";

    // Get all news with title, image name and news date
    public static final String GET_ALL_NEWS = " SELECT "
            + ID  + ", "
            + TITLE  + ", "
            + AUTHOR  + ", "
            + IMAGE_NAME  + ", "
            + DESCRIPTION  + ", "
            + SERVER_ID  + ", "
            + DATE_UPDATED  + ", "
            + PUBLISHED_ON
            + " FROM "  + NEWS
            + " ORDER BY " + "DATETIME(" + DATE_ADDED +")"  + " DESC";

    // Get all server id
    public static final String GET_ALL_SERVER_ID = " SELECT "
            + ID  + ", "
            + IMAGE_NAME  + ", "
            + SERVER_ID
            + " FROM "  + NEWS;

}
