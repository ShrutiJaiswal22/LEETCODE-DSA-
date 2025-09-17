import java.util.*;

class FoodRatings {
    // Mappings
    private Map<String, String> foodToCuisine;     // food -> cuisine
    private Map<String, Integer> foodToRating;     // food -> rating
    private Map<String, TreeSet<String>> cuisineToFoods; // cuisine -> foods ordered

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int r1 = foodToRating.get(a);
                    int r2 = foodToRating.get(b);
                    if (r1 != r2) return r2 - r1; // higher rating first
                    return a.compareTo(b);       // lexicographically smaller first
                }
            ));

            cuisineToFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);

        // Remove old entry
        cuisineToFoods.get(cuisine).remove(food);

        // Update rating
        foodToRating.put(food, newRating);

        // Reinsert with updated rating
        cuisineToFoods.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
