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

public class Test_HttpServletRequestResponseTestObject {
	@Test
	public void test_cookie() {
		DoPostTest testObj = new DoPostTest();
		testObj.addRequestAttribute("param1", "value1");

		ExampleServletClass servlet = new ExampleServletClass();
		testObj.addServlet(servlet);

		ExampleDaoClass dao = PowerMockito.mock(ExampleDaoClass.class);
		testObj.addObjectToServletAsMocked("exampleDaoClass", dao);

		PowerMockito.when(dao.getName(1)).thenReturn("test");

		testObj.addRequestAttribute("user", "Paul");
		testObj.addRequestParameter("user", "Paul");

		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("test", "success");
		testObj.setRequestHttpSessionServletContextInitParameter(initParameters);
		testObj.doTrigger();

		String result = testObj.getRequest().getSession().getServletContext().getInitParameter("test");

		assertEquals(result, "success");

		List<Cookie> cookieResponse = testObj.getCookiesInHttpResponse();

		assertEquals(cookieResponse.get(0).getName(), "CookieName");

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
