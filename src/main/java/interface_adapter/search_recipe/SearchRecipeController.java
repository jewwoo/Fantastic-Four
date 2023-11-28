package interface_adapter.search_recipe;

import use_case.login.LoginInputData;
import use_case.search_recipe.SearchRecipeInputData;
import use_case.search_recipe.SearchRecipeInputBoundary;

public class SearchRecipeController {
    final SearchRecipeInputBoundary searchRecipeUseCaseInteractor;
    public SearchRecipeController(SearchRecipeInputBoundary searchRecipeUseCaseInteractor){
        this.searchRecipeUseCaseInteractor = searchRecipeUseCaseInteractor;
    }

    public void execute(String keywords) {
        SearchRecipeInputData searchRecipeInputData = new SearchRecipeInputData(
                keywords);

        searchRecipeUseCaseInteractor.execute(searchRecipeInputData);
    }
}
