package Manager;

import Collection.Organization;
import Exceptions.NotInitializedException;
import Exceptions.ParaIncorrectException;

import java.util.ArrayDeque;
import java.util.Date;

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
    private static ArrayDeque<Organization> organizationSet;
    /**
     * The constant IsInitialized.
     */
    public static boolean IsInitialized = false;

    /**
     * Sets organization set.
     *
     * @param arrayDeque the array deque
     */
    public static void setOrganizationSet(ArrayDeque<Organization> arrayDeque) {
        //try {
        organizationSet = new ArrayDeque<>();
        organizationSet = arrayDeque.clone();
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
    public static ArrayDeque<Organization> getOrganizationSet() {
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
            organizationSet = new ArrayDeque<>();
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
        throw new ParaIncorrectException("Error: Target organization not found!\n");
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
        Long count = 1L;
        for (Organization organization : OrganizationManager.getOrganizationSet()) {
            organization.setId(count);
            count++;
        }
    }
}
