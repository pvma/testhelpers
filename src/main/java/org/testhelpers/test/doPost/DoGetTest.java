package org.testhelpers.test.doPost;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoGetTest extends HttpServletRequestResponseObjects {

	HttpServlet servletInstance;

	public DoGetTest() {
		request = getRequest();
		response = getResponse();
	}

	public void addServlet(HttpServlet servlet) {
		this.servletInstance = servlet;
	}

	public Object triggerServletDoGet() {
		try {
			Method method = servletInstance.getClass().getDeclaredMethod("doGet", HttpServletRequest.class,
					HttpServletResponse.class);
			return method.invoke(servletInstance, request, response);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Once the mocked object is added, you should
	public void addObjectToServletAsMocked(String servletField, Object mockedField) {

		try {
			Field f1 = servletInstance.getClass().getDeclaredField(servletField);
			f1.setAccessible(true);
			f1.set(servletInstance, mockedField);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Once the mocked object is added, you should
	public void addObjectToServletAsMockedInSuperClass1(String servletField, Object mockedField) {

		try {
			Field f1 = servletInstance.getClass().getSuperclass().getDeclaredField(servletField);
			f1.setAccessible(true);
			f1.set(servletInstance, mockedField);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Once the mocked object is added, you should
	public void addObjectToServletAsMockedInSuperClass2(String servletField, Object mockedField) {

		try {
			Field f1 = servletInstance.getClass().getSuperclass().getSuperclass().getDeclaredField(servletField);
			f1.setAccessible(true);
			f1.set(servletInstance, mockedField);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRequestParameter(String paramName, String paramValue) {

		paramMap.put(paramName, paramValue);
	}

	public void addRequestAttribute(String attributeName, Object attributeValue) {

		attributeMap.put(attributeName, attributeValue);
	}

}
