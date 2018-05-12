# testhelpers
(Still a lot of things to add, but it should cover now the basic of testing doPost)

The idea here is to test directly the doPost, doGet, doPut, doDelete of Java Servlets.


## Why?

- Although, you still have to mock (I used PowerMock) some of the services and DAO classes, I just think (in my opinion) that the less you perform mocking, the more powerful is the test
- Goal here is to simulate testing from the point of entry of the HTTP call - thus you can test input paramters, your server validations and your return to the HTTP caller
-  If done and used right, you can properly test your application's security from the web layer

## Usage:
Example test code:
```java
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
```

## Future
- Need to add more testers for other MVC frameworks such as Spring, Sling, Struts, Stripes
- Need to complete all HTTP Servlet Request/Response setting of variables
- Maybe add also the testing of Web Services such as REST / SOAP?
- Maybe add default testing of parameters for SQL Injection, XSS 

## Other notes:
- Of course I used Junit here!