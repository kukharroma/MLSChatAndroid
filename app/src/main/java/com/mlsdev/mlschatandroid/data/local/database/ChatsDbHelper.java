/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mlsdev.mlschatandroid.data.local.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChatsDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Chats.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ChatsPersistenceContract.ChatEntry.TABLE_NAME + " (" +
                    ChatsPersistenceContract.ChatEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    ChatsPersistenceContract.ChatEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    ChatsPersistenceContract.ChatEntry.COLUMN_NAME_MESSAGE + TEXT_TYPE + COMMA_SEP +
                    ChatsPersistenceContract.ChatEntry.COLUMN_NAME_CREATED_TIME + TEXT_TYPE + COMMA_SEP +
                    ChatsPersistenceContract.ChatEntry.COLUMN_NAME_SENDER_ID + TEXT_TYPE + COMMA_SEP +
                    ChatsPersistenceContract.ChatEntry.COLUMN_NAME_UPDATED_TIME + TEXT_TYPE +
                    " )";

    public ChatsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
