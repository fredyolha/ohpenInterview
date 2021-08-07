
import org.apache.http.HttpStatus;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class GetTests extends UtilClass{
    private String userEndpoint = "user";
    @Test
    public void testTokenWorks(){
        given().auth().oauth2(authToken)
                .when().get(baseUrl + userEndpoint)
                .then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldFailBasicLoginWithInvalidCredentials(){
        given().auth().basic("DOESNT_EXIST_USER","DOESNT_EXIST_PASS")
                .when().get(baseUrl + userEndpoint)
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
