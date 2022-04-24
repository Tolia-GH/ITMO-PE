package Collection;

/**
 * The enum Organization type.
 */
public enum OrganizationType {
    /**
     * Commercial organization type.
     */
    COMMERCIAL,
    /**
     * Public organization type.
     */
    PUBLIC,
    /**
     * Trust organization type.
     */
    TRUST,
    /**
     * Private limit company organization type.
     */
    PRIVATE_LIMIT_COMPANY,
    /**
     * Null organization type.
     */
    NULL;

    /**
     * List string.
     *
     * @return the string
     */
    public static String list() {
        StringBuilder list = new StringBuilder();
        for (OrganizationType type : OrganizationType.values()) {
            if (type.name().equals("PRIVATE_LIMIT_COMPANY")) {
                list.append("        ").append(type.name());
                break;
            }
            list.append("        ").append(type.name()).append("\n");
        }
        return list.toString();
    }

    /**
     * Find type boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean findType(String string) {
        for (OrganizationType type : OrganizationType.values()) {
            if (type.toString().equals(string)) {
                return true;
            }
        }
        return false;
    }
}
