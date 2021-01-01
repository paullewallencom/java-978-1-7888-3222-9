# Tomcat 9 - 

https://tomcat.apache.org/download-90.cgi - Windows 64bit

# OpenSSL To generate keys -

set OPENSSL_CONF=c:\OpenSSL-Win64\bin\openssl.cfg
openssl genrsa -out tomcat.key 4096
openssl req -newkey 2048 -nodes -keyout tomcat.key -x509 -days 365 -out tomcat.crt

# Copy to server.xml

<Connector SSLEnabled="true" maxThreads="150" port="8443" 
    protocol="org.apache.coyote.http11.Http11AprProtocol">
    <UpgradeProtocol 
        className="org.apache.coyote.http2.Http2Protocol"/>
    <SSLHostConfig honorCipherOrder="false">
       <Certificate certificateFile="conf/tomcat.crt" 
                    certificateKeyFile="conf/tomcat.key"/>
    </SSLHostConfig>
</Connector>

# jshell

jshell -v --add-modules jdk.incubator.httpclient
import jdk.incubator.http.*;
HttpClient httpClient = HttpClient.newHttpClient();
HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/javaee8/http2push")).GET().build();
HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
System.out.println(httpResponse.statusCode());
System.out.println(httpResponse.body());