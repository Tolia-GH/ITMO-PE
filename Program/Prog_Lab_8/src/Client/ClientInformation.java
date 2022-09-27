package Client;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClientInformation implements Serializable {
    private String host;
    private int port;
    private String database;
    private String userName;
    private String passWord;
    private String hash;
    private boolean create;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getDatabase() {
        return database;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isCreate() {
        return create;
    }

    public String getHash() {
        return hash;
    }

    public ClientInformation(String userName, String passWord, boolean create) {
        this.database = "studs";
        this.userName = userName;
        this.passWord = passWord;
        this.port = 5432;
        this.host = "localhost";
        this.hash = setHash(passWord);
        this.create = create;
    }

    private String setHash(String s) {
        String result = null;
        if (s != null && s.length() > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD2");
                messageDigest.update(s.getBytes(StandardCharsets.UTF_8));
                byte [] buffer = messageDigest.digest();
                result = new String(buffer, 0, buffer.length);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "InputNew{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", Database='" + database + '\'' +
                ", userName='" + userName + '\'' +
                ", password=" + passWord +
                '}';
    }
}
