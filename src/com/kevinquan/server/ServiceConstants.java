/*
 * Copyright 2015 Kevin Quan (kevin.quan@gmail.com)
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
package com.kevinquan.server;

import com.kevinquan.constants.MimeTypes;
import com.kevinquan.utils.StringUtils;

public interface ServiceConstants {

    public static final String CONTENT_TYPE_TEXT = MimeTypes.TEXT_PLAIN;
    public static final String CONTENT_TYPE_TEXT_UTF8 = MimeTypes.TEXT_PLAIN+"; charset="+StringUtils.UTF8_LITERAL;
    public static final String CONTENT_TYPE_JSON = MimeTypes.APPLICATION_JSON;
    public static final String CONTENT_TYPE_JSON_UTF8 = MimeTypes.APPLICATION_JSON+"; charset="+StringUtils.UTF8_LITERAL;
    public static final String CONTENT_TYPE_FORM_URLENCODED_UTF8 = MimeTypes.APPLICATION_FORM_URLENCODED+"; charset="+StringUtils.UTF8_LITERAL;

}
