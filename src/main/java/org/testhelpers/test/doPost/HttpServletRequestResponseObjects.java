package org.testhelpers.test.doPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.Principal;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpServletRequestResponseObjects {
	HttpServletRequest request;
	HttpServletResponse response;
	Map<String, String> paramMap = new HashMap<String, String>();
	Map<String, Object> attributeMap = new HashMap<String, Object>();

	Map<String, String> responseHeaders = new HashMap<String, String>();

	Enumeration headers = new Enumeration<String>() {

		public boolean hasMoreElements() {
			// TODO Auto-generated method stub
			return false;
		}

		public String nextElement() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	protected HttpServletRequest getRequest() {
		request = new HttpServletRequest() {
			int serverPort;
			boolean isSecure;
			String serverName;
			String scheme;
			Locale locale;
			int localPort;
			int remotePort;
			String remoteHost;
			String remoteAddr;
			String realPath;
			BufferedReader reader;
			String protocol;


			public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
				// TODO Auto-generated method stub

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
				if(reader == null) {
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
				// TODO Auto-generated method stub
				return null;
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
				// TODO Auto-generated method stub
				return null;
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
				// TODO Auto-generated method stub
				return null;
			}

			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			public int getContentLength() {
				// TODO Auto-generated method stub
				return 0;
			}

			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}

			public Enumeration getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}

			public Object getAttribute(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean isUserInRole(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isRequestedSessionIdValid() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isRequestedSessionIdFromUrl() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isRequestedSessionIdFromURL() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isRequestedSessionIdFromCookie() {
				// TODO Auto-generated method stub
				return false;
			}

			public Principal getUserPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}

			public HttpSession getSession(boolean arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public HttpSession getSession() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getServletPath() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getRequestedSessionId() {
				// TODO Auto-generated method stub
				return null;
			}

			public StringBuffer getRequestURL() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getRequestURI() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getRemoteUser() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getQueryString() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getPathTranslated() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getPathInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getMethod() {
				// TODO Auto-generated method stub
				return null;
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
				// TODO Auto-generated method stub
				return null;
			}

			public String getHeader(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public long getDateHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			public Cookie[] getCookies() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getContextPath() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getAuthType() {
				// TODO Auto-generated method stub
				return null;
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
				// TODO Auto-generated method stub

			}

			public void reset() {
				// TODO Auto-generated method stub

			}

			public boolean isCommitted() {
				// TODO Auto-generated method stub
				return false;
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
				// TODO Auto-generated method stub

			}

			public void setStatus(int arg0) {
				// TODO Auto-generated method stub

			}

			public void setIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub

			}

			public void setHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			public void setDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			public void sendRedirect(String arg0) throws IOException {
				// TODO Auto-generated method stub

			}

			public void sendError(int arg0, String arg1) throws IOException {
				// TODO Auto-generated method stub

			}

			public void sendError(int arg0) throws IOException {
				// TODO Auto-generated method stub

			}

			public String encodeUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String encodeURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String encodeRedirectUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String encodeRedirectURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean containsHeader(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public void addIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub

			}

			public void addHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			public void addDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			public void addCookie(Cookie arg0) {
				// TODO Auto-generated method stub

			}

			public ServletOutputStream getOutputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return response;
	}

}
