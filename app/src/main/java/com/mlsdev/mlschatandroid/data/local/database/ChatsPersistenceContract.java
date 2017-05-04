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

import android.provider.BaseColumns;


public final class ChatsPersistenceContract {

    private ChatsPersistenceContract() {}

    public static abstract class ChatEntry implements BaseColumns {
        public static final String TABLE_NAME = "chat";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_MESSAGE = "message";
        public static final String COLUMN_NAME_SENDER_ID = "sender_id";
        public static final String COLUMN_NAME_CREATED_TIME = "created_at";
        public static final String COLUMN_NAME_UPDATED_TIME = "updated_at";
    }
}
