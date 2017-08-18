package com.htc.eleven.contentproviderwriter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    private static final String NAME = "mydata.db3";
    private static final String columnName = "name";
    private SQLiteDatabase database;

    public static final Uri URI =  Uri.parse("content://com.htc.eleven_xiang");
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        database.insert(columnName,"_id",values);
//        database.close();
        return null;
    }

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase(NAME, Context.MODE_PRIVATE, null);
        database.execSQL("create table IF NOT EXISTS name(_idI INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)");
        // TODO: Implement this to initialize your content provider on startup.
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor c = database.query(columnName,null,null,null,null,null,null);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
