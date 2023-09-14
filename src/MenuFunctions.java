public class MenuFunctions {

    public static void inputScores(IOScanner input, int[] scoresArray){
        int questionIndex = 0;

        // While Loop for collecting user data
        while (questionIndex < 7){
            String questionString = switch (questionIndex+1){
                case 1 -> "Enter the score for the 1st student ";
                case 2 -> "Enter the score for the 2nd student ";
                case 3 -> "Enter the score for the 3rd student ";
                case 4,5,6,7 -> "Enter the score for the " + (questionIndex+1) +"th student ";
                default -> "";
            };
            // Printing and storing user input for scores
            System.out.print(questionString);
            scoresArray[questionIndex] = input.getInt();

            // Input Validation - Score range between 0-100
            if(scoresArray[questionIndex] >= 0 && scoresArray[questionIndex] <= 100){
                questionIndex++;
            } else {
                System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
            }
        }
    }

    public static void printScores(int[] scoresArray){
        // For-loop to retrieve all the scores from the scoresArray
        // and then printing out the result.
        System.out.println("Your entered scores are:");
        for (int i = 0; i < scoresArray.length; i++) {
            if (i < 6) {
                System.out.print(scoresArray[i] + ", ");
            } else {
                System.out.println(scoresArray[i]);
            }
        }

    }

    public static void calculatingMean(int[] scoresArray){
        // Initializing new variable to collect the sum of all Scores
        double scoresSum = 0;
        // Using a for-loop to iterate over the array and getting the sum
        for (int i = 0; i < scoresArray.length; i++) {
            scoresSum += scoresArray[i];
        }

        // Using the value from above for-loop in a new double variable to calculate the average/mean
        double averageGrade = scoresSum / scoresArray.length;
        // Using printf to format the string to two decimals
        System.out.printf("The mean of the numbers is %.2f%n", averageGrade);    }

    public static void highestScoresAndLowestScores(int[] scoresArray){

        int lowest = scoresArray[0];
        int secondLowest = 101;
        int highest = 0;
        int secondHighest = 0;

        for (int i = 0; i < scoresArray.length; i++) {

            int values = scoresArray[i];

            if (values >= highest) {
                secondHighest = highest;
                highest = values;
            }
            else if (values > secondHighest) {
                secondHighest = values;
            }

            if (values <= lowest) {
                if(i == 0){
                    lowest = values;
                }
                else{
                    secondLowest = lowest;
                    lowest = values;
                }
            }
            else if (values < secondLowest) {
                secondLowest = values;
            }

        }
        System.out.printf("The two lowest scores provided are %d, and %d%n", lowest,secondLowest);
        System.out.printf("The two highest scores provided are %d, and %d%n", highest, secondHighest);
    }

    public static void highestScoreAndIndex(int[] scoresArray){
        // Initializing two new variables to get highest score and its index value
        int highestValue1 = scoresArray[0];
        int highestValueIndex = 0;
        // Using a for-loop to iterate over scoresArray and retrieving both score value and index
        for (int i = 0; i < scoresArray.length; i++) {
            if (highestValue1 < scoresArray[i]) {
                highestValue1 = scoresArray[i];
                highestValueIndex = i;
            }

        }
        // Using a Switch statement to print the highest value and its student position
        switch (highestValueIndex) {

            case 0 -> System.out.printf("The highest score is %s and belongs to the 1st student", highestValue1);
            case 1 -> System.out.printf("The highest score is %s and belongs to the 2nd student", highestValue1);
            case 2 -> System.out.printf("The highest score is %s and belongs to the 3rd student", highestValue1);
            case 3 -> System.out.printf("The highest score is %s and belongs to the 4th student", highestValue1);
            case 4 -> System.out.printf("The highest score is %s and belongs to the 5th student", highestValue1);
            case 5 -> System.out.printf("The highest score is %s and belongs to the 6th student", highestValue1);
            case 6 -> System.out.printf("The highest score is %s and belongs to the 7th student", highestValue1);
        }    }

    public static void collectingHashtags(IOScanner input){
        System.out.print("\nType your post: ");
        String hashtagString = input.getNextLine();

        // Creating an array of all words written in the prompt
        // Splitting the sentence by using regex, there s checks for whitespaces and + is a quantifier
        String[] wordArray = hashtagString.split("\\s+");
        String stringOfHashtags = "";

        // Boolean to check if there are an # or not
        boolean hashtagExists = false;

        // Looping through array with forEach loop
        for(String word : wordArray){

            //Java method to check if the word starts with #.
            // If there are any hashtags then it will concatenate to result string
            if(word.startsWith("#")){
                stringOfHashtags += word + " ";
                hashtagExists = true;
            }
        }

        // Ternary to create hashtag string
        String hashtagResult = hashtagExists ? "Hashtags found:" : "No hashtags were typed";
        // Formatting the final string
        System.out.printf("%s %s", hashtagResult, stringOfHashtags);
    }

    public static boolean closeProgram(){
        // Closing the menu and printing final message.
        System.out.println("Thank you for using our grading system. Have a nice day!");
        return false;
    }

}
