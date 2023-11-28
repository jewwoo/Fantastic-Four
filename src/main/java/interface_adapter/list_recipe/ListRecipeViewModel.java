package interface_adapter.list_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ListRecipeViewModel extends ViewModel{
    public final String TITLE_LABEL = "List Recipe View";
    private ListRecipeState state = new ListRecipeState();
    public static final String SELECT_BUTTON_LABEL = "select";

    public ListRecipeViewModel(){super("list recipe");}

    public void setState(ListRecipeState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ListRecipeState getState() {
        return state;
    }

}
