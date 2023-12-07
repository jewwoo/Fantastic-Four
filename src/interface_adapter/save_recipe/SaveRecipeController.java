package interface_adapter.save_recipe;

import use_case.save_recipe.SaveRecipeInputBoundary;
import use_case.save_recipe.SaveRecipeInputData;

public class SaveRecipeController {
    private final SaveRecipeInputBoundary saveRecipeInteractor;
    public SaveRecipeController(SaveRecipeInputBoundary saveRecipeInteractor){
        this.saveRecipeInteractor = saveRecipeInteractor;
    }

    public void saveRecipe(String username, String recipeId){
        SaveRecipeInputData saveRecipeInputData = new SaveRecipeInputData(username, recipeId);
        saveRecipeInteractor.saveRecipe(saveRecipeInputData);
    }
}
