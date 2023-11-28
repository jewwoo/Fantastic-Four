package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeDetail extends JFrame{
    private JButton btnDone;
    private JTextField tfInput;
    private JEditorPane editorPane;
    private JLabel lbTitle;
    private JPanel detailPanel;
    private JButton btnBack;
    private JButton btnSave;
    private JLabel lbSave;

    public RecipeDetail(){
        setContentPane(detailPanel);
        setTitle("Recipe Detail");
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*End the search -> go to where? user account view?*/
                String input = tfInput.getText();
                System.out.println(input);
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Go back to RecipeList View*/
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Save the recipe in the user account*/
            }
        });
    }

    public static void main(String[] args) {
        RecipeDetail recipeDetail = new RecipeDetail();
    }
}
