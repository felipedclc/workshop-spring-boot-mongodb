package com.felipedclc.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8"); // UFT-8 PADRAO WEB
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
