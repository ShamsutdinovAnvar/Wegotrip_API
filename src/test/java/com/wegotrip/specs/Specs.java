package com.wegotrip.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.wegotrip.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class Specs {
    public static RequestSpecification checkProductsSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/products/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification checkProductsResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification citiesRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/v2/cities/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification citiesResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("data.count", notNullValue())
            .build();

    public static RequestSpecification feedbackRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/v2/feedback/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification feedbackResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("id", notNullValue())
            .build();

    public static RequestSpecification loginRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/login/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("token", notNullValue())
            .build();

    public static RequestSpecification ProductIdSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/v2/products/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification ProductIdResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification daysAvailableRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/v2/products/698/days/") // Русский музей//
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification daysAvailableResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification resolveURLRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/v2/products/resolve/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification resolveURLResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification deleteUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://wegotrip.com")
            .basePath("/api/v2/users/")
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification deleteUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(202)
            .build();
}
