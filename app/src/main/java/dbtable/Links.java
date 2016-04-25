package dbtable;

import android.net.Uri;

import com.app.androidtestapp.androidtestapp.TnpProvider;

/**
 * Created by Nibin on 23-06-2015.
 */
public class Links {

    public static String LINKS = "Links";
    public static final String ID = "_id";
    public static String LINK_TITLE = "LINK_TITLE";
    public static String LINK_IMAGE = "link_image";
    public static String URL = "url";
    public static String PRIORITY = "priority";
    public static String DATE_ADDED = "date_added";
    public static String DATE_UPDATED = "date_updated";
    public static final String SERVER_ID = "server_id";

    //CONTENT_URI to be used by clients for getting data from this table.
    public static final Uri CONTENT_URI = Uri.parse("content://" + TnpProvider.AUTHORITY + "/" + LINKS);

    //creates the table
    public static final String CREATE_LINKS = "CREATE TABLE "
            + LINKS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + LINK_TITLE + " TEXT, "
            + LINK_IMAGE + " TEXT, "
            + URL + " TEXT, "
            + PRIORITY + " TEXT, "
            + DATE_ADDED + " TEXT, "
            + SERVER_ID + " TEXT UNIQUE, "
            + DATE_UPDATED + " TEXT "  + ")";

    //adds a new column for unique id
    public static final String ADD_COLUMN_SERVER_ID = "ALTER TABLE "
            +  Links.LINKS
            + " ADD COLUMN "
            + Links.SERVER_ID + " TEXT UNIQUE";

    // get all images in priority order
    public static final String GET_ALL_LINK_IMAGES_SORTED = " SELECT "
            + LINK_IMAGE + ", "
            + ID  + ", "
            + PRIORITY  + ", "
            + URL
            + " FROM " + LINKS
            + " ORDER BY "
            + "CAST(" + " PRIORITY " + " AS " +" INTEGER"+")" + " ,"
            + DATE_ADDED + " DESC";

    //drops the table notification
    public static final String DROP_LINKS = "DROP TABLE IF EXISTS \"Links\"";


    // to refer server id content
    public static final String REFER_SERVER_ID = SERVER_ID + " = ?";

    // Get all server id
    public static final String GET_ALL_SERVER_ID = " SELECT "
            + ID  + ", "
            + LINK_IMAGE  + ", "
            + SERVER_ID
            + " FROM "  + LINKS;

    // Get all server id
    public static final String GET_SERVER_COUNT = " SELECT "
            + ID  + ", "
            + SERVER_ID
            + " FROM "  + LINKS +
            " WHERE " + SERVER_ID + " =  ?";

    // clear links table
    public static final String CLEAR_LINKS_TABLE = " SELECT "
            + "*"  +
            " FROM "  + LINKS;

    // to refer title content
    public static final String REFER_LINK_IMAGE = LINK_IMAGE + " = ?";



}
