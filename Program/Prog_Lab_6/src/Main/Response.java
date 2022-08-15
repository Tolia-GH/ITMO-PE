package Main;

import Collection.Organization;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Response implements Serializable {
    public Response(LinkedHashSet<Organization> people, String responseMessage){
        this.organizationSet = people;
        this.responseMessage = responseMessage;
    }

    public Response(String responseMessage){
        this.organizationSet = null;
        this.responseMessage = responseMessage;
    }

    private final LinkedHashSet<Organization> organizationSet;

    private final String responseMessage;

    public LinkedHashSet<Organization> getOrganizationSet() {
        return organizationSet;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}