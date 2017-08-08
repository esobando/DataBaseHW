package com.example.admin.databasehw;

/**
 * Created by Admin on 8/7/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "Contacts";

    public static final String TABLE_NAME ="Contacts";
    public static final String CONTACT_NAME ="Name";
    public static final String CONTACT_NUMBER ="Number";
    public static final String  CONTACT_ADDRESS = "Address";

    public  static final String CONTACT_EMAIL = "Email";
    public static final String CONTACT_JOBTITLE = "JobTitle";
    private static final String TAG = "MyDBTag";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                CONTACT_NAME + " TEXT, " +
                CONTACT_NUMBER + " TEXT, " +
                CONTACT_ADDRESS + " TEXT, " +
                CONTACT_EMAIL + " TEXT, " +
                CONTACT_JOBTITLE + " TEXT" +
                ")";
        Log.d(TAG, "onCreate: "+CREATE_TABLE);

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    public void Delete() {
        SQLiteDatabase database = this.getWritableDatabase();
        String Delete = "DELETE FROM " + TABLE_NAME;
        Log.d(TAG, "onCreate: "+Delete);

        database.execSQL(Delete);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public void saveNewContact(ContactInfo contact){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_NAME, contact.getName());
        contentValues.put(CONTACT_NUMBER, contact.getPhone());
        contentValues.put(CONTACT_ADDRESS, contact.getAddress());
        contentValues.put(CONTACT_EMAIL, contact.getEmail());
        contentValues.put(CONTACT_JOBTITLE, contact.getJobTitle());

        database.insert(TABLE_NAME,null,contentValues);
        Log.d(TAG, "saveNewContact: "+contact.getName() + " " + contact.getPhone() + " " + contact.getAddress() + " " +
                contact.getEmail()
        + " " + contact.getJobTitle() );
    }

    public ArrayList<ContactInfo> getContacts(){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;

        //Cursor cursor = database.rawQuery(query, new String[]{CONTACT_NAME,"francisco"});
        Cursor cursor = database.rawQuery(query, null);
        ArrayList<ContactInfo> contacts = new ArrayList();
        if(cursor.moveToFirst()){
            do{
                Log.d(TAG, "getContacts: Name:" + cursor.getString(0) + ", Phone: "+ cursor.getString(1) + ", Email: " + cursor.getString(2) +
                        ", Address: " + cursor.getString(3)+ "JobTitle: " + cursor.getString(4));
                contacts.add(new ContactInfo(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            }while(cursor.moveToNext());
        }
        else{
            Log.d(TAG, "getContacts: empty");
        }
        return contacts;
    }







}
