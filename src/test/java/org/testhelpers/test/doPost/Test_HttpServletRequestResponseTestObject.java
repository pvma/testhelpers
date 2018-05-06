package org.testhelpers.test.doPost;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.testhelpers.test.doPost.example.ExampleDaoClass;
import org.testhelpers.test.doPost.example.ExampleServletClass;

public class Test_HttpServletRequestResponseTestObject {
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

}
