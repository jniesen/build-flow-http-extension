package org.jenkinsci.plugins.buildflow.http.extension

import com.cloudbees.plugins.flow.FlowDelegate
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT

/**
 * Created by jniesen on 5/5/14.
 */
class HttpBuildFlowDSL {
  FlowDelegate flowDelegate
  HTTPBuilder http

  def HttpBuildFlowDSL(FlowDelegate flowDelegate, HTTPBuilder httpBuilder) {
    this.flowDelegate = flowDelegate
    this.http = httpBuilder
  }

  def get(url) {
    this.http.request(url, GET, TEXT) { req ->
      response.success = { resp, reader ->
        return reader.text
      }
    }
  }
}
