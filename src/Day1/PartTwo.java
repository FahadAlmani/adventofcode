package Day1;

public class PartTwo {

    public static void main(String[] args) {
        int totalSum = 0;
        String[] lineOfText = ExerciseInput.exerciseInput.split("\n");
        for (String line : lineOfText) {
            String firstNumber = null;
            String secondNumber = null;
            String subString = "";
            for (int i=0; i < line.length(); i++) {
                String charterer = String.valueOf(line.charAt(i));
                try {
                    Integer.parseInt(charterer);
                    if(firstNumber == null){
                        firstNumber =charterer;
                    }else {
                        secondNumber = charterer;
                    }
                    subString = "";
                }catch (NumberFormatException e){
                    boolean match = false;
                    subString += charterer;
                    for (String numberAsString: numberAsStringList) {
                        if (subString.length() > numberAsString.length()) {
                            continue;
                        }
                        for (int index = 0; index < subString.length(); index++) {
                            String numberAsStringNextCharterer  = String.valueOf(numberAsString.charAt(index));
                            String subStringNextCharterer = String.valueOf(subString.charAt(index));
                            if (numberAsStringNextCharterer.equals(subStringNextCharterer)) {
                                if (index == subString.length() - 1) {
                                    match = true;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if(match) {
                        String extractedNumber = convertStringToNumber(subString);
                        if (!extractedNumber.equals("NOT NUMBER")) {
                            if (firstNumber == null) {
                                firstNumber = extractedNumber;
                            } else {
                                secondNumber = extractedNumber;
                            }
                            subString = charterer;
                        }
                    }else {
                        subString = subString.substring(1);
                    }

                }
            }

            if(secondNumber != null){
                totalSum+= Integer.parseInt(firstNumber + secondNumber);
            }else {
                totalSum+= Integer.parseInt(firstNumber + firstNumber);
            }
        }
        System.out.println(totalSum);
    }
    private static final String[] numberAsStringList = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    public static String convertStringToNumber(String stringNumber){
        return switch (stringNumber) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> "NOT NUMBER";
        };
    }
}