import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import java.util.Objects;


/**
 * 创建LoginPage类，继承自JFrame类
 */
public class LoginPage extends JFrame {

    static LoginPage loginPageInstance;
    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField usernameField; // 用户名输入框
    private final JPasswordField passwordField; // 密码输入框

    /**
     * LoginPage构造方法
     */
    public LoginPage() {
        loginPageInstance = this;

        setTitle("货物管理系统V1.0.0"); // 设置窗口标题
        setSize(330, 200); // 设置窗口大小
        setLocationRelativeTo(null); // 将窗口居中显示
        setResizable(false); // 禁止改变窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个面板，使用GridBagLayout布局
        JPanel panel = new JPanel(new GridBagLayout());
        // 创建GridBagConstraints对象用于设置组件的布局约束
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel usernameLabel = new JLabel("用户名");
        JLabel passwordLabel = new JLabel("密码");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        // 设置文本框的高度
        usernameField.setPreferredSize(new Dimension(usernameField.getPreferredSize().width, 25));
        passwordField.setPreferredSize(new Dimension(passwordField.getPreferredSize().width, 25));

        JButton loginButton = new JButton("权限登录"); // 创建按钮
        JButton forgetButton = new JButton("忘记密码");

        usernameField.setText("admin");
        passwordField.setText("admin");

        // 用户名
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(usernameField, constraints);

        // 密码
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 10, 0);
        panel.add(loginButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 0, 10, 0);
        panel.add(forgetButton, constraints);

        add(panel); // 将面板添加到窗口中
        setVisible(true); // 显示窗口

        // 创建数据库连接
        DatabaseHelper databaseHelper = new DatabaseHelper();


        // 登录按钮的事件监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword()); // 获取密码输入框中的内容

                if (username.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入用户名和密码"); // 提示输入用户名和密码
                } else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入用户名"); // 提示输入用户名
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入密码"); // 提示输入密码
                } else if (databaseHelper.isValidUser(username, password) && Objects.equals(databaseHelper.getUserType(username), "admin")) { // 判断用户名和密码是否正确
                    dispose(); // 关闭登录窗口
                    new UserInfo(username, databaseHelper.getUserType(username));
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误"); // 提示密码错误
                }
            }
        });


        // 忘记密码按钮的事件监听器
        forgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(java.net.URI.create("https://www.baidu.com"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}




