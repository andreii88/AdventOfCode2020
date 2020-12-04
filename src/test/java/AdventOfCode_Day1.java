import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode_Day1 extends Setup {

    @Test
    public void day1Problem() throws IOException {
        String[] dataInput = getDataInput("dataInput_day1.txt");
        List<Integer> accountingReport = new ArrayList<Integer>();

        for (String item : dataInput) {
            int nr = Integer.parseInt(item);
            accountingReport.add(nr);
        }
        for (int firstNr : accountingReport) {
            for(int secondNr : accountingReport) {
                int sum = firstNr + secondNr;
                if (sum == 2020) {
                    long response = firstNr * secondNr;
                    System.out.println(firstNr + " - " + secondNr + " --multiplied -> " + response);
                }
                if (sum < 2020) {
                    for(int thirdNr : accountingReport) {
                        int sum2 = sum + thirdNr;
                        if(sum2 == 2020) {
                            long response = firstNr * secondNr * thirdNr;
                            System.out.println(firstNr + " - " + secondNr + " - " + thirdNr + " --multiplied -> " + response);
                        }
                    }
                }
            }
        }

    }


}
