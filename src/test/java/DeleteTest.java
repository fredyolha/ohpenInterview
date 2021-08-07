import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends UtilClass{

    static int issueId;
    @BeforeAll
    public static void createSomeIssue() throws JSONException {

        Response response = given().auth().oauth2("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 ")
                .body(getTitleBody("RandomName"))
                .when().post(baseUrl + "repos/fredyolha/ohpenInterview/issues");
        issueId = response.path("id");
        System.out.println(issueId);
    }


    /**
     * This method in the end doesn't work at all
     * Would use issue from the Before Class
     * https://docs.gitlab.com/ee/api/issues.html
     * id parameter would be project ID
     * iid parameter is issue ID obtained in the beforeAll class
     */
    @Test
    public void testDeleteTheIssue(){
       given().auth().oauth2("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")
                .when().delete("https://api.github.com/projects/<id>/<iid>");
    }
}
