package use_case.seach;

import interface_adapter.search.Controller;
import org.json.*;
import view.*;

import java.util.*;

public class SearchFilterOuputData {
    
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

        if (arr_length == 1) {
            recipes.add(arr_length + " recipes was found.");
        } else if (arr_length >= 100) {
            recipes.add("100 recipes or more than 100 recipes were found");
        } else {
            recipes.add(arr_length + " recipes were found.");
        }

        for (int i = 0; i < 10; i++) {
            if (hitsArray[i] != null) {
                Controller.setRecipeList(hitsArray[i]);
                recipes.add(hitsArray[i]);
                index++;
            }
        }
        // Update the RecipeList GUI with the recipes
        recipeList.updateRecipeList(recipes);
        return index;
    }

}