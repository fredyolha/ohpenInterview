import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilClass {

    public static String baseUrl;
    public static String authToken;
    public static String orgUser;

    @BeforeEach
    public void configureFramework(){
            try (InputStream input = UtilClass.class.getResourceAsStream("config.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                baseUrl = prop.getProperty("baseUrl");
                authToken = prop.getProperty("authToken");
                orgUser = prop.getProperty("orgUser");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    public static String getTitleBody(String nameOfTheIssue) throws JSONException {
        return new JSONObject()
                .put("title", nameOfTheIssue)
                .toString();
    }
}
