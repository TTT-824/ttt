package com.ttt;

import org.dom4j.DocumentException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static com.ttt.MainInterface.absolutelocal;

/*
登录功能
 */
public class LoginInterface extends JFrame {
    //定义全局变量 登陆页面的控件
    //主界面的content
    private JPanel contentPane;
    //用户名输入框
    private JTextField user_tf;
    //密码输入框
    private JPasswordField password_tf;
    //登录按钮
    private JButton login_bt;
    //注册按钮
    private JButton registe_bt;
    //注册账号>>>
    private JLabel registered_jl;
    //绝对地址
    public static String absolutelocal = "D:\\CodeSpeace\\TTT Player\\src\\xml\\myini.xml";
    //主方法
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //允许设置给jframe设置皮肤
        JFrame.setDefaultLookAndFeelDecorated(true);
        //设置皮肤
        UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
        //设置主界面的属性
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //创建对象本身 LoginInterface
                    LoginInterface frame = new LoginInterface();
                    //设置窗口可见;
                    frame.setVisible(true);
                    //设置窗口居中显示
                    frame.setLocationRelativeTo(null);
                    //设置窗口不能被放大
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //绘制主界面窗口
    public LoginInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //用户名输入框
        user_tf = new JTextField();
        user_tf.setBounds(137, 64, 229, 44);
        contentPane.add(user_tf);
        user_tf.setColumns(10);

        //密码输入框
        password_tf = new JPasswordField();
        password_tf.setBounds(137, 125, 229, 44);
        contentPane.add(password_tf);

        //用户名：
        JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
        lblNewLabel.setBounds(43, 63, 84, 44);
        contentPane.add(lblNewLabel);

        //密码：
        JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
        lblNewLabel_1.setBounds(43, 127, 84, 43);
        contentPane.add(lblNewLabel_1);

        //登录按钮
        login_bt = new JButton("\u767B\u5F55");
        login_bt.setBounds(137, 189, 84, 38);
        contentPane.add(login_bt);
        //给登录按钮添加点击事件
        login_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    login_bt_action(login_bt);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });

        //注册按钮
        registe_bt = new JButton("\u6CE8\u518C");
        registe_bt.setBounds(251, 189, 84, 38);
        contentPane.add(registe_bt);
        //给登录按钮添加点击事件
        registe_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    registe_bt_action(registe_bt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });

        //注册账号>>>入口
        registered_jl = new JLabel("\u6CE8\u518C\u8D26\u53F7>>");
        registered_jl.setBounds(0, 260, 92, 15);
        contentPane.add(registered_jl);
    }

    //登录按钮登录事件
    private void login_bt_action(JButton btnNewButton2) throws DocumentException {

        //获取登录的用户名和密码
        String username = user_tf.getText().toString();
        String password = String.valueOf((password_tf.getPassword()));
        //输出密码和用户名
        System.out.println("登录的用户名为："+username);
        System.out.println("登录用户密码为："+password);
        //判断用户名和密码是否正确
        //查询播放状态
        ParsingXML parsingXML = new ParsingXML();
        String XMLuser = parsingXML.QueryElementValve(absolutelocal,4,"username");
        String XMLpass = parsingXML.QueryElementValve(absolutelocal,4,"password");
        //输出密码和用户名
        System.out.println("登录的用户名为："+XMLuser);
        System.out.println("登录用户密码为："+XMLpass);
        //如果不正确就弹出提示框  正确就跳转首页
        if(username.equals(XMLuser) && password.equals(XMLpass)) {
            System.out.println("登陆成功");
            MainInterface maininterface = new MainInterface();
            maininterface.setVisible(true);
            this.dispose();
            maininterface.setLocationRelativeTo(null);
            maininterface.setResizable(false);
        } else {
            //登录失败弹出提示框
            System.out.println("登录失败");
            JOptionPane.showConfirmDialog(this,"请检查用户名或密码","登录提示",2,1);
        }

    }

    //
    public void registe_bt_action(JButton btnNewButton2) throws IOException, DocumentException {
        //获取注册的用户名和密码
        String username = user_tf.getText().toString();
        String password = String.valueOf((password_tf.getPassword()));
        //输出密码和用户名
        System.out.println("注册的用户名为："+username);
        System.out.println("注册的用密码为："+password);
        //将注册信息加入到XML文件
        //查询播放状态
        ParsingXML parsingXML = new ParsingXML();
        parsingXML.SetElementValue(absolutelocal,4,0,username);
        parsingXML.SetElementValue(absolutelocal,4,1,password);
        //注册成功弹出提示框
        System.out.println("注册成功");
        JOptionPane.showConfirmDialog(this,"注册成功","注册提示",2,1);
    }
}
