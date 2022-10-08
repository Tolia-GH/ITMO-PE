package Manager;

import Collection.ObservableOrganization;
import Collection.Organization;
import Exceptions.NotInitializedException;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * The type Organization manager.
 */
public class OrganizationManager {
    /**
     * The constant InitializationTime.
     */
    private static Date InitializationTime;
    /**
     * The Organization set.
     */
    private static LinkedBlockingDeque<Organization> organizationSet;
    /**
     * The constant IsInitialized.
     */
    public static boolean IsInitialized = false;

    /**
     * Sets organization set.
     *
     */
    public static void setOrganizationSet(LinkedBlockingDeque<Organization> linkedBlockingDeque) {
        //try {
        organizationSet = linkedBlockingDeque;
        IsInitialized = true;
        //} catch (NullPointerException e) {
        //Tools.MessageL("Error: Can not set Organizations because parameters was wrong!");
        //}
    }

    /**
     * Gets organization set.
     *
     * @return the organization set
     */
    public static LinkedBlockingDeque<Organization> getOrganizationSet() {
        if (!OrganizationManager.IsInitialized) {
            throw new NotInitializedException("Error: Collections was not initialized!\n");
        } else {
            return organizationSet;
        }
    }

    /**
     * Do initialization.
     */
    public static void doInitialization() {
        if (!IsInitialized) {
            organizationSet = new LinkedBlockingDeque<>();
            InitializationTime = new Date();
            IsInitialized = true;
        }
    }

    /**
     * Sets initialization.
     */
    public static void setInitialization() {
        IsInitialized = true;
    }

    /**
     * Gets initialization time.
     *
     * @return the initialization time
     */
    public static Date getInitializationTime() {
        return InitializationTime;
    }

    /**
     * Find by id organization.
     *
     * @param id the id
     * @return the organization
     */
    public static Organization findById(Long id) {
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (id.equals(organization.getId())) {
                return organization;
            }
        }
        return null;
    }

    public static Long getMaxId() {
        Long id = 0L;
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (organization.getId() > id) {
                id = organization.getId();
            }
        }
        return id;
    }

    /**
     * Is exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean isExist(Long id) {
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            if (id.equals(organization.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sort.
     */
    public static void sort() {
        Long count = 0L;
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            organization.setId(count);
            count++;
        }
    }

    public static ObservableList<ObservableOrganization> toObservableList(LinkedBlockingDeque<Organization> organizationSet) {
        ObservableList<ObservableOrganization> organizationList = FXCollections.observableArrayList();
        for (Organization organization : organizationSet) {
            organizationList.add(organization.toObservableOrganization());
        }

        return organizationList;
    }
}
