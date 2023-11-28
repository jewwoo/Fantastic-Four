package interface_adapter.list_recipe;

import interface_adapter.detail_recipe.DetailRecipeState;
import interface_adapter.detail_recipe.DetailRecipeViewModel;
import interface_adapter.ViewManagerModel;
import use_case.list_recipe.ListRecipeOutputBoundary;
import use_case.list_recipe.ListRecipeOutputData;


public class ListRecipePresenter implements ListRecipeOutputBoundary{
    private final ListRecipeViewModel listRecipeViewModel;
    private final DetailRecipeViewModel detailRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public ListRecipePresenter(ViewManagerModel viewManagerModel,
                               DetailRecipeViewModel detailRecipeViewModel,
                          ListRecipeViewModel listRecipeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.detailRecipeViewModel = detailRecipeViewModel;
        this.listRecipeViewModel = listRecipeViewModel;
    }

    @Override
    public void prepareSuccessView(ListRecipeOutputData response) {
        // On success, switch to the logged in view.

        DetailRecipeState detailRecipeState = detailRecipeViewModel.getState();
        detailRecipeState.setUsername(response.getKeywords());
        this.detailRecipeViewModel.setState(loggedInState);
        this.detailRecipeViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(detailRecipeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ListRecipeState listRecipeState = listRecipeViewModel.getState();
        listRecipeState.setKeywordsError(error);
        listRecipeViewModel.firePropertyChanged();
    }
}
