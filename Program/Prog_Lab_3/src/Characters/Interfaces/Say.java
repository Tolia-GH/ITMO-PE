package Characters.Interfaces;

import Characters.Subject;

public interface Say {
    void say();
    void say(String words);
    void say(Subject subject);
    void say(Subject subject, String words);
}
