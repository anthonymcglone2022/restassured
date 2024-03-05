package data;

import java.util.HashMap;
import java.util.Map;

public class TestData {
	
	/**
	 * TODO Consider moving this to a JSON file or more-standard input format
	 */
	
	public static String code = "code";
	public static String inuse = "inuse";
	public static String district = "district";
	
    public static Map<String, String> createPostCode = new HashMap<String, String>() {{
        put(code, "W5 1AQp");
        put(inuse, "Yes");
        put(district, "Ealing");
    }};	

    public static Map<String, String> formatPostCode = new HashMap<String, String>() {{
        put("w51*at", "W5 1AT");
    }};
}
