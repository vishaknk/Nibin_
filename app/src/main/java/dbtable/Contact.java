package dbtable;

import android.net.Uri;

import com.app.androidtestapp.androidtestapp.TnpProvider;


/**
 * Created by Nibin on 23-06-2015.
 */

public class Contact {

	//Define constants for table name, drop, create and column names.
	public static final String CONTACT = "Contact";
	public static final String ID = "_id";
	public static final String DISPLAY_NAME = "display_name";
	public static final String IMAGE_URL = "image_url";
	public static final String EMAIL = "email";
	public static final String PHONE_NUMBER = "phone_number";
	public static final String DATE_UPDATED = "date_updated";
	public static final String DATE_ADDED = "date_added";
	public static final String SERVER_E_TAG = "server_e_tag";
	public static final String SERVER_ID = "server_id";

	//CONTENT_URI to be used by clients for getting data from this table.
	public static final Uri CONTENT_URI = Uri.parse("content://" + TnpProvider.AUTHORITY + "/" + CONTACT);

	//creates the table
	public static final String CREATE_CONTACT = "CREATE TABLE "
			+ CONTACT + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
			+ DISPLAY_NAME + " TEXT,"
			+ IMAGE_URL + " TEXT,"
			+ DATE_ADDED + " TEXT,"
			+ DATE_UPDATED + " TEXT, "
			+ EMAIL + " TEXT,"
			+ SERVER_ID + " TEXT UNIQUE, "
			+ PHONE_NUMBER + " TEXT" + ")";

	public static final String CREATE_CONTACT_TMP = "CREATE TABLE \"ContactTmp\" AS SELECT * FROM \"Contact\"";

	public static final String INSERT_INTO_CONTACT_FROM_CONTACT_TMP = "INSERT INTO \"Contact\" SELECT * FROM \"ContactTmp\"";

	public static final String DROP_CONTACT_TMP = "DROP TABLE IF EXISTS \"ContactTmp\"";

	//drops the table notification
	public static final String DROP_CONTACT = "DROP TABLE IF EXISTS \"Contact\"";

	//adds a new column for unique id
	public static final String ADD_COLUMN_SERVER_ID = "ALTER TABLE "
			+  Contact.CONTACT
			+ " ADD COLUMN "
			+ Contact.SERVER_ID + " TEXT UNIQUE";

	//adds a new column for date updated
	public static final String ADD_COLUMN_DATE_UPDATED = "ALTER TABLE "
			+ Contact.CONTACT
			+ " ADD COLUMN "
			+ Contact.DATE_ADDED + " TEXT";

	//adds a new column for date added
	public static final String ADD_COLUMN_DATE_ADDED = "ALTER TABLE "
			+ Contact.CONTACT
			+ " ADD COLUMN "
			+ Contact.DATE_UPDATED + " TEXT";

	//adds a new column for E tag
	public static final String ADD_COLUMN_E_SERVER_TAG = "ALTER TABLE "
			+ Contact.CONTACT
			+ " ADD COLUMN "
			+ Contact.SERVER_E_TAG + " TEXT";


	public static final String REFER_EMAIL_ADDRESS = EMAIL + " = ?";

	// Get all Contacts
	public static final String GET_ALL_CONTACTS = " SELECT "
			+ ID + ", "
			+ DISPLAY_NAME + ", "
			+ IMAGE_URL + ", "
			+ EMAIL + ", "
			+ SERVER_ID + ", "
			+ PHONE_NUMBER
			+ " FROM " + CONTACT
			+ " WHERE " + PHONE_NUMBER + " IS NOT NULL"
			+ " AND " + EMAIL + " IS NOT NULL"
			+ " ORDER BY "
			+ DISPLAY_NAME + " COLLATE NOCASE ASC";

    // Get all Contacts
    public static final String GET_ALL_SERVER_ID = " SELECT "
            + ID + ", "
            + DISPLAY_NAME + ", "
            + IMAGE_URL + ", "
            + EMAIL + ", "
            + SERVER_ID + ", "
            + PHONE_NUMBER
            + " FROM " + CONTACT
            + " ORDER BY "
            + DISPLAY_NAME + " COLLATE NOCASE ASC";


    // Get all email
	public static final String GET_ALL_EMAIL = " SELECT "
			+ ID + ", "
			+ EMAIL +
			" FROM " + CONTACT;

	// to refer server id content
	public static final String REFER_SERVER_ID = SERVER_ID + " = ?";

	// to refer server id content for deleting contacts without server_id
	public static final String REFER_ID = SERVER_ID + " IS NULL";

	}

