package Collection;

public enum OrganizationType {
    COMMERCIAL,
    PUBLIC,
    TRUST,
    PRIVATE_LIMIT_COMPANY,
    NULL;

    public static String list() {
        String list = "";
        for (OrganizationType type : OrganizationType.values()) {
            if (type.name().equals("PRIVATE_LIMIT_COMPANY")) {
                list += "        " + type.name();
                break;
            }
            list += "        " + type.name() + "\n";
        }
        return list;
    }

    public static boolean findType(String string) {
        for (OrganizationType type : OrganizationType.values()) {
            if (type.toString().equals(string)) {
                return true;
            }
        }
        return false;
    }
}
