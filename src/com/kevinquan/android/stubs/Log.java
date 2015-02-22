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
package com.kevinquan.android.stubs;

import java.lang.reflect.Method;

/**
 * This is an stub for the Android Log interface, which is useful when copying over Android util classes
 * @author Kevin Quan (kevin.quan@gmail.com)
 *
 */

public class Log {

	public static void d(String tag, String message) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("d", tag, message);
        } else {
        	System.out.println("[D] "+tag+": "+message);
        }
    }

	public static void e(String tag, String message) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("e", tag, message);
        } else {
        	System.err.println("[E] "+tag+": "+message);
        }
    }
	public static void e(String tag, String message, Throwable throwable) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("e", tag, message, throwable);
        } else {
        	System.err.println("[E] "+tag+": "+message);
        	throwable.printStackTrace(System.err);
        }
    }

    public static void i(String tag, String message) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("i", tag, message);
        } else {
        	System.out.println("[I] "+tag+": "+message);
        }
    }

    protected static void logAndroid(String methodName, String tag, String message) {
    	Method logMethod = null;
    	try {
    		logMethod = Class.forName(ANDROID_LOG_CLASS).getMethod(methodName, String.class, String.class);
    	} catch (ClassNotFoundException cnfe) {
    		System.err.println("Attempted to retrieve Android Log class method "+methodName+" when Android Log class doesn't exist");
    		return;
    	} catch (NoSuchMethodException nsme) {
    		System.err.println("Attempted to retrieve Android Log class method "+methodName+" when it does not exist");
    		return;
    	}
    	if (logMethod == null) {
    		System.err.println("Could not find method "+methodName+" with tag and message parameters in Android Log class");
    		return;
    	}
    	try {
    		logMethod.invoke(null, tag, message);
    	} catch (Exception e) {
    		System.err.println("Could not invoke method: "+methodName);
    	}
    }

    protected static void logAndroid(String methodName, String tag, String message, Throwable t) {
    	Method logMethod = null;
    	try {
    		logMethod = Class.forName(ANDROID_LOG_CLASS).getMethod(methodName, String.class, String.class, Throwable.class);
    	} catch (ClassNotFoundException cnfe) {
    		System.err.println("Attempted to retrieve Android Log class method "+methodName+" when Android Log class doesn't exist");
    		return;
    	} catch (NoSuchMethodException nsme) {
    		System.err.println("Attempted to retrieve Android Log class method "+methodName+" when it does not exist");
    		return;
    	}
    	if (logMethod == null) {
    		System.err.println("Could not find method "+methodName+" with tag and message parameters in Android Log class");
    		return;
    	}
    	try {
    		logMethod.invoke(null, tag, message, t);
    	} catch (Exception e) {
    		System.err.println("Could not invoke method: "+methodName);
    	}
    }

    public static void v(String tag, String message) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("v", tag, message);
        } else {
        	System.out.println("[V] "+tag+": "+message);
        }
    }

    public static void w(String tag, String message) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("w", tag, message);
        } else {
        	System.err.println("[W] "+tag+": "+message);
        }
    }

    public static void w(String tag, String message, Throwable throwable) {
        if (tag == null) {
            tag = "";
        }
        if (HAS_ANDROID) {
        	logAndroid("w", tag, message, throwable);
        } else {
        	System.err.println("[W] "+tag+": "+message);
        	throwable.printStackTrace(System.err);
        }
    }

    protected static final String ANDROID_LOG_CLASS = "android.util.Log";

    protected static boolean HAS_ANDROID = false;

    static {
	    try {
	        Class.forName(ANDROID_LOG_CLASS);
	        HAS_ANDROID = true;
	    } catch (ClassNotFoundException squelched) {}
	}

    @SuppressWarnings("unused")
    private static final String TAG = Log.class.getSimpleName();
}
