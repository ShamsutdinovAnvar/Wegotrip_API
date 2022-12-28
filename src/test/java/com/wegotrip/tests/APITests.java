package com.wegotrip.tests;

import com.wegotrip.models.lombok.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.wegotrip.specs.Specs.*;
import static com.wegotrip.testData.UserData.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class APITests {

    @Test
    @DisplayName("Check cities")
    void getCitiesTest() {

        given()
                .spec(citiesRequestSpec)
                .when()
                .get()
                .then()
                .spec(citiesResponseSpec)
                .body("data.results.id", hasItems(1, 2, 3))
                .body("data.results[0].name", is("Paris"));

    }

    @Test
    @DisplayName("Check product_id")
    void getProductIdTest() {

        given()
                .spec(ProductIdSpec)
                .param("product_id", "100")
                .when()
                .get()
                .then()
                .spec(ProductIdResponseSpec)
                .body("data.results[0].id", is(100))
                .body("data.results[0].title", is("Paris: The Spirit of Latin Quarter"));

    }

    @Test
    @DisplayName("Check authorization with login/password")
    void loginLombokModelTest() {
        LoginRequestLombokModel body = new LoginRequestLombokModel();
        body.setUsername(username);
        body.setPassword(password);

        LoginResponseLombokModel response =
                given()
                        .spec(loginRequestSpec)
                        .body(body)
                        .when()
                        .post()
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponseLombokModel.class);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getType()).isEqualTo("Token");
    }

    @Test
    @DisplayName("Check leaving  feedback")
    void leaveFeedbackLombokModelTest() {
        FeedbackRequestLombokModel body = new FeedbackRequestLombokModel();
        body.setQuestID(questID);
        body.setRate(5);
        body.setText("The best audio guide");

        given()
                .spec(feedbackRequestSpec)
                .header(auth, token)
                .body(body)
                .when()
                .post()
                .then()
                .spec(ProductIdResponseSpec);
    }

    @Test
    @DisplayName("Check availability by day")
    void daysAvailableTest() {
        DaysAvailableRequestModel body = new DaysAvailableRequestModel();
        body.setStart(startDay);
        body.setEnd(endDay);

        DaysAvailableResponseModel response = given()
                .spec(daysAvailableRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(daysAvailableResponseSpec)
                .extract().as(DaysAvailableResponseModel.class);

        assertThat(response.getData().get(0).getDate().getYear()).isEqualTo(2023);
        assertThat(response.getData().get(0).getDate().getMonth()).isEqualTo(1);

    }

    @Test
    @DisplayName("Check slug")
    void resolveURLTest() {
        ResolveURLRequestModel body = new ResolveURLRequestModel();
        body.setSlug("russkij-muzej-glavnoe-o-shedevrah");
        body.setCheckout(true);

        ResolveURLResponseModel response = given()
                .spec(resolveURLRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(resolveURLResponseSpec)
                .extract().as(ResolveURLResponseModel.class);

        assertThat(response.getData().getUrl()).isNotNull();
    }

    @Test
    @DisplayName("Check user deletion")
    void deleteUserTest() {

        given()
                .spec(deleteUserRequestSpec)
                .header(auth, token)
                .when()
                .delete()
                .then()
                .spec(deleteUserResponseSpec);
    }


}
