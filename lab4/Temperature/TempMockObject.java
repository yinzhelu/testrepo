import junit.framework.*;
import com.mockobjects.servlet.*;

public class TempMockObject extends TestCase {
  
   public void test_correct_temp_post_req() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();
    
    request.setupAddParameter("farenheitTemperature", "-30.238");
    response.setExpectedContentType("text/html");
    s.doPost(request,response);
    response.verify();
    System.out.println(response.getOutputStreamContents());
  }

  public void test_null_tempreq() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();
    
    request.setupAddParameter("farenheitTemperature", "");
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    System.out.println(response.getOutputStreamContents());

  }

  public void test_bad_tempreq() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();
    
    request.setupAddParameter("farenheitTemperature", "batman");
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    System.out.println(response.getOutputStreamContents());

  }

  public void test_bad_paramreq() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();
    
    request.setupAddParameter("ironman", "-70.283");
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    System.out.println(response.getOutputStreamContents());

  }     
 }
