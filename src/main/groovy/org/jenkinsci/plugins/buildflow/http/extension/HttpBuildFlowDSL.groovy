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
    final GET = groovyx.net.http.Method.GET
    final PUT = groovyx.net.http.Method.PUT
    final POST = groovyx.net.http.Method.POST
    final DELETE = groovyx.net.http.Method.DELETE
    final HEAD = groovyx.net.http.Method.HEAD
    final PATCH = groovyx.net.http.Method.PATCH
  }

  class ContentType {
    final ANY = groovyx.net.http.ContentType.ANY
    final TEXT = groovyx.net.http.ContentType.TEXT
    final JSON = groovyx.net.http.ContentType.JSON
    final XML = groovyx.net.http.ContentType.XML
    final HTML = groovyx.net.http.ContentType.HTML
    final URLENC = groovyx.net.http.ContentType.URLENC
    final BINARY = groovyx.net.http.ContentType.BINARY
  }

  def HttpBuildFlowDSL(FlowDelegate flowDelegate, HTTPBuilder httpBuilder) {
    this.flowDelegate = flowDelegate
    this.http = httpBuilder
  }
  
  def getWithAuthBasic(url, user, password) {
      def httpClient = new PreemptiveHttpClient(user, password, 5000)
      httpClient.ignoreSSLIssues()
      def httpResponse = httpClient.execute(new HttpGet(url))

      if (httpResponse.statusLine.statusCode == 200){
          return IOUtils.toString(httpResponse.getEntity().content)
      } else {
          return IOUtils.toString(httpResponse.getEntity().content)
      }
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
