package interface_adapter.detail_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class DetailRecipeViewModel extends ViewModel{
    public final String TITLE_LABEL = "Detail Recipe View";

    private DetailRecipeState state = new DetailRecipeState();


    public DetailRecipeViewModel() {
        super("detail recipe");
    }

    public void setState(DetailRecipeState state) {
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

    public DetailRecipeState getState() {
        return state;
    }


}
