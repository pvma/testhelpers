package org.testhelpers.test.doPost;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoPostTest extends HttpServletRequestResponseObjects {

	HttpServlet servletInstance;

	public DoPostTest() {
		request = getRequest();
		response = getResponse();
	}

	public void addServlet(HttpServlet servlet) {
		this.servletInstance = servlet;
	}

	public Object triggerServletDoPost() {
		try {
			Method method = servletInstance.getClass().getDeclaredMethod("doPost", HttpServletRequest.class,
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

	// Once the mocked object is added, you should
	public void addObjectToServletAsMocked(String servletField, Object mockedField) {

		try {
			Field f1 = servletInstance.getClass().getDeclaredField(servletField);
			f1.setAccessible(true);
			f1.set(servletInstance, mockedField);
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

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

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

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

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
	}

	public void addRequestParameter(String paramName, String paramValue) {

		paramMap.put(paramName, paramValue);
	}

	public void addRequestAttribute(String attributeName, Object attributeValue) {

		attributeMap.put(attributeName, attributeValue);
	}

	public String getWriterData() {
		String data = null;
		try {
			Field f1 = response.getClass().getDeclaredField("writerData");
			f1.setAccessible(true);
			data = ((StringBuilder) f1.get(response)).toString();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return data;

	}

}
