package Main;//Variant: 52190

/**@Project_Name Prog_Lab_3
 * @author <a href = "https://github.com/Tolia-GH"> Tolia </a>
 */

import Characters.Gender;
import Characters.MainCharacters.MainCharacter;
import Characters.MainCharacters.Mood;
import Characters.OtherCharacters.Bees;
import Characters.OtherCharacters.People;
import Characters.OtherCharacters.Tiger;
import Environment.*;
import Environment.Places.HouseRabbit;

public class Main {
    public static void main(String[] args) {

        MainCharacter firstCharacter = new MainCharacter(Gender.MALE);

        Day day = new Day(1);
        Weather weather = new Weather(Weather.Status.WARM_AND_SUNNY);
        firstCharacter.move(false);

        day.goNextDay();
        weather.changeStatus(Weather.Status.COLD_AND_FOGGY);
        firstCharacter.setName("Pool");
        firstCharacter.setMood(Mood.NOT_AFRAID);
        firstCharacter.showMood();

        Bees bees = new Bees();
        firstCharacter.think(true, bees, weather);
        firstCharacter.setMood(Mood.SAD);
        firstCharacter.showMood();

        MainCharacter secondCharacter = new MainCharacter("Piglet", Gender.MALE);
        firstCharacter.move(secondCharacter);
        firstCharacter.say(secondCharacter);
        secondCharacter.think(false, new Bees(), weather);
        People people = new People();
        secondCharacter.think(true, people, weather);

        HouseRabbit houseRabbit = new HouseRabbit();
        MainCharacter thirdCharacter = new MainCharacter("Rabbit", Gender.MALE);
        thirdCharacter.setLocation(houseRabbit);
        firstCharacter.move(houseRabbit);
        secondCharacter.move(houseRabbit);
        houseRabbit.arriveMember(firstCharacter);
        houseRabbit.arriveMember(secondCharacter);

        houseRabbit.showMember();
        Tiger tiger = new Tiger();
        thirdCharacter.say("Today is the best day for adventure!");
        thirdCharacter.say("Because " + tiger.jumpForward(weather));
        thirdCharacter.say("As soon as he is out of sight, they will all run away and he will never see them again.");
    }
}
