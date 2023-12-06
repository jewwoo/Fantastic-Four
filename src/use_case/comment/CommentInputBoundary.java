package use_case.comment;

public interface CommentInputBoundary {
    void loadComment();

    void addNewComment(CommentInputData commentInputData);

    void goBackToRecipeDetail();
}
