package com.tinysquare.constants;

public class Constants {

	public interface User {

		public final static int USER_CATEGORY_NORMAL = 1;

		public final static int USER_CATEGORY_SHOP = 2;
	}

	public interface Status {

		public final static int NORMAL = 0;

		public final static int INVALID = 1;

		public final static int DELETE = 2;
	}

	public interface Params {

		public final static String SIGN = "sign";

		public final static String TOKEN = "token";
	}

	public interface Encoding {

		public final static String UTF8 = "UTF-8";
	}
}
