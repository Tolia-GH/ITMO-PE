package Main;

import Client.ClientInformation;

import java.io.Serializable;

public class Request implements Serializable {
    private PackageCommand packageCommand;
    private ClientInformation clientInformation;

    public Request(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
        this.packageCommand = null;
    }

    public Request(PackageCommand packageCommand) {
        this.packageCommand = packageCommand;
        this.clientInformation = null;
    }

    public Request(ClientInformation clientInformation, PackageCommand packageCommand) {
        this.clientInformation = clientInformation;
        this.packageCommand = packageCommand;
    }

    public ClientInformation getClientInformation() {
        return clientInformation;
    }

    public PackageCommand getPackageCommand() {
        return packageCommand;
    }
}

