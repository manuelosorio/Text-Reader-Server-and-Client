package cop2805.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    JFrame frame;
    JTextField searchField;
    public DefaultListModel<Integer> listModel;
    public JList<Integer> list;
    public Gui() {
        super("Hamlet Searcher");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JPanel row = new JPanel();
        row.setLayout(new GridLayout(1, 2));
        row.setMaximumSize(new Dimension(this.getWidth(), 100));

        JPanel row2 = new JPanel();
        row2.setLayout(new GridLayout(1, 2));

        JLabel searchLabel = new JLabel("Word to search:");
        this.searchField = new JTextField();
        JLabel searchResultsLabel = new JLabel("Results:");

        this.listModel = new DefaultListModel<>();
        this.list = new JList<>(this.listModel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(this.list);
        this.list.setLayoutOrientation(JList.VERTICAL);

        JButton button = new JButton("Transmit");
        button.addActionListener(this);

        row.add(searchLabel);
        row.add(this.searchField);
        row2.add(searchResultsLabel);
        row2.add(scrollPane);

        this.add(row);
        this.add(row2);
        this.add(button);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String search = this.searchField.getText();
        this.listModel.clear();
        for (Integer result : Client.request(search)) {
            this.listModel.addElement(result);
        }
    }
}
