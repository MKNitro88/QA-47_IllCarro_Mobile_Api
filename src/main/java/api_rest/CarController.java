package api_rest;

import dto.CarDto;
import dto.RegistrationBodyDto;
import dto.TokenDto;
import interfaces.BaseApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import static utils.PropertiesReader.getProperty;
import static io.restassured.RestAssured.given;
public class CarController implements BaseApi {
    public TokenDto tokenDto;

    @BeforeSuite
    public void login() {
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username(getProperty("login.properties", "email"))
                .password(getProperty("login.properties", "password"))
                .build();
        tokenDto = given().body(user)
                .contentType("application/json")
                .when()
                .post(BASE_URL + LOGIN_URL)
                .thenReturn()
                .getBody()
                .as(TokenDto.class);
        System.out.println("Token: " + tokenDto.getAccessToken());
    }
    public Response addNewCar(CarDto car){
        return given()
                .header("Authorization", "Bearer " + tokenDto.getAccessToken())
                .body(car)
                .contentType("application/json")
                .when()
                .post(BASE_URL + ADD_NEW_CAR_URL)
                .thenReturn();
    }



}

