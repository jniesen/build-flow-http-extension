package org.jenkinsci.plugins.buildflow.http.extension

import com.cloudbees.plugins.flow.FlowDelegate
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.PUT
import static groovyx.net.http.Method.POST
import static groovyx.net.http.Method.DELETE
import static groovyx.net.http.Method.HEAD
import static groovyx.net.http.Method.PATCH
import static groovyx.net.http.ContentType.ANY
import static groovyx.net.http.ContentType.TEXT
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.XML
import static groovyx.net.http.ContentType.HTML
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.ContentType.BINARY

/**
 * Created by jniesen on 5/5/14.
 */
class HttpBuildFlowDSL {
  FlowDelegate flowDelegate
  HTTPBuilder http

  class Method {
    final static GET = groovyx.net.http.Method.GET
    final static PUT = groovyx.net.http.Method.PUT
    final static POST = groovyx.net.http.Method.POST
    final static DELETE = groovyx.net.http.Method.DELETE
    final static HEAD = groovyx.net.http.Method.HEAD
    final static PATCH = groovyx.net.http.Method.PATCH
  }

  class ContentType {
    final static ANY = groovyx.net.http.ContentType.ANY
    final static TEXT = groovyx.net.http.ContentType.TEXT
    final static JSON = groovyx.net.http.ContentType.JSON
    final static XML = groovyx.net.http.ContentType.XML
    final static HTML = groovyx.net.http.ContentType.HTML
    final static URLENC = groovyx.net.http.ContentType.URLENC
    final static BINARY = groovyx.net.http.ContentType.BINARY
  }

  def HttpBuildFlowDSL(FlowDelegate flowDelegate, HTTPBuilder httpBuilder) {
    this.flowDelegate = flowDelegate
    this.http = httpBuilder
  }

  def get(url) {
    this.http.request(url, GET, TEXT) { req ->
      headers.Accept = "application/json"
      response.success = { resp, reader ->
        return reader.text
      }
    }
  }
}
