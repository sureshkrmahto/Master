package com.iluwatar.intercepting.filter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * The Client class is responsible for handling the input and running them through filters inside
 * the {@link FilterManager}.
 *
 * <p>This is where {@link Filter}s come to play as the client pre-processes the request before
 * being displayed in the {@link Target}.
 *
 * @author Suresh Mahto
 */
public class Client extends JFrame { // NOSONAR

  private static final long serialVersionUID = 1L;

  private transient FilterManager filterManager;
  private final JLabel jl;
  private final JTextField[] jtFields;
  private final JTextArea[] jtAreas;
  private final JButton clearButton;
  private final JButton processButton;

  /**
   * Constructor.
   */
  public Client() {
    super("Client System");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(300, 300);
    jl = new JLabel("RUNNING...");
    jtFields = new JTextField[3];
    for (var i = 0; i < 3; i++) {
      jtFields[i] = new JTextField();
    }
    jtAreas = new JTextArea[2];
    for (var i = 0; i < 2; i++) {
      jtAreas[i] = new JTextArea();
    }
    clearButton = new JButton("Clear");
    processButton = new JButton("Process");

    setup();
  }

  private void setup() {
    setLayout(new BorderLayout());
    var panel = new JPanel();
    add(jl, BorderLayout.SOUTH);
    add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(6, 2));
    panel.add(new JLabel("Name"));
    panel.add(jtFields[0]);
    panel.add(new JLabel("Contact Number"));
    panel.add(jtFields[1]);
    panel.add(new JLabel("Address"));
    panel.add(jtAreas[0]);
    panel.add(new JLabel("Deposit Number"));
    panel.add(jtFields[2]);
    panel.add(new JLabel("Order"));
    panel.add(jtAreas[1]);
    panel.add(clearButton);
    panel.add(processButton);

    clearButton.addActionListener(e -> {
      Arrays.stream(jtAreas).forEach(i -> i.setText(""));
      Arrays.stream(jtFields).forEach(i -> i.setText(""));
    });

    processButton.addActionListener(this::actionPerformed);

    JRootPane rootPane = SwingUtilities.getRootPane(processButton);
    rootPane.setDefaultButton(processButton);
    setVisible(true);
  }

  public void setFilterManager(FilterManager filterManager) {
    this.filterManager = filterManager;
  }

  public String sendRequest(Order order) {
    return filterManager.filterRequest(order);
  }

  private void actionPerformed(ActionEvent e) {
    var fieldText1 = jtFields[0].getText();
    var fieldText2 = jtFields[1].getText();
    var areaText1 = jtAreas[0].getText();
    var fieldText3 = jtFields[2].getText();
    var areaText2 = jtAreas[1].getText();
    var order = new Order(fieldText1, fieldText2, areaText1, fieldText3, areaText2);
    jl.setText(sendRequest(order));
  }
}
