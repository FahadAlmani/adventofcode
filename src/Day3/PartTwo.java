package Day3;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    private static final String[] lines = ExerciseInput.exerciseInput.split("\n");
    public static void main(String[] args) {
        int totalSum = 0;
        for (int y = 0; y < lines.length; y++) {
            String currentLine = lines[y];
            for (int x = 0; x < currentLine.length(); x++) {
                String charterer = customCharAt(currentLine, x);
                boolean isSymbol = isSymbol(charterer);

                if(isSymbol){
                    int numberOfAdjacent = 0;
                    List<Integer> adjacentNumbers = new ArrayList<>();

                    String leftChar =customCharAt(currentLine, x - 1);
                    if(isNumber(leftChar)) {
                        adjacentNumbers.add(searchPreviousCharterers(x - 1, y));
                        numberOfAdjacent++;
                    }

                    String rightChar = customCharAt(currentLine, x + 1);
                    if(isNumber(rightChar)) {
                        adjacentNumbers.add(searchNextCharterers(x + 1, y));
                        numberOfAdjacent++;
                    }

                    if(y > 0) {
                        List<Integer> previousLineNumbers = searchAnotherLine(x, y - 1);
                        numberOfAdjacent += previousLineNumbers.size();
                        adjacentNumbers.addAll(previousLineNumbers);
                    }


                    if(y < lines.length - 1) {
                        List<Integer> nextLineNumbers = searchAnotherLine(x, y + 1);
                        numberOfAdjacent += nextLineNumbers.size();
                        adjacentNumbers.addAll(nextLineNumbers);

                    }

                    if(charterer.equals("*")){
                        if( numberOfAdjacent == 2)
                            totalSum += adjacentNumbers.get(0) * adjacentNumbers.get(1);
                    }
                }
            }
        }
        System.out.println(totalSum);
    }

    private static final String[] notSymbolList = {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "."
    };

    private static boolean isSymbol(String charterer){
        for (String notSymbol:notSymbolList) {
            if(charterer.equals(notSymbol))
                return false;
        }
        return true;
    }

    private static boolean isNumber(String charterer){
        try {
            if(charterer.equals("."))
                return false;

            Integer.parseInt(charterer);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private static String customCharAt(String string, int index){
        if(index < 0 || index > string.length() - 1)
            return "index out of bounds";
        return String.valueOf(string.charAt(index));
    }

    private static int searchPreviousCharterers(int x, int y){
        String subString = "";
        for(int index = x; index > -1; index--){
            String previousChar =customCharAt(lines[y], index);
            if(isNumber(previousChar))
                subString = previousChar + subString;
            else
                break;
        }
        return Integer.parseInt(subString);
    }

    private static int searchNextCharterers(int x, int y){
        String subString = "";
        for(int index = x; index < lines[y].length(); index++){
            String nextChar = customCharAt(lines[y], index);
            if(isNumber(nextChar))
                subString += nextChar ;
            else
                break;
        }
        return Integer.parseInt(subString);
    }

    private static List<Integer> searchAnotherLine(int x, int y){
        String line = lines[y];

        String Char = customCharAt(line, x);
        String LeftChar = customCharAt(line, x - 1);
        String RightChar = customCharAt(line, x + 1);
        boolean isAllNumber = isNumber(Char) && isNumber(LeftChar) && isNumber(RightChar);

        List<Integer> adjacentNumbers = new ArrayList<>();
        if(isAllNumber) {
            adjacentNumbers.add(searchNextCharterers(x - 1, y));
        }else  if (isNumber(Char)) {
            if(!isNumber(LeftChar) && !isNumber(RightChar)){
                adjacentNumbers.add(searchNextCharterers(x, y));
            }else {
                if (isNumber(LeftChar))
                    adjacentNumbers.add(searchPreviousCharterers(x, y));
                if (isNumber(RightChar))
                    adjacentNumbers.add(searchNextCharterers(x, y));
            }
        }else {
            if (isNumber(LeftChar))
                adjacentNumbers.add(searchPreviousCharterers(x - 1, y));
            if (isNumber(RightChar))
                adjacentNumbers.add(searchNextCharterers(x + 1, y));
        }
        return adjacentNumbers;
    }
}
