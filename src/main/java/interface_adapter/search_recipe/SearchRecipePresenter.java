package interface_adapter.search_recipe;

import interface_adapter.list_recipe.ListRecipeState;
import interface_adapter.list_recipe.ListRecipeViewModel;
import interface_adapter.ViewManagerModel;
import use_case.search_recipe.SearchRecipeOutputBoundary;
import use_case.search_recipe.SearchRecipeOutputData;
public class SearchRecipePresenter implements SearchRecipeOutputBoundary {
    private final SearchRecipeViewModel searchRecipeViewModel;
    private final ListRecipeViewModel listRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public SearchRecipePresenter(ViewManagerModel viewManagerModel,
                                 ListRecipeViewModel listRecipeViewModel,
                                 SearchRecipeViewModel searchRecipeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.listRecipeViewModel = listRecipeViewModel;
        this.searchRecipeViewModel = searchRecipeViewModel;
    }

    public void prepareSuccessView(SearchRecipeOutputData response) {
        // On success, switch to the logged in view.

        ListRecipeState loggedInState = listRecipeViewModel.getState();
        listRecipeState.setKeywords(response.getKeywords());
        this.listRecipeViewModel.setState(loggedInState);
        this.listRecipeViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(listRecipeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SearchRecipeState searchRecipeState = searchRecipeViewModel.getState();
        searchRecipeState.setKeywordsError(error);
        searchRecipeViewModel.firePropertyChanged();
    }


}
