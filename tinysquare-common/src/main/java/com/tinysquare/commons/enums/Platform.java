package com.tinysquare.commons.enums;

import com.tinysquare.tools.DataTools;

public enum Platform {

	ALL(Byte.valueOf("0")), ANDROID(Byte.valueOf("1")), IOS(Byte.valueOf("2"));

	private Byte value;

	private Platform(Byte value) {
		this.value = value;
	}

	public static Byte getValue(String platform) {
		if (!DataTools.isEmpty(platform)) {
			Platform pf = Platform.valueOf(platform.toUpperCase());
			switch (pf) {
			case ALL:
				return ALL.value;
			case ANDROID:
				return ANDROID.value;
			case IOS:
				return IOS.value;
			}
		}
		return null;
	}

}
