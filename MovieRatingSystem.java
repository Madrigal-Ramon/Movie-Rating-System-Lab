import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Step 1: User Input Handling
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
            System.out.println("Hello, " + userName + "!");

            // Step 2: Accept and Validate Movie Ratings
            String[] movieNames = new String[5];
            int[] movieRatings = new int[5];

            for (int i = 0; i < 5; i++) {
                System.out.print("Enter the name of movie " + (i + 1) + ": ");
                movieNames[i] = scanner.nextLine();

                while (true) {
                    System.out.print("Rate " + movieNames[i] + " (1-10): ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (rating >= 1 && rating <= 10) {
                        movieRatings[i] = rating;
                        break;
                    } else {
                        System.out.println("Invalid rating. Please enter a number between 1 and 10.");
                    }
                }
            }

            // Step 3: Calculate the Average Rating
            int totalRating = 0;
            for (int rating : movieRatings) {
                totalRating += rating;
            }
            double averageRating = totalRating / 5.0;
            System.out.printf("Your average movie rating is: %.2f\n", averageRating);

            // Step 4: Implement Rating Classification
            if (averageRating >= 9) {
                System.out.println("You are a cinephile!");
            } else if (averageRating >= 7) {
                System.out.println("You enjoy movies quite a bit.");
            } else if (averageRating >= 5) {
                System.out.println("You have mixed feelings about movies.");
            } else {
                System.out.println("You are a tough critic!");
            }

            // Step 5: Check for a Favorite Movie
            boolean hasMasterpiece = false;
            boolean hasLowRating = false;
            for (int rating : movieRatings) {
                if (rating == 10) {
                    hasMasterpiece = true;
                }
                if (rating < 4) {
                    hasLowRating = true;
                }
            }
            if (hasMasterpiece) {
                System.out.println("Wow! You found a masterpiece.");
            }
            if (hasLowRating) {
                System.out.println("These films didn't impress you much.");
            }

            // Step 6: Use Logical Operators to Identify Consistent Ratings
            boolean allHighRatings = true;
            boolean anyLowRating = false;
            for (int rating : movieRatings) {
                if (rating < 7) {
                    allHighRatings = false;
                }
                if (rating < 3) {
                    anyLowRating = true;
                }
            }
            if (allHighRatings) {
                System.out.println("You seem to enjoy most movies.");
            } else if (anyLowRating) {
                System.out.println("You have strong opinions on movies!");
            }

            // Step 7: Implement a switch Statement for Genre Preferences
            System.out.print("Enter your favorite genre (Action, Comedy, Horror, Drama, Sci-Fi): ");
            String favoriteGenre = scanner.nextLine();
            switch (favoriteGenre.toLowerCase()) {
                case "action" -> System.out.println("You love excitement and thrills!");
                case "comedy" -> System.out.println("You enjoy a good laugh.");
                case "horror" -> System.out.println("You have a taste for fear!");
                case "drama" -> System.out.println("You appreciate deep storytelling.");
                case "sci-fi" -> System.out.println("You love futuristic and imaginative worlds!");
                default -> System.out.println("That's an interesting choice!");
            }

            // Step 8: Use Multiple Conditional Operators for Movie Recommendations
            String recommendedMovie = favoriteGenre.equalsIgnoreCase("sci-fi") ? "Interstellar" :
                                    favoriteGenre.equalsIgnoreCase("action") ? "Avengers Endgame" :
                                    favoriteGenre.equalsIgnoreCase("comedy") ? "Garfield: The Movie" :
                                    favoriteGenre.equalsIgnoreCase("horror") ? "The Shining" :
                                    favoriteGenre.equalsIgnoreCase("drama") ? "Hidden Figures" :
                                    "Shrek"; // Default recommendation
            System.out.println("We recommend you watch: " + recommendedMovie);
        }
    }
}