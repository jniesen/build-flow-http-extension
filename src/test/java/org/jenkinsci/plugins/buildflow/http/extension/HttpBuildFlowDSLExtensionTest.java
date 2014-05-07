package org.jenkinsci.plugins.buildflow.http.extension;

import com.cloudbees.plugins.flow.FlowDelegate;
import groovyx.net.http.HTTPBuilder;
import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class HttpBuildFlowDSLExtensionTest extends TestCase {

  @Test
  public void testReturnDSLIfExtensionNameMatches () throws Exception {
    HttpBuildFlowDSLExtension myExtension = new HttpBuildFlowDSLExtension();
    FlowDelegate mockFlowDelegate = mock(FlowDelegate.class);
    Object returnedObject = myExtension.createExtension("build-flow-http-extension", mockFlowDelegate);
    assertEquals(HttpBuildFlowDSL.class.getName(), returnedObject.getClass().getName());
  }

  @Test
  public void testReturnNullIfExtensionNameDoesNotMatch () throws Exception {
    HttpBuildFlowDSLExtension myExtension = new HttpBuildFlowDSLExtension();
    FlowDelegate mockFlowDelegate = mock(FlowDelegate.class);
    Object returnedObject = myExtension.createExtension("some-other-extension", mockFlowDelegate);
    assertNull(returnedObject);
  }

  @Test
  public void testGetHttpBuildFlowDSL () throws Exception {
    FlowDelegate mockFlowDelegate = mock(FlowDelegate.class);
    HttpBuildFlowDSLExtension myExtension = new HttpBuildFlowDSLExtension();
    HttpBuildFlowDSL returnedObject = myExtension.getHttpBuildFlowDSL(mockFlowDelegate);
    assertEquals(HttpBuildFlowDSL.class.getName(), returnedObject.getClass().getName());
  }

  @Test
  public void testGetHttpBuilder() throws Exception {
    HttpBuildFlowDSLExtension myExtension = new HttpBuildFlowDSLExtension();
    HTTPBuilder returnedObject = myExtension.getHttpBuilder();
    assertEquals(HTTPBuilder.class.getName(), returnedObject.getClass().getName());
  }

}