package dbtable;

import android.net.Uri;

import com.app.androidtestapp.androidtestapp.TnpProvider;

/**
 * Created by Nibin on 24-06-2015.
 */
public class Notifications {

    public static final String NOTIFICATIONS = "notifications";
    public static final String CONTENT = "content";
    public static final String DATE = "date";
    public static final String IS_READ = "is_read";
    public static final String DATE_UPDATED = "date_updated";
    public static final String DATE_ADDED = "date_added";
    public static final String SERVER_ID = "server_id";
    public static final String IS_DELETED = "is_deleted";

    //CONTENT_URI to be used by clients for getting data from this table.
    public static final Uri CONTENT_URI = Uri.parse("content://" + TnpProvider.AUTHORITY + "/" + NOTIFICATIONS);

    //creates the table
    public static final String CREATE_NOTIFICATIONS = "CREATE TABLE "
            + NOTIFICATIONS + "(" + CONTENT + " TEXT, "
            + DATE + " TEXT, "
            + DATE_ADDED + " DATETIME, "
            + SERVER_ID + " TEXT UNIQUE, "
            + DATE_UPDATED + " TEXT, "
            + IS_DELETED + " TEXT, "
            + IS_READ + " TEXT "  + ")";

    //drops the table notification
    public static final String DROP_NOTIFICATIONS = "DROP TABLE IF EXISTS \"notifications\"";

    //adds a new column for date added
    public static final String ADD_COLUMN_DATE_ADDED = "ALTER TABLE "
            + Notifications.NOTIFICATIONS
            + " ADD COLUMN "
            + Notifications.DATE_ADDED + " DATETIME";

    //adds a new column for date updated
    public static final String ADD_COLUMN_DATE_UPDATED = "ALTER TABLE "
            + Notifications.NOTIFICATIONS
            + " ADD COLUMN "
            + Notifications.DATE_UPDATED + " TEXT";

    //adds a new column for read or not
    public static final String ADD_COLUMN_READ = "ALTER TABLE "
            + Notifications.NOTIFICATIONS
            + " ADD COLUMN "
            + Notifications.IS_READ + " TEXT";

    //adds a new column for read or not
    public static final String ADD_COLUMN_DELETED = "ALTER TABLE "
            + Notifications.NOTIFICATIONS
            + " ADD COLUMN "
            + Notifications.IS_DELETED + " TEXT";

    //adds a new column for unique id
    public static final String ADD_COLUMN_SERVER_ID = "ALTER TABLE "
            + Notifications.NOTIFICATIONS
            + " ADD COLUMN "
            + Notifications.SERVER_ID + " TEXT UNIQUE";

    //to get all the notification content, is read and date
    public static final String GET_ALL_NOTIFICATIONS = " SELECT "
            + SERVER_ID + ","
            + CONTENT + ", "
            + IS_READ  + ", "
            + DATE
            + " FROM "  + NOTIFICATIONS
            + " WHERE " + IS_DELETED + " = " + "0"
            + " ORDER BY "   + DATE_ADDED   + " DESC";

    // to refer notification content
    public static final String REFER_NOTIFICATION_CONTENT  = CONTENT + " = ? ";

    //to get all the notification content, is read and date
    public static final String GET_ALL_UNREAD_NOTIFICATION = " SELECT "
            + IS_READ
            + " FROM "
            + NOTIFICATIONS+ " WHERE " + IS_READ + " = "  + " 0";

    // to refer server id content
    public static final String REFER_SERVER_ID = SERVER_ID + " = ?";

    //to get all the notification content, is read and date
    public static final String GET_SERVER_ID = " SELECT "
            + SERVER_ID
            + " FROM "
            + NOTIFICATIONS+ " WHERE " + SERVER_ID + " = "  + " ?";

    // clear notification table
    public static final String CLEAR_NOTIFICATIONS_TABLE = " SELECT "
            + "*"  +
            " FROM "  + NOTIFICATIONS;



}
