package com.example.android.abndp8bookinventory.data;

import android.provider.BaseColumns;

import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * Created by Efehan on 3.6.2018.
 */

public final class BookContract {

    private BookContract() {


    }

    public static final class BookEntry implements BaseColumns {
        public final static String _ID = BaseColumns._ID;
        public final static String TABLE_NAME = "books";
        public final static String COLUMN_BOOK_NAME = "name";
        public final static String COLUMN_PUBLISHER = "publisher";
        public final static String COLUMN_STOCK = "stock";
        public final static int COLUMN_INSTOCK = 1;
        public final static int COLUMN_NOSTOCK = 0;
        public final static String COLUMN_PRICE = "price";
        public final static int COLUMN_PRICEINUSD = 40;


    }
}
