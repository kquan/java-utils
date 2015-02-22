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

import java.io.UnsupportedEncodingException;

public class StringUtils {

	/**
	 * Determines the length of a string taking into account multi-byte character sets.
	 * @param theString The string to check
	 * @return The length of the string
	 */
	public static int getLength(String theString) {
		if (theString == null) {
			return 0;
		}
		byte[] utf8 = null;
		try {
			utf8 = theString.getBytes(UTF8_LITERAL);
		} catch (UnsupportedEncodingException uee) {
			// This should never happen as UTF-8 is a standard encoding.
			return theString.length();
		}
		int count = 0;
		for (int i = 0; i < utf8.length; i++) {
			// 0xc0 = 1100 0000
			// 0x80 = 1000 0000
			if ((utf8[i] & 0xc0) != 0x80) {
				count++;
			}
		}
		return count;
	}

	@SuppressWarnings("unused")
	private static final String TAG = StringUtils.class.getSimpleName();
	public static final String UTF8_LITERAL = "UTF-8";

	public static final String SPACE_LITERAL = "\u0020";

    public static final String LINE_BREAK = System.getProperty("line.separator");

}
