import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class PostTest extends UtilClass {

    @Test
    public void testCreateIssue() throws JSONException {
        given().auth().oauth2(authToken)
                .body(getTitleBody("HELLO WORLD!"))
                .when().post(baseUrl + "repos/fredyolha/ohpenInterview/issues")
                .then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }
}
