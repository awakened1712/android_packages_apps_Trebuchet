/*
 * Copyright (C) 2021 The Android Open Source Project
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

package com.android.launcher3.search;

import android.app.search.SearchTarget;
import android.app.search.SearchTargetEvent;
import android.content.Context;
import android.view.View;

import java.util.List;
import java.util.function.Consumer;

/**
 * An interface for supporting dynamic search results
 */
public interface SearchTargetHandler extends View.OnClickListener, View.OnLongClickListener {

    /**
     * Update view using values from {@link SearchTarget}
     */
    default void apply(SearchTarget parentTarget, List<SearchTarget> children) { }

    /**
     * Handle IME quick select event. returns whether event was handled.
     */
    default boolean quickSelect() {
        return false;
    }

    default void notifyEvent(Context context, String id, int eventType) {
        SearchTargetEvent.Builder builder = new SearchTargetEvent.Builder(id, eventType);
        SearchSessionTracker.getInstance(context).notifyEvent(builder.build());
    }
}
