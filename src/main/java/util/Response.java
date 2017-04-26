package util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by KURZRO on 09.03.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private String id;
    private String endpointCalled;
    private String ipAddress;
    private String message;
    private String allEnvironmentVariables;

    public Response(){}

    public Response(String id, String endpointCalled, String ipAddress, String message, String allEnvironmentVariables) {
        this.id = id;
        this.endpointCalled = endpointCalled;
        this.ipAddress = ipAddress;
        this.message = message;
        this.allEnvironmentVariables = allEnvironmentVariables;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", endpointCalled='" + endpointCalled + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", message='" + message + '\'' +
                ", allEnvironmentVariables='" + allEnvironmentVariables + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndpointCalled() {
        return endpointCalled;
    }

    public void setEndpointCalled(String endpointCalled) {
        this.endpointCalled = endpointCalled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAllEnvironmentVariables() {
        return allEnvironmentVariables;
    }

    public void setAllEnvironmentVariables(String allEnvironmentVariables) {
        this.allEnvironmentVariables = allEnvironmentVariables;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
