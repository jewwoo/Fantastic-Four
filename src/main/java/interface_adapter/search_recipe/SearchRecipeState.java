package interface_adapter.search_recipe;

public class SearchRecipeState {
    private String keywords = "";
    private String keywordsError = null;
    public SearchRecipeState(SearchRecipeState copy){
        keywords = copy.keywords;
        keywordsError = copy.keywordsError;
    }

    public SearchRecipeState() {}

    public String getKeywords() {
        return keywords;
    }

    public String getKeywordsError() {
        return keywordsError;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setKeywordsError(String keywordsError) {
        this.keywordsError = keywordsError;
    }
}
