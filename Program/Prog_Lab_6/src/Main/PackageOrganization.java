package Main;

import JSON.Collection.Organization;

import java.io.Serializable;
import java.util.ArrayDeque;

public class PackageOrganization implements Serializable {
    private final ArrayDeque<Organization> organizations;
    private final String manageOut;
    private final Integer id;

    PackageOrganization(ArrayDeque<Organization> organizations, String managerOut) {
        this.organizations = organizations;
        this.manageOut = managerOut;
        this.id = null;
    }

    PackageOrganization(Integer id, String managerOut) {
        this.organizations = null;
        this.manageOut = managerOut;
        this.id = id;
    }

    public ArrayDeque<Organization> getOrganizations() {
        return organizations;
    }

    public String getManageOut() {
        return manageOut;
    }

    public Integer getId() {
        return id;
    }
}
