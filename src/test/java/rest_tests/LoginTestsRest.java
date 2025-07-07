package rest_tests;

import api_rest.AuthenticationController;
import dto.RegistrationBodyDto;
import interfaces.BaseApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class LoginTestsRest extends
        AuthenticationController {
    SoftAssert softAssert = new SoftAssert();
    RegistrationBodyDto user;

    @BeforeMethod
    public void registrationUser(){
        int i = new Random().nextInt(1000);
        user = RegistrationBodyDto.builder()
                .username("testing" + i + "@gmail.com")
                .password("testPassword123!")
                .firstName("Test" + i)
                .lastName("User" + i)
                .build();
        System.out.println("registration resulte --> " + registrationLogin(user,REGISTRATION_URL).getStatusCode());
        registrationLogin(user, BaseApi.REGISTRATION_URL);
    }
    @Test
    public void loginPositiveTest(){
        Assert.assertEquals(registrationLogin(user,LOGIN_URL).getStatusCode(),200);

    }
    @Test
    public void loginNegativeTest_WrongEmail_unRegUser(){
        user.setUsername("unRegEmail321@mail.ru");
        Assert.assertEquals(registrationLogin(user,LOGIN_URL).getStatusCode(),401);

    }
    @Test
    public void loginNegativeTest_WOEmail(){
        user.setUsername("");
        Assert.assertEquals(registrationLogin(user,LOGIN_URL).getStatusCode(),401);

    }
    @Test
    public void loginNegativeTest_WOPassword(){
        user.setUsername("test_mkii@gmail.com");
        user.setPassword("");
        Assert.assertEquals(registrationLogin(user,LOGIN_URL).getStatusCode(),401);

    }



}
