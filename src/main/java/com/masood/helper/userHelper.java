package com.masood.helper;

import java.util.UUID;

public class userHelper {
	
	public static UUID parseUUID(String id) {
		return UUID.fromString(id);
	}

}
