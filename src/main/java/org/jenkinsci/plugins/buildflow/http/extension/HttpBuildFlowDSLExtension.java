package org.jenkinsci.plugins.buildflow.http.extension;

import com.cloudbees.plugins.flow.BuildFlowDSLExtension;
import com.cloudbees.plugins.flow.FlowDelegate;
import groovyx.net.http.HTTPBuilder;
import hudson.Extension;

/**
 * Created by jniesen on 5/5/14.
 */

@Extension
public class HttpBuildFlowDSLExtension extends BuildFlowDSLExtension {

    public static final String EXTENSION_NAME = "build-flow-http-extension";

    @Override
    public Object createExtension(String extensionName, FlowDelegate flowDelegate) {
      if (extensionName == this.EXTENSION_NAME) {
        return getHttpBuildFlowDSL(flowDelegate);
      }

      return null;
    }

    public HttpBuildFlowDSL getHttpBuildFlowDSL(FlowDelegate flowDelegate) {
      return new HttpBuildFlowDSL(flowDelegate, getHttpBuilder());
    }

    public HTTPBuilder getHttpBuilder() {
      return new HTTPBuilder();
    }
}
