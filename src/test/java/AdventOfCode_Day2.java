import org.junit.Test;

import java.io.IOException;

public class AdventOfCode_Day2 extends Setup {

    @Test
    public void day2ProblemPartOne() throws IOException {
    String[] database = getDataInput("dataInput_day2.txt");
    int correctPasswords = 0;
        for (String counter : database) {
            String[] databaseGroup = counter.split(" ");
            String[] pwLength = databaseGroup[0].split("-");
            int minLength = Integer.parseInt(pwLength[0]);
            int maxLength = Integer.parseInt(pwLength[1]);
            String matchingLetter = databaseGroup[1].substring(0, 1);
            String password = databaseGroup[2];
            int letterCount = 0;
            if (password.contains(matchingLetter)) {
                for (int i = 0; i < password.length(); i++) {
                    if (String.valueOf(password.charAt(i)).equals(matchingLetter)) {
                        letterCount++;
                    }
                }
            }
            if (letterCount >= minLength && letterCount <= maxLength) {
                correctPasswords++;
            }
        }
        System.out.println("The number of correct passwords is -> " + correctPasswords);
    }

    @Test
    public void day2ProblemPartTwo() throws IOException {
        String[] database = getDataInput("dataInput_day2.txt");
        int correctCombinations = 0;
        for (String counter : database) {
            String[] databaseGroup = counter.split(" ");
            String[] pwLength = databaseGroup[0].split("-");
            int firstPosition = Integer.parseInt(pwLength[0]);
            int secondPosition = Integer.parseInt(pwLength[1]);
            String matchingLetter = databaseGroup[1].substring(0, 1);
            String password = databaseGroup[2];
            if (password.contains(matchingLetter)) {
                String firstIndex = String.valueOf(password.charAt(firstPosition - 1));
                String secondIndex = String.valueOf(password.charAt(secondPosition - 1));
                if ((firstIndex.equals(matchingLetter) && !secondIndex.equals(matchingLetter)) || (!firstIndex.matches(matchingLetter) && secondIndex.matches(matchingLetter))) {
                    correctCombinations++;
                }
            }
        }
        System.out.println("The number of correct passwords is -> " + correctCombinations);
    }

}
