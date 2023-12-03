package app;

import view.*;

public class Main {
    public static void main(String[] args) {
        // Run the SearchForm
        javax.swing.SwingUtilities.invokeLater(() -> {
            SearchForm searchForm = new SearchForm();
            searchForm.setSearchCompleteListener(recipeData -> {
                // Assuming you have the RecipeList implementation
                // Create an instance of RecipeList and display it
                RecipeList recipeList = new RecipeList(recipeData);
                recipeList.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                recipeList.setVisible(true);
            });
        });
    }
}
