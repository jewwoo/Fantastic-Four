package use_case.search;

import interface_adapter.search_form.SearchFormController;
import org.json.*;
import view.*;

import java.util.*;

public class RecipesDisplayer {
    
    public static void DisplayRecipes() {
        // Retrieve data from the controller
        JSONObject data = SearchFormController.getRecipeData();
        int arr_length = SearchFormController.getArrLength();
        int index = SearchFormController.getIndex();

        RecipeList recipeList = new RecipeList(null);
        
        index = displayRecipeLabels(data, index, arr_length, recipeList);
        SearchFormController.setindex(index);
    }    

    public static int displayRecipeLabels(JSONObject data, int index, int arr_length, RecipeList recipeList) {
        //System.out.println();
        HitsCls hits = new HitsCls(data, index, arr_length);
        String[] hitsArray = hits.getHitsArray();
        ArrayList<String> recipes = new ArrayList<>();

        if (arr_length == 1) {
            recipes.add(arr_length + " recipes was found.");
        } else if (arr_length >= 100) {
            recipes.add("100 recipes or more than 100 recipes were found");
        } else {
            recipes.add(arr_length + " recipes were found.");
        }

        for (int i = 0; i < 10; i++) {
            if (hitsArray[i] != null) {
                //System.out.println(hitsArray[i]);
                SearchFormController.setRecipeList(hitsArray[i]);
                recipes.add(hitsArray[i]);
                index++;
            }
        }
        // Update the RecipeList GUI with the recipes
        recipeList.updateRecipeList(recipes);
        return index;
    }
}
