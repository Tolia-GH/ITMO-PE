package Main;//Variant: 52190

import Characters.Interfaces.Move;
import Characters.MyCharacter;
import Characters.MainCharacters.*;
import Characters.OtherCharacters.*;
import Environment.*;
import Environment.Places.*;
import MyExeption.Problem;
import Object.*;

import java.util.Scanner;

/**<p>Project name: Prog_Lab_4 </p>
 * @author <a href="https://github.com/Tolia-GH">Tolia</a>
 */
public class Main {



    public static void main(String[] args) {

        System.out.println("Introducing characters:\n");

        WinnieThePooh winnieThePooh = new WinnieThePooh("Winnie");
        Piglet piglet = new Piglet();
        Rabbit rabbit = new Rabbit();
        Tigger tigger = new Tigger();
        Kanga kanga = new Kanga();
        Roo roo = new Roo();

        System.out.println();


        {
            System.out.println("Scene 1:\n");
            piglet.setMood(MyCharacter.Mood.VERY_HAPPY);
            piglet.showMood();

            Thing aGoodThing = new Thing(Thing.State.GOOD);
            piglet.believe();
            piglet.doThing(aGoodThing);
            aGoodThing.setName("The good thing");

            winnieThePooh.willTakePartIn(aGoodThing);
            rabbit.willTakePartIn(aGoodThing);
            aGoodThing.showParticipants();

            if (aGoodThing.checkParticipant(winnieThePooh) && aGoodThing.checkParticipant(rabbit)) {
                MainCharacter littleThings = new MainCharacter("Little animals") {
                    @Override
                    public void willTakePartIn(Thing event) {
                        event.getParticipants()[event.getNumParticipants()] = this;
                        event.increaseNumParticipants(1);
                        System.out.println(this.getName() + " can also take part in " + event.getName());
                    }

                    public void sleep() {
                        System.out.println(this.getName() + " has a good sleep.");
                    }
                };

                System.out.println("If " + rabbit.getName() + " and " + winnieThePooh.getName() + " will take part in " + aGoodThing.getName());
                littleThings.willTakePartIn(aGoodThing);
                System.out.print("Then ");
                littleThings.sleep();
            }

            try {
                tigger.setLost(true);
            } catch (Problem problem) {
                problem.printDescription();
                problem.toBeSolve(piglet);
            }

            NorthPole northPole = new NorthPole();
            winnieThePooh.setMood(MyCharacter.Mood.HAPPY, "he is the first one who finds out " + northPole.placeName);
            winnieThePooh.showMood();

            northPole.arriveMember(winnieThePooh);
            northPole.arriveMember(rabbit);
            northPole.arriveMember(piglet);
            northPole.arriveMember(tigger);

            NorthPole.Inscription inscription = northPole.new Inscription();
            inscription.viewInscription(tigger);

            Thing thingTiggerDonNotKnow = new Thing("something " + tigger.getName() + " don't know now.");
            thingTiggerDonNotKnow.setDescription("which bear is he facing with - the A Yes Bear!");
            thingTiggerDonNotKnow.know(tigger);

            rabbit.getHouse().addNeighbor(kanga);
            rabbit.getHouse().addNeighbor(roo);
            rabbit.getHouse().addNeighbor(tigger);
            rabbit.getHouse().showNeighbors();

            rabbit.ask(tigger, "What will you do tomorrow? " +
                    "If you do nothing, what about have a walk with "
                    + winnieThePooh.getName() + " " + piglet.getName());

            tigger.answer();

            System.out.println();
        }

        System.out.println("Scene 2:\n");

        Day day = new Day(1);
        Weather weather = new Weather(Weather.Status.WARM_AND_SUNNY);
        winnieThePooh.setOff(false);

        day.goNextDay();
        weather.changeStatus(Weather.Status.COLD_AND_FOGGY);
        winnieThePooh.setMood(MyCharacter.Mood.NOT_AFRAID);
        winnieThePooh.showMood();

        Bees bees = new Bees();
        winnieThePooh.think(true, bees, weather);

        winnieThePooh.setMood(MyCharacter.Mood.SAD);
        winnieThePooh.showMood();

        winnieThePooh.move(piglet);
        winnieThePooh.tell(piglet);
        piglet.think(false, new Bees(), weather);
        Forest forest = new Forest();
        //Forest.Jungle jungle = forest.new Jungle();
        People people = new People(forest);
        piglet.think(true, people, weather);

        House houseRabbit = new House(rabbit);
        rabbit.setLocation(houseRabbit);
        winnieThePooh.move(houseRabbit);
        piglet.move(houseRabbit);
        houseRabbit.arriveMember(winnieThePooh);
        houseRabbit.arriveMember(piglet);

        houseRabbit.meetMember();
        houseRabbit.showMember();

        rabbit.say("Today is the best day for adventure!");
        rabbit.say("Because " + tigger.jumpForward(weather));
        rabbit.say("As soon as he is out of sight, they will all run away and he will never see them again.");

        kanga.getHouse().arriveMember(winnieThePooh);
        kanga.getHouse().arriveMember(rabbit);
        kanga.getHouse().arriveMember(piglet);

        MainCharacter.setCloseFriend(tigger, roo);
        roo.showFriendShip();
        roo.waiting();

        Thing theWholeThing = new Thing("The whole thing");
        theWholeThing.getWorse();

        rabbit.coverMouth();rabbit.say(winnieThePooh, "Follow me.");
        rabbit.move(kanga);
        Move.setOff();
        rabbit.setLocation(forest);
        piglet.setLocation(forest);
        tigger.setLocation(forest);
        winnieThePooh.setLocation(forest);

        Forest.Road road = forest.new Road();

        Move.walkSideBySide(new MainCharacter[]{winnieThePooh, rabbit, piglet});
        tigger.run("around");
        tigger.describeCircle();
        road.getNarrow();
        Move.walkOneByOne(new MainCharacter[]{winnieThePooh, rabbit, piglet});
        tigger.describeCircle();

        Forest.Road.BarbedWall barbedWall = road.new BarbedWall();
        tigger.run(" far away and back");
        tigger.hit(rabbit, "sometimes");
        tigger.hit(rabbit, "sometimes not");

        Weather.Fog fog = weather.new Fog();
        fog.gettingThicker();
        tigger.disappear("sometimes");
        tigger.showUp("when you think he disappear.");
        tigger.say("Who are you? What are you doing? Move!");
        tigger.disappear("without answer");

        rabbit.turnAroundAndPush(piglet);
        tigger.showUp("suddenly");
        tigger.hit(rabbit,"");
        tigger.disappear("");

        Forest.EmptyGround emptyGround = new Forest.EmptyGround();
        Move.chaseUp(new MainCharacter[]{winnieThePooh, piglet});

        Forest.Jungle jungle = new Forest.Jungle();
        jungle.getCrowdIn(new MainCharacter[]{winnieThePooh, piglet});
        jungle.listen(new MainCharacter[]{winnieThePooh, piglet});

        Forest.isQuiet();

    }
}
