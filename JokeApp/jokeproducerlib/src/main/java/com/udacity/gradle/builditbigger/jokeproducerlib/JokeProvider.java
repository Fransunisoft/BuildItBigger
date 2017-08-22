package com.udacity.gradle.builditbigger.jokeproducerlib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;

/**
 * Java library for providing jokes
 */
public class JokeProvider {

    List<String> jokesList = null;


    public JokeProvider() {
        populateJokes();
    }

    /**
     * Add joke to list
     */
    void populateJokes() {
        jokesList = new ArrayList<>();

        jokesList.add("Girl: You would be a good dancer except for two things. \n\n" +
                "Boy: What are the two things? \n\n" +
                "Girl: Your feet. ");

        jokesList.add("A family of mice were surprised by a big cat. \n\nFather Mouse jumped and and said, \"Bow-wow!\" " +
                "\nThe cat ran away. \n\n\"What was that, Father?\" asked Baby Mouse. " +
                "\n\n\"Well, son, that\'s why it\'s important to learn a second language.\" ");

        jokesList.add("Patient: Doctor, I have a pain in my eye whenever I drink tea. \n\n" +
                "Doctor: Take the spoon out of the mug before you drink. ");

        jokesList.add("Headmaster: I\'ve had complaints about you, Johnny, from all your teachers. What have you been doing? \n\n" +
                "Johnny: Nothing, sir. \n\n" +
                "Headmaster: Exactly.");

        jokesList.add("If big elephants have big trunks, do small elephants have suitcases?");

        jokesList.add("Can a kangaroo jump higher than a house? Of course, a house doesn\'t jump at all.\n");

        jokesList.add("A man asks a farmer near a field,\" Sorry sir, would you mind if I crossed your field " +
                "instead of going around it?\nYou see, I have to catch the 4:23 train.\" \n" +
                "The farmer says, \" Sure, go right ahead. And if my bull sees you, you will even catch the 4:11 one.\"  ");

        jokesList.add("Pessimist: \"Things just can\'t get any worse!\" \n\n" +
                "Optimist: \"Nah, of course they can!\"");

        jokesList.add("What would you call a very funny mountain? \n" +
                "-\n" +
                "Hill Arious\"");

        jokesList.add("Teacher: \"OK class, who will give me the chemical formula for water?\" \n\n" +
                "Pupil: \"HIJKLMNO.\" \n\n" +
                "Teacher: \"What on earth are you on about?\" \n\n" +
                "Pupil: \"Well you said yourself yesterday it was H to O!\"");

        jokesList.add("Q: What did the tall chimney say to the small chimney? \n\n" +
                "A: \"Hey, you\'re way too young to smoke.\"");

        jokesList.add("Little Johnny: Odd. First my parents teach me to speak and then they want me to be quiet the whole time.");

        jokesList.add("An old guy in his Volvo is driving home from work when his wife rings him on his cell phone." +
                "\n\n \"Honey\", she says in a worried voice, \"please be careful. " +
                "There was a bit on the news just now, some lunatic is driving the wrong way down the highway\". " +
                "\n\n\"Oh it\'s worse than that\", he replies, \"there are hundreds of them!\"\n");

        jokesList.add("Daddy reads some bedtime stories to make little Jonny fall asleep. \n\n" +
                "Half an hour later mommy opens quietly the door and asks: \"And, is he asleep?\"\n\n" +
                "Little Jonny answers: \"Yes, finally.\"\n");

        jokesList.add("Little Jonny, why did you put your teddy in the freezer?\"\n\n" +
                "\"I would like to have a polar bear.\"");

        jokesList.add("A teacher is talking to a student.\"\n\n" +
                "Teacher: Did your father help you with your homework? \n\n" +
                "Student: No, he did it all by himself.");

        jokesList.add("Teacher: Tell me a sentence that starts with \"I.\"\n\n " +
                "Student: I is the ... \n\n" +
                "Teacher: Stop! Never put \"is\" after \"I.\" Always put \'am\' after \"I.\"\n\n " +
                "Student: OK. I am the ninth letter of the alphabet. ");

        jokesList.add("Patient : Doctor, will I be able to play the piano after the operation. \n\n" +
                "Doctor:  Yes, of course.\n\n" +
                "Patient: Great. I never could before. ");

        jokesList.add("Two children are talking.\n" +
                "A: Meet my new born brother.\n\n" +
                "B: Oh, he is so handsome! What\'s his name?\n\n" +
                "A: I don\'t know. I can\'t understand a word he says.");

        jokesList.add("A guy says to his friend, \"Guess how many coins I have in my pocket.\"\n\n" +
                "The friend says, \"If I guess right, will you give me one of them?\"\n\n" +
                "The first guy says, \"If you guess right, I\'ll give you both of them.\"");

        jokesList.add("Mother: \"Did you enjoy your first day at school?\"\n\n " +
                "Girl: \"First day? Do you mean I have to go back tomorrow? ");

        jokesList.add("Teacher: Did your father help your with your homework? \n\n" +
                "Student: No, he did it all by himself.");

        jokesList.add("A man receives a phone call from his doctor.\n" +
                "The doctor says, \"I have some good news and some bad news.\"\n\n" +
                "The man says, \"OK, give me the good news first.\"\n\n" +
                "The doctor says, \"The good news is, you have 24 hours to live.\"\n\n" +
                "The man replies, \"Oh no! If that's the good news, then what's the bad news?\"\n\n" +
                "The doctor says, \"The bad news is, I forgot to call you yesterday.\"");

    }

    /**
     * Retrieve a joke from list
     * @return
     */
    public String retrieveJokes() {
        Random random = new Random();
        int position = random.nextInt((jokesList.size() - 1) + 1);
        return jokesList.get(position);
    }


}

