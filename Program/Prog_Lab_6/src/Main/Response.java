package Main;

import Collection.Organization;

import java.io.Serializable;
import java.util.ArrayDeque;

public class Response implements Serializable {
    public Response(ArrayDeque<Organization> organizations, String responseMessage){
        this.organizationSet = organizations;
        this.responseMessage = responseMessage;
        this.amountSet = organizations.size();
    }

    private final ArrayDeque<Organization> organizationSet;

    private int amountSet;

    private final String responseMessage;

    public ArrayDeque<Organization> getOrganizationSet() {
        return organizationSet;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public int getAmountSet() {
        return amountSet;
    }

    public void setAmountSet(int amountSet) {
        this.amountSet = amountSet;
    }
}