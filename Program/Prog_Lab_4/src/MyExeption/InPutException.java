package MyExeption;

import java.io.IOException;

public class InPutException extends IOException {

    private String description;

    public InPutException() {
        this.setDescription("Input error");
    }

    public InPutException(String description) {
        this.setDescription(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printDescription() {
        System.out.println("There's a problem: " + this.getDescription());
    }


}
