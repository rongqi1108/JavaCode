package counter.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  an app for counter
 * @Author: RQ
 * @Date: 2024-07-06 10:20:04
 */
public class CustomizableCounterApp extends JFrame {
    private Map<String, Counter> counters = new LinkedHashMap<>();
    private JTextField txtCounterName;
    private JTextField txtStartValue;
    private JTextField txtInterval;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnIncrement;
    private JButton btnDecrement;
    private JList<String> counterList;
    private DefaultListModel<String> listModel;

    // 定义计数器条目的数据结构
    class Counter {
        int value;
        int interval;

        Counter(int value, int interval) {
            this.value = value;
            this.interval = interval;
        }
    }

    public CustomizableCounterApp() {
        setTitle("自定义计数器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // 创建计数器控制面板
        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        controlPanel.setBorder(BorderFactory.createTitledBorder("计数器控制"));

        constraints.gridx = 0;
        constraints.gridy = 0;
        controlPanel.add(new JLabel("计数器名称：", SwingConstants.RIGHT), constraints);

        constraints.gridx = 1;
        txtCounterName = new JTextField(20); // 设置较大的尺寸
        controlPanel.add(txtCounterName, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        controlPanel.add(new JLabel("起始值：", SwingConstants.RIGHT), constraints);

        constraints.gridx = 1;
        txtStartValue = new JTextField(20); // 设置较大的尺寸
        controlPanel.add(txtStartValue, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        controlPanel.add(new JLabel("间隔值：", SwingConstants.RIGHT), constraints);

        constraints.gridx = 1;
        txtInterval = new JTextField(20); // 设置较大的尺寸
        controlPanel.add(txtInterval, constraints);

        btnAdd = new JButton("添加计数器");
        btnAdd.addActionListener(this::addCounter);
        controlPanel.add(btnAdd);

        btnRemove = new JButton("删除计数器");
        btnRemove.addActionListener(this::removeCounter);
        controlPanel.add(btnRemove);

        add(controlPanel, BorderLayout.NORTH);

        // 创建计数器列表
        counterList = new JList<>(listModel = new DefaultListModel<>());
        counterList.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(counterList);
        add(scrollPane, BorderLayout.CENTER);

        // 创建操作按钮面板
        JPanel buttonPanel = new JPanel();
        btnIncrement = new JButton("增加");
        btnIncrement.addActionListener(this::incrementCounter);
        buttonPanel.add(btnIncrement);

        btnDecrement = new JButton("减少");
        btnDecrement.addActionListener(this::decrementCounter);
        buttonPanel.add(btnDecrement);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addCounter(ActionEvent evt) {
        String name = txtCounterName.getText();
        int startValue = Integer.parseInt(txtStartValue.getText());
        int interval = Integer.parseInt(txtInterval.getText());
        if (!name.isEmpty() && startValue >= 0 && interval > 0) {
            Counter newCounter = new Counter(startValue, interval);
            counters.put(name, newCounter);
            listModel.addElement(name + " = " + startValue);
            clearTextFields();
        } else {
            JOptionPane.showMessageDialog(this, "计数器名称不能为空，起始值和间隔必须是正数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeCounter(ActionEvent evt) {
        int selectedIndex = counterList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedName = listModel.get(selectedIndex).split(" = ")[0];
            counters.remove(selectedName);
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "请选择要删除的计数器。", "选择错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void incrementCounter(ActionEvent evt) {
        modifySelectedCounter(1);
    }

    private void decrementCounter(ActionEvent evt) {
        modifySelectedCounter(-1);
    }

    private void modifySelectedCounter(int change) {
        int selectedIndex = counterList.getSelectedIndex();
        if (selectedIndex != -1) {
            String item = listModel.get(selectedIndex);
            String name = item.substring(0, item.indexOf(" = "));
            Counter counter = counters.get(name);
            int newValue = counter.value + change * counter.interval;
            counter.value = Math.max(newValue, 0); // 确保值不小于0
            String newItem = name + " = " + counter.value;
            listModel.set(selectedIndex, newItem);
        } else {
            JOptionPane.showMessageDialog(this, "请选择要修改的计数器。", "选择错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearTextFields() {
        txtCounterName.setText("");
        txtStartValue.setText("0");
        txtInterval.setText("1");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomizableCounterApp app = new CustomizableCounterApp();
            app.setVisible(true);
        });
    }
}