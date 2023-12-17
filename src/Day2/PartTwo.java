package Day2;

public class PartTwo {
    public static void main(String[] args) {
        int totalSum = 0;
        String[] Games = ExerciseInput.exerciseInput.split("\n");
        for (String game : Games) {
            String[] rounds = game.split(";");
            rounds[0] = rounds[0].split(":")[1];
            int redCubes = 0;
            int greenCubes = 0;
            int blueCubes = 0;
            for (String round:rounds) {
                String[] plays = round.split(",");
                for (String play : plays) {
                    String[] numberAndColor = play.trim().split(" ");
                    switch (numberAndColor[1]) {
                        case "red" -> {
                            if (redCubes < Integer.parseInt(numberAndColor[0]))
                                redCubes = Integer.parseInt(numberAndColor[0]);
                        }
                        case "green" -> {
                            if (greenCubes < Integer.parseInt(numberAndColor[0]))
                                greenCubes = Integer.parseInt(numberAndColor[0]);
                        }
                        case "blue" -> {
                            if (blueCubes < Integer.parseInt(numberAndColor[0]))
                                blueCubes = Integer.parseInt(numberAndColor[0]);
                        }
                    }
                }
            }
                totalSum+= redCubes * greenCubes * blueCubes;
        }

        System.out.println(totalSum);
    }
}
