package com.tests;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.constants.HttpVerbs;
import com.utils.TestUtils;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

public class TestScript {

	private JsonPath response;
	private TestUtils helper = new TestUtils();
	private int roleCount;
	private int foreignPlayerCount = 0;
	private int keeperNumber;

	@BeforeClass(description = "Intializing the baseURL", alwaysRun = true)
	public final void Intialization() {
		baseURI = "Base Url";
	}

	@Test(description = "Verify that Team has only 4 Foreign Playes !!", groups = {"Sanity","Smoke"}, priority = 1)
	public void test1() {
		response = helper.request("endpoint", HttpVerbs.GET, new Header("Content-type", "application/json")).then()
				.log().all().statusCode(200).and().extract().jsonPath();
		roleCount=response.getInt("player.role");
		for (int i = 0; i < roleCount; i++) {
			if (response.getString("player["+i+"].country") != "India") {
				foreignPlayerCount++;
			}
		}

		Assert.assertEquals(foreignPlayerCount, 4);
	}
	@Test(description = "Verify that Team has atleast one wicket keeper !!", groups = {"Sanity","Smoke"}, priority = 2)
	public void test2() {
		response = helper.request("endpoint", HttpVerbs.GET, new Header("Content-type", "application/json")).then()
				.log().all().statusCode(200).and().extract().jsonPath();
		roleCount=response.getInt("player.role");
		for (int i = 0; i < roleCount; i++) {
			if (response.getString("player["+i+"].role") == "Wicket-keeper") {
				keeperNumber = i;
				System.out.println("Wicket-keeper found at number = "+(keeperNumber+1));
				break;
			}
		}

		Assert.assertEquals(response.getString("player["+keeperNumber+"].role"), "Wicket-keeper");
	}

}
