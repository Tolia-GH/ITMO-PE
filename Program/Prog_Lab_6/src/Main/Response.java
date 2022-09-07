package Main;

import Collection.Organization;

import java.io.Serializable;
import java.util.ArrayDeque;

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
    public Response(ArrayDeque<Organization> organizations, String responseMessage, int amountSet){
        this.organizationSet = organizations;
        this.responseMessage = responseMessage;
        this.amountSet = amountSet;
    }

    private final ArrayDeque<Organization> organizationSet;

    private int amountSet;

    private final String responseMessage;

    /**
     * Gets organization set.
     *
     * @return the organization set
     */
    public ArrayDeque<Organization> getOrganizationSet() {
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