package view;


import interface_adapter.search_recipe.SearchRecipeController;
import interface_adapter.search_recipe.SearchRecipeState;
import interface_adapter.search_recipe.SearchRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchRecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "search recipe";
    private final SearchRecipeViewModel searchRecipeViewModel;
    final JTextField keywordsInputField = new JTextField(15);
    private final JLabel keywordsErrorField = new JLabel();
    final JButton search;
    private final SearchRecipeController searchRecipeController;
    public SearchRecipeView(SearchRecipeViewModel searchRecipeViewModel, SearchRecipeController controller){
        this.searchRecipeController = controller;
        this.searchRecipeViewModel = searchRecipeViewModel;
        this.searchRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Search Recipe Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);;

        LabelTextPanel keywordsInfo = new LabelTextPanel(
                new JLabel("keywords"), keywordsInputField);

        JPanel buttons = new JPanel();
        search = new JButton(searchRecipeViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        search.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        if (evt.getSource().equals(search)) {
                            SearchRecipeState currentState = SearchRecipeViewModel.getState();

                            SearchRecipeController.execute(
                                    currentState.getKeywords()
                            );
                        }
                    }
                }
        );

        keywordsInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SearchRecipeState currentState = SearchRecipeViewModel.getState();
                currentState.setKeywords(keywordsInputField.getText() + e.getKeyChar());
                SearchRecipeViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(keywordsInfo);
        this.add(keywordsErrorField);
        this.add(buttons);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchRecipeState state = (SearchRecipeState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(SearchRecipeState state) {
        keywordsInputField.setText(state.getKeywords());
    }
}
