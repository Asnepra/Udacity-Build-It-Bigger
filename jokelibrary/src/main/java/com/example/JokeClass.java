package com.example;

import java.util.Random;

public class JokeClass {
    public static String[] jokes1 = new String[6];
    ;

    static {

        jokes1[0] = "You're not fat, you're just... easier to see.";
        jokes1[1] = "I'm not saying I hate you, but I would unplug your life support to charge my phone.";
        jokes1[2] = "Q: \"Whats the object-oriented way to become wealthy?\"\n" +
                "A: Inheritance";
        jokes1[3] = "I think my neighbor is stalking me as she's been googling my name on her computer.\n" +
                "I saw it through my telescope last night.";
        jokes1[4] = "A recent study has found that women who carry a little extra weight live longer" +
                " than the men who mention it.";
        jokes1[5] = "You know that tingly little feeling you get when you like someone?\n" +
                " That's your common sense leaving your body..";
    }

    public static String getRandomJoke() {
        return jokes1[new Random().nextInt(jokes1.length)];
    }
}
