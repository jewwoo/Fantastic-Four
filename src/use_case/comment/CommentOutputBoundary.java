package use_case.comment;

public interface CommentOutputBoundary {
    void prepareSuccessView(CommentOutputData result);

    void goBackToRecipeDetail();
}
