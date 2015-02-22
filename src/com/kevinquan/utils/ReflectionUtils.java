/*
 * Copyright 2014 Kevin Quan (kevin.quan@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kevinquan.utils;

import java.lang.reflect.Field;

import com.kevinquan.android.stubs.Log;
import com.kevinquan.android.stubs.TextUtils;

/**
 * A collection of utilities using reflection
 * @author Kevin Quan (kevin.quan@gmail.com)
 *
 */
public class ReflectionUtils {

    /**
     * Retrieve an inaccessible field (i.e., private, protected, default visibility) from a class.
     * @param object The object to retrieve the field from
     * @param fieldName The name of the field
     * @return The contents of the field
     */
    public static Object getHiddenField(Object object, String fieldName) {
        if (TextUtils.isEmpty(fieldName)) {
            return null;
        }
        Class<? extends Object> objectClass = object.getClass();
        try {
            Field hiddenField = null;
            boolean terminate = false;
            while (!terminate) {
                try {
                    // Will throw exception if not found
                    hiddenField = objectClass.getDeclaredField(fieldName);
                    terminate = true;
                } catch (NoSuchFieldException nsfe) {
                    if (objectClass.getSuperclass() != null) {
                        // Check in parent class
                        objectClass = objectClass.getSuperclass();
                    } else {
                        // Terminate condition
                        terminate = true;
                    }
                }
            }
            if (hiddenField != null) {
                hiddenField.setAccessible(true);
                return hiddenField.get(object);
            }
        } catch (Exception e) {
            Log.e(TAG, "Could not retrieve hidden field: "+fieldName+" in object of class "+object.getClass() +" or its parent classes", e);
        }
        return null;
    }

    private static final String TAG = ReflectionUtils.class.getSimpleName();
}
