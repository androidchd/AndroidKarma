package Adapter;
import java.util.ArrayList;
import java.util.List;

import Helper.CourseGpsdata;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "GolfManager";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "CourseGPS";
 
    // Contacts Table Columns names
  
    private static final String KEY_HOLE = "holeNo";
    private static final String KEY_LAT = "latitude";
    private static final String KEY_LONG = "longitude";
    private static final String KEY_YARD = "yard";
    private static final String KEY_TEENNAME = "teename";
    
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                 + KEY_HOLE + " TEXT,"
                + KEY_LAT + " TEXT," + KEY_LONG + " TEXT," + KEY_YARD + " TEXT," + KEY_TEENNAME + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
     // Adding new contact
    public void addContact(CourseGpsdata contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_HOLE, contact.getHoleNo()); // Contact Name
        values.put(KEY_LAT, contact.getLatitude());
        values.put(KEY_LONG, contact.getLongitude());
        values.put(KEY_TEENNAME, contact.getTeename());
        values.put(KEY_YARD, contact.getYards());
       
       
        // Contact Phone
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
 
    // Getting single contact
 public  CourseGpsdata getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_HOLE, KEY_LAT, KEY_LONG, KEY_YARD }, KEY_HOLE + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        CourseGpsdata contact = new CourseGpsdata();
        contact.setHoleNo(cursor.getString(cursor.getColumnIndex(KEY_HOLE)));
        contact.setLatitude(cursor.getString(cursor.getColumnIndex(KEY_LAT)));
        contact.setLongitude(cursor.getString(cursor.getColumnIndex(KEY_LONG)));
        contact.setTeename(cursor.getString(cursor.getColumnIndex(KEY_TEENNAME)));
        contact.setYards(cursor.getString(cursor.getColumnIndex(KEY_YARD)));
 
       
        // return contact
        return contact;
    }
 
    // Getting All Contacts
    public List<CourseGpsdata> getAllContacts() {
        List<CourseGpsdata> contactList = new ArrayList<CourseGpsdata>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CourseGpsdata contact = new CourseGpsdata();
                contact.setHoleNo(cursor.getString(0));
                contact.setLatitude(cursor.getString(1));
                contact.setLongitude(cursor.getString(2));
                contact.setTeename(cursor.getString(3));
                contact.setYards(cursor.getString(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
 
    // Updating single contact
   /* public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());
 
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
 
    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
 */
    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
       
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
   /* public String getHoleYards()
    {
    	String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
       
        cursor.close();
 
        // return count
        return cursor;
    }*/
    
 
}