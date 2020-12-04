import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode_Day3 extends Setup {

    public Integer countTreesGoingDownOneStep(int index) throws IOException {
        String[] slopes = getDataInput("dataInput_day3.txt");
        int treeCounter = 0;
        int step = index;
        for (int level = 0; level < slopes.length; level++) {
            StringBuilder slopeLevel = new StringBuilder(slopes[level]);
            if (level > 0) {
                while (index >= slopeLevel.length()) {
                    slopeLevel.append(slopeLevel);
                }
                String matcher = String.valueOf(slopeLevel.charAt(index));
                if (matcher.equals("#")) {
                    treeCounter++;
                }
                index = index + step;
            }
        }
        return  treeCounter;
    }

    public Integer countTreesGoingDownTwoSteps(int index) throws IOException {
        String[] slopes = getDataInput("dataInput_day3.txt");
        int treeCounter = 0;
        int step = index;
        for (int level = 0; level < slopes.length; level++) {
            StringBuilder slopeLevel = new StringBuilder(slopes[level]);
            if (level > 1 && (level % 2 == 0)) {
                while (index >= slopeLevel.length()) {
                    slopeLevel.append(slopeLevel);
                }
                String matcher = String.valueOf(slopeLevel.charAt(index));
                if (matcher.equals("#")) {
                    treeCounter++;
                }
                index = index + step;
            }
        }
        return  treeCounter;
    }

    @Test
    public void day3Problem() throws IOException {
        List<Integer> counterList = new ArrayList<Integer>();
        long result = 1;
        int[] horizontalIndex = new int[] {1, 3, 5, 7};
        for(int index : horizontalIndex) {
            if(index == 3) {
                System.out.println("Trees hit with the index: " + index + " -> " + countTreesGoingDownOneStep(index));
            }
            counterList.add(countTreesGoingDownOneStep(index));
        }
        counterList.add(countTreesGoingDownTwoSteps(1));
        for(int item : counterList) {
            result *= item;
        }
        System.out.println("Trees hit on all slopes(multiplied) -> " + result);
    }
}
