package use_case;

import interface_adapter.*;
import org.json.*;
import view.*;

import java.util.*;

public class RecipesDisplayer {
    
    public static void DisplayRecipes() {
        // Retrieve data from the controller
        JSONObject data = Controller.getRecipeData();
        int arr_length = Controller.getArrLength();
        int index = Controller.getIndex();

        RecipeList recipeList = new RecipeList(null);
        
        index = displayRecipeLabels(data, index, arr_length, recipeList);
        Controller.setindex(index);
    }

    public static int displayRecipeLabels(JSONObject data, int index, int arr_length, RecipeList recipeList) {
        //System.out.println();
        HitsCls hits = new HitsCls(data, index, arr_length);
        String[] hitsArray = hits.getHitsArray();
        ArrayList<String> recipes = new ArrayList<>();
        if(hitsArray.length == 0){
            Controller.setRecipeList("no recipes found");
            recipes.add("no recipes found");
            return index;
        }
        for (int i = 0; i < 10; i++) {
            if (hitsArray[i] != null) {
                //System.out.println(hitsArray[i]);
                Controller.setRecipeList(hitsArray[i]);
                recipes.add(hitsArray[i]);
                index++;
            }
        }
        //System.out.println();
        // Update the RecipeList GUI with the recipes
        recipeList.updateRecipeList(recipes);
        return index;
    }

    //public static void displayRecipeDetails(int selectedIndex) {
    //    ArrayList<String> hitsArray = Controller.gethit();
    //    if (selectedIndex >= 0 && selectedIndex < hitsArray.size()) {
    //        String selectedRecipe = hitsArray.get(selectedIndex);
    //        // Assuming you want to print the details to the console for now
    //        System.out.println("Details for Recipe #" + (selectedIndex + 1) + ": " + selectedRecipe);
    //    } else {
    //        System.out.println("Invalid index. Please enter a valid recipe index.");
    //    }
    //}
}