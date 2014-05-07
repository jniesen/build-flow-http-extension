package org.jenkinsci.plugins.buildflow.http.extension

import com.cloudbees.plugins.flow.BuildFlow
import com.cloudbees.plugins.flow.BuildFlowDSLExtension
import com.cloudbees.plugins.flow.FlowRun
import groovy.mock.interceptor.MockFor
import hudson.model.Result
import jenkins.model.Jenkins
import org.jvnet.hudson.test.HudsonTestCase

/**
 * Created by jniesen on 5/6/14.
 */
class HttpBuildFlowDSLIntegratedTest extends HudsonTestCase {
  void testUseExtension() {
    MockFor mockDSL = new MockFor(HttpBuildFlowDSL.class)
    mockDSL.demand.get("http://getit") { "you got it" }

    FlowRun flowRun
    mockDSL.use {
      BuildFlowDSLExtension.all().add(new HttpBuildFlowDSLExtension())

      BuildFlow flow = new BuildFlow(Jenkins.instance, getName())
      flow.onCreatedFromScratch()
      flow.dsl = """
        x = extension.'build-flow-http-extension'
        result = x.get("http://getit")
        out.println(result)
      """
      flowRun = flow.scheduleBuild2(0).get()
    }

    assertEquals(Result.SUCCESS, flowRun.result)
    assertStringContains(flowRun.log, "you got it")
  }
}
