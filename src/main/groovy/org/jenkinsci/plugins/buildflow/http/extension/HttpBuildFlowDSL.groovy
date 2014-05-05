package org.jenkinsci.plugins.buildflow.http.extension

import com.cloudbees.plugins.flow.FlowDelegate
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT

/**
 * Created by jniesen on 5/5/14.
 */
class HttpBuildFlowDSL {
    def FlowDelegate flowDelegate;
    def http = new HTTPBuilder();

    def HttpBuildFlowDSL(FlowDelegate flowDelegate) {
        this.flowDelegate = flowDelegate;
    }

    def get(url) {
      def getter = new HTTPBuilder()
      getter.request(url, GET, TEXT) { req ->
        response.success = { resp, reader ->
          return reader.text;
        }
      }
    }
}
