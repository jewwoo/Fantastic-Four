package interface_adapter.list_recipe;

public class ListRecipeState {
    private String keywords = "";
    private String keywordsError = null;
    public ListRecipeState(ListRecipeState copy){
        keywords = copy.keywords;
        keywordsError = copy.keywordsError;
    }
    public ListRecipeState(){}
    public String getKeywords(){return keywords;}
    public String getKeywordsError() {
        return keywordsError;
    }
    public void setKeywords(String keywords){this.keywords=keywords;}
    public void setKeywordsError(String keywordsError) {
        this.keywordsError = keywordsError;
    }
}
