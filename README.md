# Build Flow HTTP Extension

A Jenkins plugin that extends to BuildFlow DSL. It gives you the ability to make HTTP get requests from your build script.

```groovy
def http = extension.'build-flow-http-extension'
def response = http.get('http://echo.jsontest.com/key/value')
out.println(response) //=> {"key": "value"}
```
