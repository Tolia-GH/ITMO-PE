package Manager;

import Collection.Exceptions.NoSuchCommandException;
import Collection.Organization;

import java.util.ArrayDeque;
import java.util.Date;

public class OrganizationManager {
    private static Date InitializationTime;
    private static ArrayDeque<Organization> organizationSet;
    public static boolean IsInitialized = false;

    public static ArrayDeque<Organization> getOrganizationSet() {
        if (!OrganizationManager.IsInitialized) {
            throw new NoSuchCommandException("Error: Collections was not initialized!\n");
        } else {
            return organizationSet;
        }
    }

    public static void doInitialization() {
        if (!IsInitialized) {
            organizationSet = new ArrayDeque<>();
            InitializationTime = new Date();
            IsInitialized = true;
        }
    }

    public static Date getInitializationTime() {
        return InitializationTime;
    }
}
