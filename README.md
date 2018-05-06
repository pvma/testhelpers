# testhelpers
(Not yet complete! Work In Progress, but you'll get the idea)

The idea here is to test directly the doPost and doGet of Java Servlets

## Why?

- Although, you still have to mock (I used PowerMock) some of the services and DAO classes, I just think (in my opinion) that the less mocking the, the more powerful is the test
- Goal here is to simulate testing from the point of entry of the HTTP call - thus you can test input paramters, your server validations and your return to the HTTP caller
-  If done and used right, you can properly test your applications security from the web layer

## Usage:
Example test code:
```java
@Test
	public void test_01() {
		DoPostTest testObj = new DoPostTest();
		testObj.addRequestAttribute("param1", "value1");

		ExampleServletClass servlet = new ExampleServletClass();
		testObj.addServlet(servlet);

		ExampleDaoClass dao = PowerMockito.mock(ExampleDaoClass.class);
		testObj.addObjectToServletAsMocked("exampleDaoClass", dao);

		PowerMockito.when(dao.getName(1)).thenReturn("test");
		
		testObj.addRequestAttribute("user", "Paul");
		testObj.addRequestParameter("user", "Paul");

		testObj.triggerServletDoPost();

		String data = testObj.getWriterData();
		System.out.println(data);

	}
```
