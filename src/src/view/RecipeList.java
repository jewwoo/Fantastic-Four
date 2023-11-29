package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeList extends JFrame{


    private JLabel lbResultNum;
    private JList listRecipe;
    private JButton btnOK;
    private JTextField tfInput;
    private JPanel listPanel;
    private JLabel lbTitle;

    public RecipeList(){
        setContentPane(listPanel);
        setTitle("Result");
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfInput.getText();
                System.out.println(input);
            }
        });
    }

    public static void main(String[] args) {
        RecipeList recipeList = new RecipeList();
    }
}
