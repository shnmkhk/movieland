package com.rabbit.mdb.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONUtils {
	private static Gson gson = new GsonBuilder().create();
	public static Gson gson() {
		return GSONUtils.gson;
	}
}
