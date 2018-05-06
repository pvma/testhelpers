package org.testhelpers.test.doPost;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
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

	public void setServerPortInHttpRequest(Object value) {
		setInHttpRequest("serverPort", value);
	}

	public void setIsSecureInHttpRequest(Object value) {
		setInHttpRequest("isSecure", value);
	}

	public void setServerNameInHttpRequest(Object value) {
		setInHttpRequest("serverName", value);
	}

	public void setSchemeInHttpRequest(Object value) {
		setInHttpRequest("scheme", value);
	}

	public void setLocaleInHttpRequest(Object value) {
		setInHttpRequest("locale", value);
	}

	public void setLocalPortInHttpRequest(Object value) {
		setInHttpRequest("localPort", value);
	}

	public void setRemotePortInHttpRequest(Object value) {
		setInHttpRequest("remotePort", value);
	}

	public void setRemoteHostInHttpRequest(Object value) {
		setInHttpRequest("remoteHost", value);
	}

	public void setRemoteAddrInHttpRequest(Object value) {
		setInHttpRequest("remoteAddr", value);
	}

	public void setRealPathInHttpRequest(Object value) {
		setInHttpRequest("realPath", value);
	}

	public void setReaderInHttpRequest(Object value) {
		setInHttpRequest("reader", value);
	}

	public void setProtocolInHttpRequest(Object value) {
		setInHttpRequest("protocol", value);
	}

	public void setLocalNameInHttpRequest(Object value) {
		setInHttpRequest("localName", value);
	}

	public void setLocalAddrInHttpRequest(Object value) {
		setInHttpRequest("localAddr", value);
	}

	public void setContentTypeInHttpRequest(Object value) {
		setInHttpRequest("contentType", value);
	}

	public void setContentLengthInHttpRequest(Object value) {
		setInHttpRequest("contentLength", value);
	}

	public void setCharacterEncodingInHttpRequest(Object value) {
		setInHttpRequest("characterEncoding", value);
	}

	public void setAuthTypeInHttpRequest(Object value) {
		setInHttpRequest("authType", value);
	}

	public void setContextPathInHttpRequest(Object value) {
		setInHttpRequest("contextPath", value);
	}

	public void setCookiesInHttpRequest(Object value) {
		setInHttpRequest("cookies", value);
	}

	public void setMethodInHttpRequest(Object value) {
		setInHttpRequest("method", value);
	}

	public void setPathInfoInHttpRequest(Object value) {
		setInHttpRequest("pathInfo", value);
	}

	public void setPathTranslatedInHttpRequest(Object value) {
		setInHttpRequest("pathTranslated", value);
	}

	public void setQueryStringInHttpRequest(Object value) {
		setInHttpRequest("queryString", value);
	}

	public void setRemoteUserInHttpRequest(Object value) {
		setInHttpRequest("remoteUser", value);
	}

	public void setRequestURIInHttpRequest(Object value) {
		setInHttpRequest("requestURI", value);
	}

	public void setRequestURLInHttpRequest(Object value) {
		setInHttpRequest("requestURL", value);
	}

	public void setRequestedSessionIdInHttpRequest(Object value) {
		setInHttpRequest("requestedSessionId", value);
	}

	public void setServletPathInHttpRequest(Object value) {
		setInHttpRequest("servletPath", value);
	}

	public void setUserPrincipalInHttpRequest(Object value) {
		setInHttpRequest("userPrincipal", value);
	}

	public void setRequestedSessionIdFromCookieInHttpRequest(Object value) {
		setInHttpRequest("requestedSessionIdFromCookie", value);
	}

	public void setRequestedSessionIdFromURLInHttpRequest(Object value) {
		setInHttpRequest("requestedSessionIdFromURL", value);
	}

	public void setRequestedSessionIdFromUrlInHttpRequest(Object value) {
		setInHttpRequest("requestedSessionIdFromUrl", value);
	}

	public void setRequestedSessionIdValidInHttpRequest(Object value) {
		setInHttpRequest("requestedSessionIdValid", value);
	}

	public void setUserInRoleInHttpRequest(Object value) {
		setInHttpRequest("userInRole", value);
	}

	public void setLocalesInHttpRequest(Object value) {
		setInHttpRequest("locales", value);
	}

	public void setServletInputStreamInHttpRequest(Object value) {
		setInHttpRequest("servletInputStream", value);
	}

	/**
	 * Used here:
	 * <code>RequestDispatcher.getRequestDispatcher(String path)</code>
	 */
	public void setPathInHttpRequest(Object value) {
		setInHttpRequest("path", value);
	}

	/**
	 * Set in HttpServletRequest the values you want to inject
	 * 
	 * @param requestField
	 *            Field name of HttpServletRequest
	 * @param value
	 *            Set the value of the field
	 */
	public void setInHttpRequest(String requestField, Object value) {

		try {
			Field f1 = request.getClass().getDeclaredField(requestField);
			f1.setAccessible(true);
			f1.set(request, value);
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

	public void setLocaleInHttpResponse(Object value) {
		setInHttpRequest("locale", value);
	}

	public void setContentTypeInHttpResponse(Object value) {
		setInHttpRequest("contentType", value);
	}

	public void setContentLengthInHttpResponse(Object value) {
		setInHttpRequest("contentLength", value);
	}

	public void setCharacterEncodingInHttpResponse(Object value) {
		setInHttpRequest("characterEncoding", value);
	}

	public void setBufferSizeInHttpResponse(Object value) {
		setInHttpRequest("bufferSize", value);
	}

	public void setWriterInHttpResponse(Object value) {
		setInHttpRequest("writer", value);
	}

	public void setWriterDataInHttpResponse(Object value) {
		setInHttpRequest("writerData", value);
	}

	public void setSendErrorInHttpResponse(Object value) {
		setInHttpRequest("sendError", value);
	}

	public void setEncodeUrlInHttpResponse(Object value) {
		setInHttpRequest("encodeUrl", value);
	}

	public void setEncodeURLInHttpResponse(Object value) {
		setInHttpRequest("encodeURL", value);
	}

	public void setEncodeRedirectUrlInHttpResponse(Object value) {
		setInHttpRequest("encodeRedirectUrl", value);
	}

	public void setEncodeRedirectURLInHttpResponse(Object value) {
		setInHttpRequest("encodeRedirectURL", value);
	}

	public void setCommittedInHttpResponse(Object value) {
		setInHttpRequest("committed", value);
	}

	public void setStatusInHttpResponse(Object value) {
		setInHttpRequest("status", value);
	}

	public void setMsgInHttpResponse(Object value) {
		setInHttpRequest("msg", value);
	}

	public void setRedirectInHttpResponse(Object value) {
		setInHttpRequest("redirect", value);
	}

	public void setCookiesInHttpResponse(Object value) {
		setInHttpRequest("cookies", value);
	}

	/**
	 * Set and Test in HttpServletResponse the values you want to assert later
	 * 
	 * @param requestField
	 *            Field name of HttpServletResponse
	 * @param value
	 *            Set the value of the field
	 */
	public void setInHttpResponse(String responseField, Object value) {

		try {
			Field field = response.getClass().getDeclaredField(responseField);
			field.setAccessible(true);
			field.set(response, value);
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

	public Locale getLocaleInHttpResponse() {
		return (Locale) getInHttpResponse("locale");
	}

	public String getContentTypeInHttpResponse() {
		return (String) getInHttpResponse("contentType");
	}

	public String getContentLengthInHttpResponse() {
		return (String) getInHttpResponse("contentLength");
	}

	public String getCharacterEncodingInHttpResponse() {
		return (String) getInHttpResponse("characterEncoding");
	}

	public int getBufferSizeInHttpResponse() {
		return (Integer) getInHttpResponse("bufferSize");
	}

	public PrintWriter getWriterInHttpResponse() {
		return (PrintWriter) getInHttpResponse("writer");
	}

	public String getWriterDataInHttpResponse() {
		return ((StringBuilder) getInHttpResponse("writerData")).toString();
	}

	public int getSendErrorInHttpResponse() {
		return (Integer) getInHttpResponse("sendError");
	}

	public String getEncodeUrlInHttpResponse() {
		return (String) getInHttpResponse("encodeUrl");
	}

	public String getEncodeURLInHttpResponse() {
		return (String) getInHttpResponse("encodeURL");
	}

	public String getEncodeRedirectUrlInHttpResponse() {
		return (String) getInHttpResponse("encodeRedirectUrl");
	}

	public String getEncodeRedirectURLInHttpResponse() {
		return (String) getInHttpResponse("encodeRedirectURL");
	}

	public boolean getCommittedInHttpResponse() {
		return (Boolean) getInHttpResponse("committed");
	}

	public int getStatusInHttpResponse() {
		return (Integer) getInHttpResponse("status");
	}

	public String getMsgInHttpResponse() {
		return (String) getInHttpResponse("msg");
	}

	public String getRedirectInHttpResponse() {
		return (String) getInHttpResponse("redirect");
	}

	public List<Cookie> getCookiesInHttpResponse() {
		return (List<Cookie>) getInHttpResponse("cookies");
	}

	/**
	 * Set and Test in HttpServletResponse the values you want to assert later
	 * 
	 * @param requestField
	 *            Field name of HttpServletResponse
	 * @param value
	 *            Set the value of the field
	 */
	public Object getInHttpResponse(String responseField) {

		try {
			Field field = response.getClass().getDeclaredField(responseField);
			field.setAccessible(true);
			Object obj = field.get(response);
			return obj;
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
		return null;
	}

}
