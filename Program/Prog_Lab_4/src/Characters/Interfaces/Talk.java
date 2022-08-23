package Characters.Interfaces;

import Characters.MyCharacter;
import MyExeption.InPutException;

public interface Talk {
    void say(String words);
    void say(MyCharacter myCharacter, String words);
    void answer();
    void tell(MyCharacter myCharacter);
    void ask(MyCharacter myCharacter, String words);
}
