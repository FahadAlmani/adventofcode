package Day2;

public class PartOne {
    public static void main(String[] args) {
        int totalSum = 0;
        String[] Games = ExerciseInput.exerciseInput.split("\n");
        for (String game : Games) {
            String[] rounds = game.split(";");
            String[] temp = rounds[0].split(":");
            int gameNumber = Integer.parseInt(temp[0].substring(5));
            rounds[0] = temp[1];
            boolean impossibleGame = false;
            for (String round:rounds) {
                if (impossibleGame) {
                    break;
                }
                int redCubes = 0;
                int greenCubes = 0;
                int blueCubes = 0;
                String[] plays = round.split(",");
                for (String play : plays) {
                    String[] numberAndColor = play.trim().split(" ");
                    switch (numberAndColor[1]) {
                        case "red" -> redCubes += Integer.parseInt(numberAndColor[0]);
                        case "green" -> greenCubes += Integer.parseInt(numberAndColor[0]);
                        case "blue" -> blueCubes += Integer.parseInt(numberAndColor[0]);
                    }
                    if (redCubes > RED_CUBES || greenCubes > GREEN_CUBES || blueCubes > BLUE_CUBES) {
                        impossibleGame = true;
                        break;
                    }
                }
            }
            if(!impossibleGame){
                totalSum+= gameNumber;
            }
        }

        System.out.println(totalSum);
    }

    public static final int RED_CUBES = 12;
    public static final int GREEN_CUBES = 13;
    public static final int BLUE_CUBES = 14;
}
