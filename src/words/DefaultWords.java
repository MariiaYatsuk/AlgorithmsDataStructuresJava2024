package words;

import java.util.Random;

public class DefaultWords implements Words {
    private static final String[] WORDS = {"EVEREST", "CINEMA", "APEX", "CLIMAX", "WISDOM", "PREMIERE", "HEREDITARY", "PRIMARY", "SEQUEL", "CUBE","APPLE", "WATER", "GREAT", "TABLE", "HOUSE", "DREAM"};
    private static final Random RANDOM = new Random();

    @Override
    public String provideWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
}
