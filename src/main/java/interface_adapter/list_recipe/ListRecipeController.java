package interface_adapter.list_recipe;

import use_case.list_recipe.ListRecipeInputData;
import use_case.list_recipe.ListRecipeInputBoundary;


public class ListRecipeController {
    final ListRecipeInputBoundary listRecipeUseCaseInteractor;
    public ListRecipeController(ListRecipeputBoundary listRecipeUseCaseInteractor) {
        this.listRecipeUseCaseInteractor = listRecipeUseCaseInteractor;
    }


    public void execute(String recipes) {
        ListRecipeInputData listRecipeInputData = new ListRecipeInputData(
                recipes);

        listRecipeUseCaseInteractor.execute(listRecipeInputData);
    }
}
