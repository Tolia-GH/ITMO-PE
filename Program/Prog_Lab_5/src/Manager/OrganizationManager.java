package Manager;

import Collection.Exceptions.NoSuchCommandException;
import Collection.Organization;
import Tools.Tools;
import com.sun.org.apache.xpath.internal.operations.Or;

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
            throw new NoSuchCommandException("Error: Collections was not initialized!\n");
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
     * Gets initialization time.
     *
     * @return the initialization time
     */
    public static Date getInitializationTime() {
        return InitializationTime;
    }
}
