import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.sql.*;

public class MainPage extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JTable table;
    private final DefaultTableModel model;
    private final DatabaseHelper dbHelper;

    public MainPage() {
        setTitle("货物管理系统V1.0.0");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dbHelper = new DatabaseHelper();

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JButton userManager = new JButton("用户管理");
        JButton warehouseManager = new JButton("仓库管理");
        JButton cargoManager = new JButton("货物管理");
        JButton reportManager = new JButton("报告管理");

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(userManager);
        panel.add(warehouseManager);
        panel.add(cargoManager);
        panel.add(reportManager);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);

        // 创建用户管理页面的右键菜单
        JPopupMenu userPopup = new JPopupMenu();
        JMenuItem addUserItem = new JMenuItem("添加用户");
        JMenuItem removeUserItem = new JMenuItem("删除用户");
        userPopup.add(addUserItem);
        userPopup.add(removeUserItem);

        // 创建仓库管理页面的右键菜单
        JPopupMenu warehousePopup = new JPopupMenu();
        JMenuItem addWarehouseItem = new JMenuItem("添加仓库");
        JMenuItem removeWarehouseItem = new JMenuItem("删除仓库");
        warehousePopup.add(addWarehouseItem);
        warehousePopup.add(removeWarehouseItem);

        userManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setColumnIdentifiers(new String[]{"用户名", "类型", "密码"});
                model.setRowCount(0);
                try {
                    ResultSet resultSet = dbHelper.getUsers();
                    while (resultSet.next()) {
                        String userName = resultSet.getString("user_name");
                        String userType = resultSet.getString("user_type");
                        String password = resultSet.getString("password");
                        model.addRow(new Object[]{userName, userType, password});
                    }
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                // 设置右键菜单
                table.setComponentPopupMenu(userPopup);
            }
        });

        warehouseManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setColumnIdentifiers(new String[]{"仓库名称", "位置"});
                model.setRowCount(0);
                try {
                    ResultSet resultSet = dbHelper.getWarehouses();
                    while (resultSet.next()) {
                        String warehouseName = resultSet.getString("warehouse_name");
                        String warehouseLocation = resultSet.getString("warehouse_location");
                        model.addRow(new Object[]{warehouseName, warehouseLocation});
                    }
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                // 设置右键菜单
                table.setComponentPopupMenu(warehousePopup);
            }
        });

        cargoManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setColumnIdentifiers(new String[]{"货物名称", "数量", "单价"});
                model.setRowCount(0);
                // 清空右键菜单
                table.setComponentPopupMenu(null);
            }
        });

        reportManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setColumnIdentifiers(new String[]{"报告名称", "日期"});
                model.setRowCount(0);
                // 清空右键菜单
                table.setComponentPopupMenu(null);
            }
        });

        addUserItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = JOptionPane.showInputDialog("请输入用户名");
                if (userName != null) {
                    String userType = JOptionPane.showInputDialog("请输入用户类型");
                    if (userType != null) {
                        String password = JOptionPane.showInputDialog("请输入用户初始化密码");
                        if (password != null) {
                            try {
                                dbHelper.addUser(userName, userType, password);
                                model.addRow(new Object[]{userName, userType, password});
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        removeUserItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) model.getValueAt(selectedRow, 0);
                    try {
                        dbHelper.removeUser(name);
                        model.removeRow(selectedRow);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
}
