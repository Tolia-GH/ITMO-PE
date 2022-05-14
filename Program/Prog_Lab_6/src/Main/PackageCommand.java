package Main;

import Collection.Organization;
import Command.AbstractCommand;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.List;

public class PackageCommand implements Serializable {
    private final AbstractCommand abstractCommand;
    private final String[] arg;
    private final Organization organization;
    private final ArrayDeque<Organization> arrayDeque;
    private static final long serialVersionUID = 1L;
    private final String fileName;
    private final List<PackageCommand> list;
    private final boolean set;

    PackageCommand() {
        this.arg = null;
        this.abstractCommand = null;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = null;
        this.list = null;
        this.set = false;
    }

    public String[] getArg() {
        return this.arg;
    }

    public AbstractCommand getAbstractCommand() {
        return this.abstractCommand;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public ArrayDeque<Organization> getArrayDeque() {
        return this.arrayDeque;
    }

    public List<PackageCommand> getList() {
        return this.list;
    }

    public boolean isSet() {
        return set;
    }


}
