package Main;

import Collection.Organization;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * The type Response.
 */
public class Response implements Serializable {
    /**
     * Instantiates a new Response.
     *
     * @param organizations   the organizations
     * @param responseMessage the response message
     */
    public Response(LinkedBlockingDeque<Organization> organizations, String responseMessage){
        this.organizationSet = organizations;
        this.responseMessage = responseMessage;
        this.amountSet = organizations.size();
    }

    public Response(String message) {
        this.responseMessage = message;
        this.organizationSet = null;
    }

    private final LinkedBlockingDeque<Organization> organizationSet;

    private int amountSet;

    private final String responseMessage;

    /**
     * Gets organization set.
     *
     * @return the organization set
     */
    public LinkedBlockingDeque<Organization> getOrganizationSet() {
        return organizationSet;
    }

    /**
     * Gets response message.
     *
     * @return the response message
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Gets amount set.
     *
     * @return the amount set
     */
    public int getAmountSet() {
        return amountSet;
    }

    /**
     * Sets amount set.
     *
     * @param amountSet the amount set
     */
    public void setAmountSet(int amountSet) {
        this.amountSet = amountSet;
    }
}