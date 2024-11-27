package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer implements Player {
    private int lifes = 12;
    private final String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // All possible letters
    private final int[] letterWeights = {12, 9, 8, 6, 13, 6, 7, 9, 11, 2, 4, 8, 6, 10, 11, 7, 1, 10, 10, 9, 8, 4, 5, 2, 6, 1}; // Popularity-based weights
    private final Random random = new Random();

    @Override
    public int getLifes() {
        return lifes;
    }

    @Override
    public void decreaseLife() {
        if (lifes > 0) lifes--;
    }

    public char guessLetter(String notUsed) {
        List<Character> candidates = new ArrayList<>();
        List<Integer> candidateWeights = new ArrayList<>();

        for (int i = 0; i < allLetters.length(); i++) {
            char letter = allLetters.charAt(i);
            if (notUsed.contains(String.valueOf(letter))) {
                candidates.add(letter);
                candidateWeights.add(letterWeights[i]);
            }
        }
        return weightedRandomSelection(candidates, candidateWeights);
    }

    private char weightedRandomSelection(List<Character> items, List<Integer> weights) {
        int totalWeight = weights.stream().mapToInt(Integer::intValue).sum();
        int randomValue = random.nextInt(totalWeight);

        for (int i = 0; i < items.size(); i++) {
            randomValue -= weights.get(i);
            if (randomValue < 0) {
                return items.get(i);
            }
        }
        throw new IllegalStateException("Weighted random selection failed.");
    }
}
