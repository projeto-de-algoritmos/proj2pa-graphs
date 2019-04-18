package view;

import model.Main;
import model.Pair;
import model.ViewGraph;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreatePage {
    private JTextField firstCreateIn;
    private JTextArea secondCreateIn;
    private JTextArea weightCreateIn;
    private JLabel titleCreateText;
    private JLabel firstCreateText;
    private JLabel secondCreateText;
    private JLabel weightCreateText;
    private JButton prontoCreateButton;
    private JLabel infoCreateText;
    private JPanel createPagePanel;
    private JButton proximoCreateButton;

    CreatePage(){
        JFrame createPage = new JFrame("Criar grafo");
        if(createPage!=null) {
            createPage.setContentPane(createPagePanel);
            createPage.setLocation(450, 250);
        }
        infoCreateText.setText("<html><body>Pesos com valor menor ou igual a zero ou caso a caixa de texto correspondentes ao peso esteja em branco, serão definidos iguais a 1.</body></html>");
        proximoCreateButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    int first = Integer.valueOf(firstCreateIn.getText());
                    int second = Integer.valueOf(secondCreateIn.getText());
                    Integer weight = Integer.valueOf(weightCreateIn.getText());
                    if(weight > 0){
                        System.out.println(weight);
                    }
                    else{
                        System.out.println("não é");
                    }
                    if(Integer.valueOf(weightCreateIn.getText()) <= 0){
                        weight = 1;
                    }
                    Main.grafo.get(first).add(new Pair(second, weight));
                    createPage.dispose();
                    new CreatePage();
                }catch (Exception error){
                    createPage.dispose();
                    new CreatePage();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        prontoCreateButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.ViewGraph v = new model.ViewGraph();
                v.createAndShowGUI(Main.grafo);
                createPage.dispose();
                new MainPage();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        createPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPage.pack();
        createPage.setVisible(true);
    }
}
