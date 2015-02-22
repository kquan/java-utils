package com.kevinquan.android.stubs;

import java.lang.reflect.Method;

import com.kevinquan.utils.StringUtils;

public class TextUtils extends StringUtils {

    public static final boolean equals(CharSequence first, CharSequence second) {
    	if (!HAS_ANDROID) {
	        return equals_internal(first, second);
    	} else {
    		Method logMethod = null;
        	try {
        		logMethod = Class.forName(ANDROID_TEXT_UTILS_CLASS).getMethod("equals", CharSequence.class, CharSequence.class);
        	} catch (ClassNotFoundException cnfe) {
        		System.err.println("Attempted to retrieve Android TextUtils equals method when Android TextUtils class doesn't exist");
        		return equals_internal(first, second);
        	} catch (NoSuchMethodException nsme) {
        		System.err.println("Attempted to retrieve Android TextUtils equals method when it does not exist");
        		return equals_internal(first, second);
        	}
        	if (logMethod == null) {
        		System.err.println("Could not find equals method with CharSequence parameters in Android TextUtils class");
        		return equals_internal(first, second);
        	}
        	try {
        		return (Boolean)logMethod.invoke(null, first, second);
        	} catch (Exception e) {
        		System.err.println("Could not invoke equals method");
        		return equals_internal(first, second);
        	}
    	}
    }

    protected static final boolean equals_internal(CharSequence first, CharSequence second) {
    	boolean firstEmpty = TextUtils.isEmpty(first);
    	boolean secondEmpty = TextUtils.isEmpty(second);
    	if (firstEmpty && secondEmpty) {
    		return true;
    	}
    	if ((firstEmpty && !secondEmpty) || (!firstEmpty && secondEmpty)) {
    		return false;
    	}
    	return first.equals(second);
    }

    public static final boolean isEmpty(CharSequence string) {
    	if (!HAS_ANDROID) {
	        return isEmpty_internal(string);
    	} else {
    		Method logMethod = null;
        	try {
        		logMethod = Class.forName(ANDROID_TEXT_UTILS_CLASS).getMethod("isEmpty", CharSequence.class);
        	} catch (ClassNotFoundException cnfe) {
        		System.err.println("Attempted to retrieve Android TextUtils isEmpty method when Android TextUtils class doesn't exist");
        		return isEmpty_internal(string);
        	} catch (NoSuchMethodException nsme) {
        		System.err.println("Attempted to retrieve Android TextUtils isEmpty method when it does not exist");
        		return isEmpty_internal(string);
        	}
        	if (logMethod == null) {
        		System.err.println("Could not find isEmpty method with CharSequence parameters in Android TextUtils class");
        		return isEmpty_internal(string);
        	}
        	try {
        		return (Boolean)logMethod.invoke(null, string);
        	} catch (Exception e) {
        		System.err.println("Could not invoke isEmpty method");
        		return isEmpty_internal(string);
        	}
    	}
    }

    protected static final boolean isEmpty_internal(CharSequence string) {
        if (string == null || string.length() == 0) {
            return true;
        }
        if (string instanceof String && ((String)string).trim().length() == 0) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unused")
    private static final String TAG = TextUtils.class.getSimpleName();

	protected static final String ANDROID_TEXT_UTILS_CLASS = "android.text.TextUtils";

    protected static boolean HAS_ANDROID = false;

    static {
	    try {
	        Class.forName(ANDROID_TEXT_UTILS_CLASS);
	        HAS_ANDROID = true;
	    } catch (ClassNotFoundException squelched) {}
	}
}
