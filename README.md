# Build Flow HTTP Extension

A Jenkins plugin that extends to BuildFlow DSL. It gives you the ability to make HTTP get requests from your build script.

```groovy
def http = extension.'build-flow-http-extension'
def response = http.get('http://echo.jsontest.com/key/value')
out.println(response) //=> {"key": "value"}
```

## Installation

1. Download the ``*.hpi`` for the version you want in the Releases tab of this repo.
2. Navigate to the Advanced tab of your Jenkins Master's plugin manager.
3. Upload the ``*.hpi`` you downloaded in step 1.
