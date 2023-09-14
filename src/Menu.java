public class Menu {
    // Initializing global array to store scores globally rather than per function.
   static int[] scoresArray = new int[7];

    public static void main(String[] args){
        // Initialize Scanner from IOScanner class
        IOScanner input = new IOScanner();
        // Initializing index for collection scores
        int questionIndex = 0;
        String resultString = "";

        // While Loop for collecting user data
        while (questionIndex < 7){
            String questionString = switch (questionIndex+1){
                case 1 -> "Enter the score for the 1st student ";
                case 2 -> "Enter the score for the 2nd student ";
                case 3 -> "Enter the score for the 3rd student ";
                case 4,5,6,7 -> "Enter the score for the " + (questionIndex+1) +"th student ";
                default -> "";
            };

            // Printing the prompt questions for the user.
            System.out.print(questionString);
            // Storing user input for each question in a scoresArray
            scoresArray[questionIndex] = input.getInt();

            // Input Validation - Score range 0-100
            if(scoresArray[questionIndex] >= 0 && scoresArray[questionIndex] <= 100){
                questionIndex++;
            } else {
                System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
            }
        }

        // Printing and formatting result & Calculating
        System.out.println("Thank you for your input. Your entered scores are: ");
        for(int i = 0; i < scoresArray.length; i++){
            if((i+1) != scoresArray.length){
                resultString += scoresArray[i]+", ";
            }
            else{
                resultString += scoresArray[i];
            }
        }
        System.out.println(resultString);

        // Controller variable used for controlling the do-while-loop
        boolean controller = true;
        // Initializing Menu with a do-while loop
        do {
            System.out.println("\nWelcome to the menu. Choose one of the options below:");
            System.out.println("1. Register new scores for students.");
            System.out.println("2. Print all registered grades.");
            System.out.println("3. Calculate the mean of the entered scores.");
            System.out.println("4. Find the two highest and two lowest scores.");
            System.out.println("5. Find the highest score and its position.");
            System.out.println("6. Collect hashtags from a post.");
            System.out.println("7. To exit.");
            System.out.println("\nType your option: ");

            // Initializing variable to get a responsive menu!
            int menuNumber = input.getInt();
            input.getNextLine();
            // Switch statement to call for the different functions in the menu.
            switch (menuNumber) {
                case 1 -> {
                    MenuFunctions.inputScores(input, scoresArray);
                }
                case 2 -> {
                    MenuFunctions.printScores(scoresArray);
                }
                case 3 -> {
                    MenuFunctions.calculatingMean(scoresArray);
                }
                case 4 -> {
                    MenuFunctions.highestScoresAndLowestScores(scoresArray);
                }
                case 5 -> {
                    MenuFunctions.highestScoreAndIndex(scoresArray);
                }
                case 6 -> {
                    MenuFunctions.collectingHashtags(input);
                }
                case 7 -> {
                    // Changing the boolean value to false and exits the program.
                    controller = MenuFunctions.closeProgram();
                }

            }
            // Input validation for menu. Only acceptable range between 1-7
            if(menuNumber < 1 || menuNumber > 7){
                System.out.println("Error - Invalid value. Please type between 1 and 7");
            }
        } while (controller);
        // Closing the scanner.
        input.closeScanner();
    }
}