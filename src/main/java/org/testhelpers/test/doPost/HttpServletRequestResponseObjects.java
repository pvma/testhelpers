package org.testhelpers.test.doPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class HttpServletRequestResponseObjects {
	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession httpSession;
	Map<String, String> paramMap = new HashMap<String, String>();
	Map<String, Object> attributeMap = new HashMap<String, Object>();

	Map<String, String> requestHeaders = new HashMap<String, String>();
	Map<String, Object> responseHeaders = new HashMap<String, Object>();

	Map<String, Object> requestHttpSessionAttributeMap = new HashMap<String, Object>();

	protected HttpServletRequest getRequest() {
		request = new HttpServletRequest() {
			private int serverPort;
			private boolean isSecure;
			private String serverName;
			private String scheme;
			private Locale locale;
			private int localPort;
			private int remotePort;
			private String remoteHost;
			private String remoteAddr;
			private String realPath;
			private BufferedReader reader;
			private String protocol;
			private String localName;
			private String localAddr;
			private String contentType;
			private int contentLength;
			private String characterEncoding;
			private String authType;
			private String contextPath;
			private Cookie[] cookies;
			private String method;
			private String pathInfo;
			private String pathTranslated;
			private String queryString;
			private String remoteUser;
			private String requestURI;
			private StringBuffer requestURL;
			private String requestedSessionId;
			private String servletPath;
			private Principal userPrincipal;
			private boolean requestedSessionIdFromCookie;
			private boolean requestedSessionIdFromURL;
			private boolean requestedSessionIdFromUrl;
			private boolean requestedSessionIdValid;
			private boolean userInRole;
			private Enumeration locales;
			private ServletInputStream stream;

			public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
				characterEncoding = arg0;

			}

			public void setAttribute(String arg0, Object arg1) {
				attributeMap.put(arg0, arg1);

			}

			public void removeAttribute(String arg0) {
				attributeMap.remove(arg0);

			}

			public boolean isSecure() {
				return isSecure;
			}

			public int getServerPort() {
				return serverPort;
			}

			public String getServerName() {
				return serverName;
			}

			public String getScheme() {
				return scheme;
			}

			public RequestDispatcher getRequestDispatcher(String arg0) {
				RequestDispatcher requestDispatcher = new RequestDispatcher() {

					public void include(ServletRequest arg0, ServletResponse arg1)
							throws ServletException, IOException {
						// TODO Auto-generated method stub

					}

					public void forward(ServletRequest arg0, ServletResponse arg1)
							throws ServletException, IOException {
						// TODO Auto-generated method stub

					}
				};
				return requestDispatcher;
			}

			public int getRemotePort() {
				return remotePort;
			}

			public String getRemoteHost() {
				return remoteHost;
			}

			public String getRemoteAddr() {
				return remoteAddr;
			}

			public String getRealPath(String arg0) {
				return realPath;
			}

			public BufferedReader getReader() throws IOException {
				if (reader == null) {
					reader = new BufferedReader(new Reader() {

						@Override
						public int read(char[] cbuf, int off, int len) throws IOException {
							// TODO Auto-generated method stub
							return 0;
						}

						@Override
						public void close() throws IOException {
							// TODO Auto-generated method stub

						}
					});
				}
				return reader;
			}

			public String getProtocol() {
				return protocol;
			}

			public String[] getParameterValues(String arg0) {
				if (paramMap != null) {
					String[] parameterValues = new String[paramMap.size()];
					int i = 0;
					for (Entry<String, String> entry : paramMap.entrySet()) {
						parameterValues[i] = entry.getValue();
						i++;
					}
					return parameterValues;
				}
				return null;
			}

			public Enumeration getParameterNames() {
				Enumeration<String> parameterNames = Collections.enumeration(paramMap.keySet());
				return parameterNames;
			}

			public Map getParameterMap() {
				return paramMap;
			}

			public String getParameter(String arg0) {
				return paramMap.get(arg0);
			}

			public Enumeration getLocales() {
				return locales;
			}

			public Locale getLocale() {
				return locale;
			}

			public int getLocalPort() {
				return localPort;
			}

			public String getLocalName() {
				return localName;
			}

			public String getLocalAddr() {
				return localAddr;
			}

			public ServletInputStream getInputStream() throws IOException {
				stream = new ServletInputStream() {

					@Override
					public int read() throws IOException {
						// TODO Auto-generated method stub
						return 0;
					}
				};
				return stream;
			}

			public String getContentType() {
				return contentType;
			}

			public int getContentLength() {
				return contentLength;
			}

			public String getCharacterEncoding() {
				return characterEncoding;
			}

			public Enumeration getAttributeNames() {
				Enumeration<String> attributeNames = Collections.enumeration(attributeMap.keySet());
				return attributeNames;
			}

			public Object getAttribute(String arg0) {
				if (attributeMap != null) {
					return attributeMap.get(arg0);
				}
				return null;
			}

			public boolean isUserInRole(String arg0) {
				return userInRole;
			}

			public boolean isRequestedSessionIdValid() {
				return requestedSessionIdValid;
			}

			public boolean isRequestedSessionIdFromUrl() {
				return requestedSessionIdFromUrl;
			}

			public boolean isRequestedSessionIdFromURL() {
				return requestedSessionIdFromURL;
			}

			public boolean isRequestedSessionIdFromCookie() {
				return requestedSessionIdFromCookie;
			}

			public Principal getUserPrincipal() {
				return userPrincipal;
			}

			public HttpSession getSession(boolean arg0) {
				if (arg0) {
					httpSession = getHttpSession();
				}
				return httpSession;
			}

			public HttpSession getSession() {
				if (httpSession == null) {
					httpSession = getHttpSession();
				}
				return httpSession;
			}

			public String getServletPath() {
				return servletPath;
			}

			public String getRequestedSessionId() {
				return requestedSessionId;
			}

			public StringBuffer getRequestURL() {
				return requestURL;
			}

			public String getRequestURI() {
				return requestURI;
			}

			public String getRemoteUser() {
				return remoteUser;
			}

			public String getQueryString() {
				return queryString;
			}

			public String getPathTranslated() {
				return pathTranslated;
			}

			public String getPathInfo() {
				return pathInfo;
			}

			public String getMethod() {
				return method;
			}

			public int getIntHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			public Enumeration getHeaders(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public Enumeration getHeaderNames() {
				Enumeration<String> requestHeaderNames = Collections.enumeration(requestHeaders.keySet());
				return requestHeaderNames;
			}

			public String getHeader(String arg0) {
				if (requestHeaders != null) {
					return requestHeaders.get(arg0);
				}
				return null;
			}

			public long getDateHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			public Cookie[] getCookies() {
				return cookies;
			}

			public String getContextPath() {
				return contextPath;
			}

			public String getAuthType() {
				return authType;
			}
		};
		return request;
	}

	protected HttpServletResponse getResponse() {
		response = new HttpServletResponse() {
			Locale locale;
			String contentType;
			int contentLength;
			String characterEncoding;
			int bufferSize;

			PrintWriter writer;
			StringBuilder writerData = new StringBuilder();
			private int sendError;
			private String encodeUrl;
			private String encodeURL;
			private String encodeRedirectUrl;
			private String encodeRedirectURL;
			private boolean committed;
			private int status;
			private String msg;
			private String redirect;
			private List<Cookie> cookies = new ArrayList<Cookie>();

			public void setLocale(Locale arg0) {
				this.locale = arg0;

			}

			public void setContentType(String arg0) {
				this.contentType = arg0;

			}

			public void setContentLength(int arg0) {
				this.contentLength = arg0;

			}

			public void setCharacterEncoding(String arg0) {
				this.characterEncoding = arg0;

			}

			public void setBufferSize(int arg0) {
				this.bufferSize = arg0;

			}

			public void resetBuffer() {
				// do nothing

			}

			public void reset() {
				// do nothing

			}

			public boolean isCommitted() {
				return committed;
			}

			public PrintWriter getWriter() throws IOException {

				if (writer == null) {
					writer = new PrintWriter(new Writer() {

						@Override
						public void write(char[] cbuf, int off, int len) throws IOException {
							writerData.append(cbuf, off, len);

						}

						@Override
						public void flush() throws IOException {
							// TODO Auto-generated method stub

						}

						@Override
						public void close() throws IOException {
							// TODO Auto-generated method stub

						}
					});
				}
				return writer;
			}

			public Locale getLocale() {
				return locale;
			}

			public String getContentType() {
				return contentType;
			}

			public String getCharacterEncoding() {
				return characterEncoding;
			}

			public int getBufferSize() {
				return bufferSize;
			}

			public void flushBuffer() throws IOException {
				// do nothing

			}

			public void setStatus(int arg0, String arg1) {
				status = arg0;
				msg = arg1;

			}

			public void setStatus(int arg0) {
				status = arg0;

			}

			public void setIntHeader(String arg0, int arg1) {
				responseHeaders.put(arg0, arg1);

			}

			public void setHeader(String arg0, String arg1) {
				responseHeaders.put(arg0, arg1);

			}

			public void setDateHeader(String arg0, long arg1) {
				responseHeaders.put(arg0, arg1);

			}

			public void sendRedirect(String arg0) throws IOException {
				redirect = arg0;

			}

			public void sendError(int arg0, String arg1) throws IOException {
				sendError = arg0;

			}

			public void sendError(int arg0) throws IOException {
				sendError = arg0;

			}

			public String encodeUrl(String arg0) {
				return encodeUrl;
			}

			public String encodeURL(String arg0) {
				return encodeURL;
			}

			public String encodeRedirectUrl(String arg0) {
				return encodeRedirectUrl;
			}

			public String encodeRedirectURL(String arg0) {
				return encodeRedirectURL;
			}

			public boolean containsHeader(String arg0) {
				if (responseHeaders.get(arg0) == null)
					return false;
				return true;
			}

			public void addIntHeader(String arg0, int arg1) {
				responseHeaders.put(arg0, arg1);

			}

			public void addHeader(String arg0, String arg1) {
				responseHeaders.put(arg0, arg1);

			}

			public void addDateHeader(String arg0, long arg1) {
				responseHeaders.put(arg0, arg1);

			}

			public void addCookie(Cookie arg0) {
				cookies.add(arg0);

			}

			public ServletOutputStream getOutputStream() throws IOException {
				ServletOutputStream stream = new ServletOutputStream() {

					@Override
					public void write(int b) throws IOException {
						// do nothing

					}
				};
				return stream;
			}
		};
		return response;
	}

	private HttpSession getHttpSession() {
		httpSession = new HttpSession() {

			private int interval;
			private long creationTime;
			private String id;
			private long lastAccessedTime;
			private int maxInactiveInterval;
			private boolean isNew;;

			public void setMaxInactiveInterval(int interval) {
				this.interval = interval;

			}

			public void setAttribute(String name, Object value) {
				requestHttpSessionAttributeMap.put(name, value);

			}

			public void removeValue(String name) {
				requestHttpSessionAttributeMap.remove(name);

			}

			public void removeAttribute(String name) {
				requestHttpSessionAttributeMap.remove(name);

			}

			public void putValue(String name, Object value) {
				requestHttpSessionAttributeMap.put(name, value);

			}

			public boolean isNew() {
				return isNew;
			}

			public void invalidate() {
				// do nothing

			}

			public String[] getValueNames() {
				String[] strings = requestHttpSessionAttributeMap.keySet()
						.toArray(new String[requestHttpSessionAttributeMap.size()]);
				return strings;
			}

			public Object getValue(String name) {
				return requestHttpSessionAttributeMap.get(name);
			}

			public HttpSessionContext getSessionContext() {
				return getHttpSessionContextFromHttpSession();
			}

			public ServletContext getServletContext() {
				return getServletContextInsideHttpSession();
			}

			public int getMaxInactiveInterval() {
				return maxInactiveInterval;
			}

			public long getLastAccessedTime() {
				return lastAccessedTime;
			}

			public String getId() {
				return id;
			}

			public long getCreationTime() {
				return creationTime;
			}

			public Enumeration getAttributeNames() {
				Enumeration<String> names = Collections.enumeration(requestHttpSessionAttributeMap.keySet());
				return names;

			}

			public Object getAttribute(String name) {
				return requestHttpSessionAttributeMap.get(name);
			}
		};
		return httpSession;
	}

	private ServletContext getServletContextInsideHttpSession() {
		ServletContext context = new ServletContext() {

			public void setAttribute(String name, Object object) {
				// TODO Auto-generated method stub

			}

			public void removeAttribute(String name) {
				// TODO Auto-generated method stub

			}

			public void log(String message, Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public void log(Exception exception, String msg) {
				// TODO Auto-generated method stub

			}

			public void log(String msg) {
				// TODO Auto-generated method stub

			}

			public Enumeration getServlets() {
				// TODO Auto-generated method stub
				return null;
			}

			public Enumeration getServletNames() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getServletContextName() {
				// TODO Auto-generated method stub
				return null;
			}

			public Servlet getServlet(String name) throws ServletException {
				// TODO Auto-generated method stub
				return null;
			}

			public String getServerInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			public Set getResourcePaths(String path) {
				// TODO Auto-generated method stub
				return null;
			}

			public InputStream getResourceAsStream(String path) {
				// TODO Auto-generated method stub
				return null;
			}

			public URL getResource(String path) throws MalformedURLException {
				// TODO Auto-generated method stub
				return null;
			}

			public RequestDispatcher getRequestDispatcher(String path) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getRealPath(String path) {
				// TODO Auto-generated method stub
				return null;
			}

			public RequestDispatcher getNamedDispatcher(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			public int getMinorVersion() {
				// TODO Auto-generated method stub
				return 0;
			}

			public String getMimeType(String file) {
				// TODO Auto-generated method stub
				return null;
			}

			public int getMajorVersion() {
				// TODO Auto-generated method stub
				return 0;
			}

			public Enumeration getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getInitParameter(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getContextPath() {
				// TODO Auto-generated method stub
				return null;
			}

			public ServletContext getContext(String uripath) {
				// TODO Auto-generated method stub
				return null;
			}

			public Enumeration getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}

			public Object getAttribute(String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return context;
	}

	private HttpSessionContext getHttpSessionContextFromHttpSession() {
		HttpSessionContext context = new HttpSessionContext() {

			public HttpSession getSession(String sessionId) {
				return new HttpSession() {

					public void setMaxInactiveInterval(int interval) {
						// TODO Auto-generated method stub

					}

					public void setAttribute(String name, Object value) {
						// TODO Auto-generated method stub

					}

					public void removeValue(String name) {
						// TODO Auto-generated method stub

					}

					public void removeAttribute(String name) {
						// TODO Auto-generated method stub

					}

					public void putValue(String name, Object value) {
						// TODO Auto-generated method stub

					}

					public boolean isNew() {
						// TODO Auto-generated method stub
						return false;
					}

					public void invalidate() {
						// TODO Auto-generated method stub

					}

					public String[] getValueNames() {
						// TODO Auto-generated method stub
						return null;
					}

					public Object getValue(String name) {
						// TODO Auto-generated method stub
						return null;
					}

					public HttpSessionContext getSessionContext() {
						// TODO Auto-generated method stub
						return null;
					}

					public ServletContext getServletContext() {
						// TODO Auto-generated method stub
						return null;
					}

					public int getMaxInactiveInterval() {
						// TODO Auto-generated method stub
						return 0;
					}

					public long getLastAccessedTime() {
						// TODO Auto-generated method stub
						return 0;
					}

					public String getId() {
						// TODO Auto-generated method stub
						return null;
					}

					public long getCreationTime() {
						// TODO Auto-generated method stub
						return 0;
					}

					public Enumeration getAttributeNames() {
						// TODO Auto-generated method stub
						return null;
					}

					public Object getAttribute(String name) {
						// TODO Auto-generated method stub
						return null;
					}
				};
			}

			public Enumeration getIds() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return context;
	}

}
