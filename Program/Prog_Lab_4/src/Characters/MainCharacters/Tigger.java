package Characters.MainCharacters;

import Characters.MyCharacter;
import Environment.Weather;
import MyExeption.InPutException;
import MyExeption.Problem;

import java.util.Scanner;

public class Tigger extends MainCharacter {

    private MainCharacter closeFriend;

    public Tigger() {
        super("Tigger");
    }
    public Tigger(String name) {
        super(name);
    }
    public Tigger(Gender gender) {
        super(gender);
    }
    public Tigger(String name, Gender gender) {
        super(name, gender);
    }

    private boolean lost = false;

    public boolean isLost() {
        return this.lost;
    }

    public void setLost(boolean lost) throws Problem {
        this.lost = lost;
        if(this.lost) {
            throw new Problem(this.getName() + " is lost.");
        }
    }

    public void showUp(String description) {
        System.out.println(this.getName() + " shows up " + description);
    }

    public void disappear(String description) {
        System.out.println(this.getName() + " disappeared " + description);
    }

    @Override
    public void answer(){
        Scanner sc = new Scanner(System.in);
        System.out.print(this.getName() + " answers that: ");
        String words = sc.nextLine();
        try{
            judgeAnswer(words);
        }catch (InPutException inPutException) {
            inPutException.printDescription();
            answer();
        }
    }

    public void judgeAnswer(String answer) throws InPutException {
        if(answer.equals("Yes")) {
            System.out.println("Everything will be fine");
            System.exit(0);
        } else if(answer.equals("No")) {
            System.out.println("......");
        }
        if(!answer.equals("Yes") && !answer.equals("No")) {
            throw new InPutException("Input error, " + "you should input Yes or No.");
        }
    }

    public void describeCircle() {
        System.out.println(this.getName() + " describes a circle");
    }

    public void hit(MyCharacter character, String how) {
        System.out.println(this.getName() + " " + how + " hits " + character.getName() + '.');
    }

    public String jumpForward(Weather weather) {
        if(weather.isBadWeather()) {
            return this.getName() + " always jump forward.";
        }
        return "";
    }
}
