package org.jenkinsci.plugins.buildflow.http.extension

import com.cloudbees.plugins.flow.FlowDelegate
import groovyx.net.http.HTTPBuilder
import org.junit.Test

import static org.mockito.Mockito.mock

/**
 * Created by jniesen on 5/7/14.
 */
class HttpBuildFlowDSLUnitTest extends GroovyTestCase {
  @Test
  void testRequiredArguments() {
    HTTPBuilder httpBuilderMock = mock(HTTPBuilder.class)
    FlowDelegate flowDelegateMock = mock(FlowDelegate.class)
    assert(new HttpBuildFlowDSL(flowDelegateMock, httpBuilderMock))
  }
}
