package cop2805.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Gui extends JFrame implements ActionListener {
    JTextField searchField;
    JLabel quoteLabel;
    HashMap<Integer, String> map;
    public DefaultListModel<Integer> listModel;
    public JList<Integer> list;
    public Gui() {
        super("Hamlet Searcher");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel row = new JPanel();
        row.setLayout(new GridLayout(1, 2));
        row.setMaximumSize(new Dimension(this.getWidth(), 100));

        JPanel row2 = new JPanel();
        row2.setLayout(new GridLayout(1, 2));

        JPanel row3 = new JPanel();
        row3.setLayout(new GridLayout(1, 2));
        row3.setMaximumSize(new Dimension(this.getWidth(), 100));

        JPanel row4 = new JPanel();
        row4.setLayout(new GridLayout(1, 1));
        row4.setMaximumSize(new Dimension(this.getWidth(), 100));

        JLabel searchLabel = new JLabel("             Word to search:");
        this.searchField = new JTextField();
        JLabel searchResultsLabel = new JLabel("             Results:");

        this.quoteLabel = new JLabel("             Quote: ");
        this.listModel = new DefaultListModel<>();
        this.list = new JList<>(this.listModel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.list);
        this.list.setLayoutOrientation(JList.VERTICAL);


        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        JButton getQuoteButton = new JButton("Get Quote");
        getQuoteButton.addActionListener(this);

        row.add(searchLabel);
        row.add(this.searchField);
        row2.add(searchResultsLabel);
        row2.add(scrollPane);

        row3.add(searchButton);
        row3.add(getQuoteButton);
        row4.add(this.quoteLabel);

        this.add(row);
        this.add(row2);
        this.add(row3);
        this.add(row4);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String search = this.searchField.getText();
        this.quoteLabel.setText("             Quote: ");
        if (e.getActionCommand().equals("Search")) {
            this.listModel.clear();
            this.map = Client.request(search);
            for (Integer key : this.map.keySet()) {
                this.listModel.addElement(key);
            }
        } else if (e.getActionCommand().equals("Get Quote")) {
            Integer key = this.list.getSelectedValue();
            if (key != null) {
                this.quoteLabel.setText("             Quote:       " + this.map.get(key));
            }
        }
    }
}
