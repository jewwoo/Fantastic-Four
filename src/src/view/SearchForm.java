package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchForm extends JFrame {
    private JPanel searchPanel;
    private JButton btnSearch;
    private JLabel lbTitle;
    private JLabel lbKeywords;
    private JTextField tfKeywords;
    private JPanel pnFilterBy;
    private JList listDiet;
    private JLabel lbFilterBy;
    private JList listHealth;
    private JList listMealType;
    private JList listDishType;
    private JList listCuisineType;
    private JPanel pnFilterByDiet;
    private JPanel pnFilterByHealth;
    private JPanel pnFilterByMealType;
    private JPanel pnFilterByDishType;
    private JPanel pnFilterByCuisineType;

    public SearchForm(){
        setContentPane(searchPanel);
        setTitle("Search");
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = tfKeywords.getText();
                System.out.println(keywords);
                System.out.println(listDiet.getSelectedValuesList());
                System.out.println(listHealth.getSelectedValuesList());
                System.out.println(listMealType.getSelectedValuesList());
                System.out.println(listDishType.getSelectedValuesList());
                System.out.println(listCuisineType.getSelectedValuesList());


            }
        });
    }


    public static void main(String[] args) {
        SearchForm searchform = new SearchForm();
    }
}
