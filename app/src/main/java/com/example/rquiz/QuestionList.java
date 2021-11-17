package com.example.rquiz;


public class QuestionList {

    //List of English questions
    private String mQuestionEng [] = {
            "At noon, Tim went to his grandparents' house for _____",
            "The cake was so _____ that fifty people could eat it",
            "Mother _____ some butter on the bread with a knife",
            "The _____ snapped and ate the duck hungrily",
            "The sheep and its _____ were playing in the field",
            "Walking through the _____, Ben saw a monkey on top of a tree."
    };

    //List of Science questions
    private String mQuestionScience [] = {
            "Which animal lays eggs?",
            "A male cow is called?",
            "All animals need food, air, and ____ to survive",
            "Which one is a fur-bearing animal?",
            "What is the young one of a cow called?",
            "Which part of the bird lets it fly high in the sky?"
    };

    //List of BM questions
    private String mQuestionBM [] = {
            "Ba_ _kal",
            "Kere_ _",
            "_ _rusi",
            "Kom_ _ter",
            "Al_ _ri",
            "Jende_ _",
            "Kame_ _",
            "Kal_ _lator"
    };

    //List of Maths questions
    private String mQuestionMaths [] = {
            "Count the number of cupcakes. There are ___ cupcakes altogether",
            "The greatest number is ___",
            "Count the number of ladybugs. There are total ___ ladybugs",
            "___ and 3 make 7",
            "Which number is higher than 6?"
    };

    //List of image drawables for English
    private int[] mImageEng = {
            R.drawable.eng_s1_q1,
            R.drawable.eng_s1_q2,
            R.drawable.eng_s1_q3,
            R.drawable.eng_s1_q4,
            R.drawable.eng_s1_q5,
            R.drawable.eng_s1_q6
    };

    //List of image drawables for Science
    private int[] mImageScience = {
            R.drawable.science_default,
            R.drawable.science_default,
            R.drawable.science_default,
            R.drawable.science_default,
            R.drawable.science_default,
            R.drawable.science_default
    };

    //List of image drawables for BM
    private int[] mImageBM = {
            R.drawable.bm_s1_q1,
            R.drawable.bm_s1_q2,
            R.drawable.bm_s1_q3,
            R.drawable.bm_s1_q4,
            R.drawable.bm_s1_q5,
            R.drawable.bm_s1_q6,
            R.drawable.bm_s1_q7,
            R.drawable.bm_s1_q8
    };

    //List of image drawables for Maths
    private int[] mImageMaths = {
            R.drawable.maths_s1_q1,
            R.drawable.maths_s1_q2,
            R.drawable.maths_s1_q3,
            R.drawable.maths_default,
            R.drawable.maths_default
    };

    //Multiple choice options for English
    private String mChoiceEng[] [] = {
            {"breakfast", "lunch", "dinner", "supper"},
            {"big", "small", "heavy", "light"},
            {"smeared", "scooped", "sprinkled", "spread"},
            {"lion", "monkey", "crocodile", "lizard"},
            {"calf", "foal", "lamb", "cub"},
            {"river", "jungle", "tunnel", "cave"}
    };

    //Multiple choice options for Science
    private String mChoiceScience[] [] = {
            {"Dog", "Cat", "Duck", "Sheep"},
            {"Ox", "Dog", "Sheep", "Monkey"},
            {"house", "water", "chocolate", "fruits"},
            {"Hen", "Crocodile", "Tortoise", "Cat"},
            {"Puppy", "Kitten", "Calf", "Baby"},
            {"Beak", "Feet", "Wings", "Claws"}
    };

    //Multiple choice options for BM
    private String mChoiceBM[] [] = {
            {"si", "sa", "su", "so"},
            {"tu", "ta", "te", "ti"},
            {"Ka", "Ku", "Ki", "Ke"},
            {"pu", "te", "ru", "se"},
            {"ma", "mi", "mu", "mo"},
            {"lo", "la", "ko", "nu"},
            {"ru", "ra", "ri", "ro"},
            {"ki", "ku", "ka", "ko"}
    };

    //Multiple choice options for Maths
    private String mChoiceMaths[] [] = {
            {"5", "6", "7", "8"},
            {"4", "9", "6", "7"},
            {"8", "9", "10", "11"},
            {"2", "3", "4", "5"},
            {"6", "2", "8", "3"}
    };

    //Correct answers for English
    private String mCorrectAnsEng [] = {"lunch", "big", "spread", "crocodile", "lamb", "jungle"};

    //Correct answers for Science
    private String mCorrectAnsScience [] = {"Duck", "Ox", "Water", "Cat", "Calf", "Wings"};

