import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventOfCode_Day4 extends Setup {
    private List<String> validPassports = new ArrayList<String>();

    private List<String> getPassportList() throws IOException {
        String[] dataInput = getDataInput("dataInput_day4.txt");
        List<String> dataInputRaw = new ArrayList<String>();
        List<String> passportList = new ArrayList<String>();
        StringBuilder passport = new StringBuilder();

        for(String item : dataInput) {
            if(item.contains(" ")) {
                String[] inlineList = item.split(" ");
                for(String inlineItem : inlineList){
                    dataInputRaw.add(inlineItem);
                }
            }
            else if(item.equals("")) {
                dataInputRaw.add(item + "-next-");
            }
            else{
                dataInputRaw.add(item);
            }
        }

        for(String item : dataInputRaw){
            if(!item.equals("-next-")) {
                passport.append(item + " ");
            }
            else{
                passportList.add(passport.toString());
                passport.setLength(0);
            }
        }

    return passportList;
    }

    private List<String> getValidPassports() throws IOException {
        List<String> passportList = getPassportList();
        int validPassportCounter = 0;

        for(String passport : passportList){
            String[] passportFields =  passport.split(" ");
            if(passportFields.length == 8) {
                validPassportCounter++;
                validPassports.add(passport);
            }
            else if (passportFields.length == 7) {
                int cidCounter = 0;
                for(String field : passportFields) {
                    if(field.contains("cid")){
                        cidCounter++;
                    }
                }
                if(cidCounter == 0) {
                    validPassportCounter++;
                    validPassports.add(passport);
                }
            }
        }
        System.out.println("Total Valid Passports -> " + validPassportCounter);
        return validPassports;
    }
    private Boolean fieldValidation(String key, String value) {
        boolean validation = true;
        if(key.equals("ecl")) {
            List<String> eclValues = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
            if(!eclValues.contains(value)){
                validation = false;
            }
        }
        else if(key.equals("byr")){
            int birthYear = Integer.parseInt(value);
            if(!(birthYear >= 1920 && birthYear <= 2002)) {
                validation = false;
            }
        }
        else if(key.equals("iyr")){
            int issueYear = Integer.parseInt(value);
            if(!(issueYear >= 2010 && issueYear <= 2020)) {
                validation = false;
            }
        }
        else if(key.equals("eyr")){
            int expirationYear = Integer.parseInt(value);
            if(!(expirationYear >= 2020 && expirationYear <= 2030)) {
                validation = false;
            }
        }
        else if(key.equals("pid")) {
            if(value.length() != 9) {
                validation = false;
            }
        }
        else if(key.equals("hgt")) {
            List<String> validUnits = Arrays.asList("cm", "in");
            String unit = value.substring(value.length()-2);
            if(!validUnits.contains(unit)) {
               validation = false;
            }
            else if(unit.equals("cm")){
                int numberValue = Integer.parseInt(value.replace(unit, ""));
                if(!(numberValue >= 150 && numberValue <= 193)){
                    validation = false;
                }
            }
            else if(unit.equals("in")){
                int numberValue = Integer.parseInt(value.replace(unit, ""));
                if(!(numberValue >= 59 && numberValue <= 76)){
                    validation = false;
                }
            }

        }
        else if(key.equals("hcl")) {
            if(!value.matches("#([0-9]|[a-f]){6}")){
                validation = false;
            }
        }

        return validation;
    }

    @Test
    public void day4Problem() throws IOException {
        validPassports = getValidPassports();
        int passportsWithValidFields = 0;
        for(String passport : validPassports){
            List<Boolean> validState = new ArrayList<Boolean>();
            String[] passportFields = passport.split(" ");
            for(String field : passportFields) {
                String key = field.split(":")[0];
                String value = field.split(":")[1];
                validState.add(fieldValidation(key, value));
            }
            if(!validState.contains(false)){
                passportsWithValidFields++;
            }
        }
        System.out.println("Total Passports with Valid fields: " + passportsWithValidFields);
    }


}
