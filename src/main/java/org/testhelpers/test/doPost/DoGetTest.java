package org.testhelpers.test.doPost;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoGetTest extends DoTestAbstract {

	public DoGetTest() {
		super();
	}

	public Object doTrigger() {
		try {
			Method method = servletInstance.getClass().getDeclaredMethod("doGet", HttpServletRequest.class,
					HttpServletResponse.class);
			return method.invoke(servletInstance, request, response);
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
		return null;
	}

}
