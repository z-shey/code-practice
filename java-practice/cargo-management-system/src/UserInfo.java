import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class UserInfo extends JFrame {
    @Serial
    private static final long serialVersionUID = 2L;

    public UserInfo(String username, String userType) {
        setTitle("确认信息");
        setSize(330, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel userTypeLabel = new JLabel(userType);
        JLabel usernameLabel = new JLabel("欢迎回来 " + username);

        usernameLabel.setFont(usernameLabel.getFont().deriveFont(16.0f));
        userTypeLabel.setFont(userTypeLabel.getFont().deriveFont(16.0f));


        JButton confirmButton = new JButton("   确认   ");
        JButton cancelButton = new JButton("   取消   ");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(userTypeLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(usernameLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 0, 0, 200);
        panel.add(confirmButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 200, 0, 0);
        panel.add(cancelButton, constraints);



        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainPage();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 关闭当前窗口
                LoginPage.loginPageInstance.setVisible(true); // 重新显示之前的登录页面
            }
        });

        add(panel);
        setVisible(true);
    }
}