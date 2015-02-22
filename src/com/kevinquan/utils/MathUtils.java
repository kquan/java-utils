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


/**
 * Some commonly used math functions
 * 
 * @author Kevin Quan (kevin.quan@gmail.com)
 *
 */
public class MathUtils {

    @SuppressWarnings("unused")
    private static final String TAG = MathUtils.class.getSimpleName();

    /**
     * Round a decimal to the provided number of places
     * @param initialValue The value to round
     * @param decimalPlaces The number of decimal places
     * @return The rounded number
     */
    public static double round(double initialValue, int decimalPlaces) {
        double multiplier = Math.pow(10, decimalPlaces);
        return (int)Math.round(multiplier*initialValue)/multiplier;
    }
    
    /**
     * Round a decimal to the provided number of places
     * @param initialValue The value to round
     * @param decimalPlaces The number of decimal places
     * @return The rounded number
     */
    public static float round(float initialValue, int decimalPlaces) {
        float multiplier = (float)Math.pow(10, decimalPlaces);
        return (int)Math.round(multiplier*initialValue)/multiplier;
    }
}
