package org.testhelpers.test.doPost;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.testhelpers.test.doPost.example.ExampleDaoClass;
import org.testhelpers.test.doPost.example.ExampleServletClass;

public class Test_ExampleServletClass {
	@Test
	public void test_different_values() {

		// Must do: Initialize type of test
		DoPostTest testObj = new DoPostTest();
		ExampleServletClass servlet = new ExampleServletClass();
		testObj.addServlet(servlet);

		// Initialize test of param
		testObj.addRequestParameter("user", "Its my user!");

		// Initialize testing of Servlet Context
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("test", "success");
		testObj.setRequestHttpSessionServletContextInitParameter(initParameters);

		// Initialize mock of Service / DAO
		ExampleDaoClass dao = PowerMockito.mock(ExampleDaoClass.class);
		testObj.addObjectToServletAsMocked("exampleDaoClass", dao);
		PowerMockito.when(dao.getName(1)).thenReturn("Its my name!");

		// Trigger the doPost
		testObj.doTrigger();

		// testing something in Servlet Context
		String result = testObj.getRequest().getSession().getServletContext().getInitParameter("test");
		assertEquals(result, "success");

		// testing the cookie response
		List<Cookie> cookieResponse = testObj.getCookiesInHttpResponse();
		assertEquals(cookieResponse.get(0).getName(), "CookieName");

		String data = testObj.getWriterData();
		// Testing response of service
		assertTrue(data.contains("Its my name!"));

		// Testing response of param
		assertTrue(data.contains("Its my user!"));
	}

	@Test
	public void test_exception() {
		DoPostTest testObj = new DoPostTest();
		testObj.addRequestAttribute("param1", "value1");

		ExampleServletClass servlet = new ExampleServletClass();
		testObj.addServlet(servlet);

		ExampleDaoClass dao = PowerMockito.mock(ExampleDaoClass.class);
		testObj.addObjectToServletAsMocked("exampleDaoClass", dao);

		PowerMockito.when(dao.getName(1)).thenReturn("test");

		testObj.addRequestAttribute("user", "Paul");
		testObj.addRequestParameter("user", "Paul");

		testObj.doTrigger();

		List<Cookie> cookieResponse = testObj.getCookiesInHttpResponse();

		assertEquals(cookieResponse.get(0).getName(), "CookieName");

	}

}