    //Correct answers for BM
    private String mCorrectAnsBM [] = {"si", "ta", "Ke", "pu", "ma", "la", "ra", "ku"};

    //Correct answers for Maths
    private String mCorrectAnsMaths [] = {"6", "9", "8", "4", "8"};

    //Get English questions
    public String getQuestionEng(int a) {
        String question = mQuestionEng[a];
        return question;
    }

    //Get Science questions
    public String getQuestionScience(int a) {
        String question = mQuestionScience[a];
        return question;
    }

    //Get BM questions
    public String getQuestionBM(int a) {
        String question = mQuestionBM[a];
        return question;
    }

    //Get Maths questions
    public String getQuestionMaths(int a) {
        String question = mQuestionMaths[a];
        return question;
    }

    //Get image drawable for English
    public int getImageEng(int a) {
        int image = mImageEng[a];
        return image;
    }

    //Get image drawable for Science
    public int getImageScience(int a) {
        int image = mImageScience[a];
        return image;
    }

    //Get image drawable for BM
    public int getImageBM(int a) {
        int image = mImageBM[a];
        return image;
    }

    //Get image drawable for Maths
    public int getImageMaths(int a) {
        int image = mImageMaths[a];
        return image;
    }

    //Get choice 1 for English
    public String getChoice1Eng(int a) {
        String choice0 = mChoiceEng[a][0];
        return choice0;
    }

    //Get choice 1 for Science
    public String getChoice1Science(int a) {
        String choice0 = mChoiceScience[a][0];
        return choice0;
    }

    //Get choice 1 for BM
    public String getChoice1BM(int a) {
        String choice0 = mChoiceBM[a][0];
        return choice0;
    }

    //Get choice 1 for Maths
    public String getChoice1Maths(int a) {
        String choice0 = mChoiceMaths[a][0];
        return choice0;
    }

    //Get choice 2 for English
    public String getChoice2Eng(int a) {
        String choice1 = mChoiceEng[a][1];
        return choice1;
    }

    //Get choice 2 for Science
    public String getChoice2Science(int a) {
        String choice1 = mChoiceScience[a][1];
        return choice1;
    }

    //Get choice 2 for BM
    public String getChoice2BM(int a) {
        String choice1 = mChoiceBM[a][1];
        return choice1;
    }

    //Get choice 2 for Maths
    public String getChoice2Maths(int a) {
        String choice1 = mChoiceMaths[a][1];
        return choice1;
    }

    //Get choice 3 for English
    public String getChoice3Eng(int a) {
        String choice2 = mChoiceEng[a][2];
        return choice2;
    }

    //Get choice 3 for Science
    public String getChoice3Science(int a) {
        String choice2 = mChoiceScience[a][2];
        return choice2;
    }

    //Get choice 3 for BM
    public String getChoice3BM(int a) {
        String choice2 = mChoiceBM[a][2];
        return choice2;
    }

    //Get choice 3 for Maths
    public String getChoice3Maths(int a) {
        String choice2 = mChoiceMaths[a][2];
        return choice2;
    }

    //Get choice 4 for English
    public String getChoice4Eng(int a) {
        String choice3 = mChoiceEng[a][3];
        return choice3;
    }

    //Get choice 4 for Science
    public String getChoice4Science(int a) {
        String choice3 = mChoiceScience[a][3];
        return choice3;
    }

    //Get choice 4 for BM
    public String getChoice4BM(int a) {
        String choice3 = mChoiceBM[a][3];
        return choice3;
    }

    //Get choice 4 for Maths
    public String getChoice4Maths(int a) {
        String choice3 = mChoiceMaths[a][3];
        return choice3;
    }

    //Get correct answer for English
    public String getCorrectEng(int a){
        String ans = mCorrectAnsEng[a];
        return ans;
    }

    //Get correct answer for Science
    public String getCorrectScience(int a){
        String ans = mCorrectAnsScience[a];
        return ans;
    }

    //Get correct answer for BM
    public String getCorrectBM(int a){
        String ans = mCorrectAnsBM[a];
        return ans;
    }

    //Get correct answer for Maths
    public String getCorrectMaths(int a){
        String ans = mCorrectAnsMaths[a];
        return ans;
    }

    //Get number of English questions by using length
    public int getLengthEng() {
        return mQuestionEng.length;
    }

    //Get number of Science questions by using length
    public int getLengthScience() {
        return mQuestionScience.length;
    }

    //Get number of BM questions by using length
    public int getLengthBM() {
        return mQuestionBM.length;
    }

    //Get number of Maths questions by using length
    public int getLengthMaths() {
        return mQuestionMaths.length;
    }

}

