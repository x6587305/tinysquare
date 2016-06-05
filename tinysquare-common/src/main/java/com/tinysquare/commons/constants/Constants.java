package com.tinysquare.commons.constants;

public class Constants {

	public final static String SIGN_SECRET = "jy00735758";

	public interface App {

		public final static String VERSION = "1.0.0";

		public final static int APP_STATUS_NONE = 0;

		public final static int APP_STATUS_UPDATE = 1;

		public final static int APP_STATUS_MUST_UPDATE = 2;
		
		public final static String IMG_URL = "http://source.tiny-square.com/";
		
	}

	public interface User {

		public final static byte USER_CATEGORY_NORMAL = 1;

		public final static byte USER_CATEGORY_SHOP = 2;
	}

	public interface Status {

		public final static byte NORMAL = 0;

		public final static byte INVALID = 1;

		public final static byte DELETE = 2;

		public final static byte HISTORY = 3;
	}

	public interface Params {

		public final static String SIGN = "sign";

		public final static String TOKEN = "token";

		public final static String PLATFORM = "platform";

		public final static String VERSION = "version";
	}

	public interface Encoding {

		public final static String UTF8 = "UTF-8";
	}

	public interface SecretKey {

		public final static String DES = "DES";
	}

	public interface Response {

		public final static int SUCCESS = 200;

		public final static int ERROR = 500;
	}

	public interface Boolean {

		public final static byte FALSE = 0;

		public final static byte TRUE = 1;

	}

	public interface Coupon {

		public final static byte UNUSE = 0;

		public final static byte USED = 1;
	}

	public interface Message {

		public final static byte UNREAD = 0;

		public final static byte READ = 1;
	}

	public interface News {
		
		public final static String SHARE_URL = "http://www.tinysquareapi.com/tinysquare-api/newsFront/detail/";
	}
}
