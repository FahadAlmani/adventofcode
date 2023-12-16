package Day1;

public class PartOne {
    public static void main(String[] args) {
        int totalSum = 0;
        String[] lineOfText = ExerciseInput.exerciseInput.split("\n");
        for (String line : lineOfText) {
            String firstNumber = null;
            String secondNumber = null;
            for (int i=0; i < line.length(); i++) {
                String charterer = String.valueOf(line.charAt(i));
                try {
                    Integer.parseInt(charterer);
                    if(firstNumber == null){
                        firstNumber =charterer;
                    }else {
                        secondNumber = charterer;
                    }
                }catch (NumberFormatException e){}
            }

            if(secondNumber != null){
                totalSum+= Integer.parseInt(firstNumber + secondNumber);
            }else {
                totalSum+= Integer.parseInt(firstNumber + firstNumber);
            }
        }
        System.out.println(totalSum);
    }
}
