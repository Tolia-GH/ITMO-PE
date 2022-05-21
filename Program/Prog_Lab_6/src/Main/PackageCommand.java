package Main;

import Collection.Organization;
import Command.AbstractCommand;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.List;

public class PackageCommand implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String[] arg;
    private final AbstractCommand abstractCommand;
    private final Organization organization;
    private final ArrayDeque<Organization> arrayDeque;
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

    PackageCommand(String[] arg, AbstractCommand command, String fileName) {
        this.arg = arg;
        this.abstractCommand = command;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    PackageCommand(AbstractCommand command, Organization organization, String fileName) {
        this.arg = null;
        this.abstractCommand = command;
        this.organization = organization;
        this.arrayDeque = null;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    PackageCommand(AbstractCommand command, ArrayDeque<Organization> arrayDeque, String fileName) {
        this.arg = null;
        this.abstractCommand = command;
        this.organization = null;
        this.arrayDeque = arrayDeque;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }

    PackageCommand(String[] arg, AbstractCommand command, Organization organization, String fileName) {
        this.arg = arg;
        this.abstractCommand = command;
        this.organization = organization;
        this.arrayDeque = null;
        this.fileName = fileName;
        this.list = null;
        this.set = false;
    }


    PackageCommand(String name,boolean set){
        this.arg = null;
        this.abstractCommand = null;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = name;
        this.list = null;
        this.set = set;
    }

    PackageCommand(List<PackageCommand> list) {
        this.arg = null;
        this.abstractCommand = null;
        this.organization = null;
        this.arrayDeque = null;
        this.fileName = null;
        this.list = list;
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

    public String getFileName() {
        return fileName;
    }

    public List<PackageCommand> getList() {
        return this.list;
    }

    public boolean isSet() {
        return set;
    }



}
