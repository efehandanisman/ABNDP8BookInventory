package com.example.android.abndp8bookinventory;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.abndp8bookinventory.data.BookContract.BookEntry;
import com.example.android.abndp8bookinventory.data.BookContract;
import com.example.android.abndp8bookinventory.data.BookDbHelper;

public class MainActivity extends AppCompatActivity {
    private BookDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new BookDbHelper(this);
        displayDatabaseInfo();
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_BOOK_NAME,
                BookEntry.COLUMN_PUBLISHER,
                BookEntry.COLUMN_STOCK,

        };

        Cursor cursor = db.query(BookEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        // Always close the cursor when you're done reading from it. This releases all its
        // resources and makes it invalid.
        cursor.close();
    }


    private void insertInventory() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_BOOK_NAME, "Introduction to Java");
        values.put(BookEntry.COLUMN_PUBLISHER, "Pearson");
        values.put(BookEntry.COLUMN_STOCK, BookEntry.COLUMN_INSTOCK);
        values.put(BookEntry.COLUMN_PRICE, BookEntry.COLUMN_PRICEINUSD);
        long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);
    }
}