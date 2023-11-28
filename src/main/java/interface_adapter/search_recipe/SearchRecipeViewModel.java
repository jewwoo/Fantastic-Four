package interface_adapter.search_recipe;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class SearchRecipeViewModel extends ViewModel{
    public final String TITLE_LABEL = "Search Recipe View";
    public final String KEYWORDS_LABEL = "Enter keywords";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    private SearchRecipeState state = new SearchRecipeState();
    public SearchRecipeViewModel() {super("search recipe");}
    public void setState(SearchRecipeState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchRecipeState getState() {
        return state;
    }
}
