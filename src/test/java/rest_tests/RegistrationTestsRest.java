package rest_tests;

import api_rest.AuthenticationController;
import dto.ErrorMessageDtoString;
import dto.RegistrationBodyDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegistrationTestsRest extends
        AuthenticationController {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("Aaaa432!")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(), 200);
    }

    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username(i + "gmail.com")
                .password("Aaaa432!")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString().contains("must be a well-formed"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_WOPassword() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("must not be blank"));
        softAssert.assertAll();
    }
@Test
public void registrationNegativeTest_PasswordShort() {
    int i = new Random().nextInt(1000);
    RegistrationBodyDto user = RegistrationBodyDto.builder()
            .username("testing" + i + "@gmail.com")
            .password("Abc!")
            .firstName("testName")
            .lastName("testLastName")
            .build();
    Response response = registrationLogin(user, REGISTRATION_URL);
    softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
    ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
    softAssert.assertEquals(errorMessageDtoString.getError(),
            "Bad Request", "validate error");
    System.out.println(errorMessageDtoString.getMessage().toString());
    softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
            .contains("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]"));
    softAssert.assertAll();
}
    @Test
    public void registrationNegativeTest_PasswordLowercase() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("abc12345!")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_PasswordUppercase() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("ABC12345!")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_PasswordWONumbers() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("Abcccccc!")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_PasswordWOSym() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("Abc123456")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_PasswordInvalidLang() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("Aכככ12345!")
                .firstName("testName")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_WOName() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("Aaaa432!")
                .lastName("testLastName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("must not be blank"));
        softAssert.assertAll();
    }
    @Test
    public void registrationNegativeTest_WOLastName() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("Aaaa432!")
                .firstName("testName")
                .build();
        Response response = registrationLogin(user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessageDtoString = response.getBody().as(ErrorMessageDtoString.class);
        softAssert.assertEquals(errorMessageDtoString.getError(),
                "Bad Request", "validate error");
        System.out.println(errorMessageDtoString.getMessage().toString());
        softAssert.assertTrue(errorMessageDtoString.getMessage().toString()
                .contains("must not be blank"));
        softAssert.assertAll();
    }
}
