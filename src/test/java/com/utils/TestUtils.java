package com.utils;

import java.util.ArrayList;

import com.constants.HttpVerbs;
import com.playerPOJO.IJson;
import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestUtils {
	Response response;
	ArrayList<Header> headerList = new ArrayList<Header>();


	public Response request(String endpoint, HttpVerbs httpverbs, IJson body, Header... headers) {
		for (Header myheader : headers) {
			headerList.add(myheader);
		}
		if (httpverbs == HttpVerbs.POST) {
			return given().when().headers(new Headers(headerList)).and().body(body.toJson()).and().post(endpoint);
		} else if (httpverbs == HttpVerbs.PUT) {
			return given().when().headers(new Headers(headerList)).and().body(body.toJson()).and().put(endpoint);
		} else
			return null;
	}

	public Response request(String endpoint, HttpVerbs httpverbs, Header... headers) {
		for (Header myheader : headers) {
			headerList.add(myheader);
		}
		if (httpverbs == HttpVerbs.GET) {
			return given().when().headers(new Headers(headerList)).and().get(endpoint);
		} else if (httpverbs == HttpVerbs.DELETE) {
			return given().when().headers(new Headers(headerList)).and().delete(endpoint);
		} else
			return null;
	}

	public void clearArrayList() {
		headerList.removeAll(headerList);
	}

}
