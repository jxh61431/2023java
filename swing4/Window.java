package swing4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    JButton btn = null;
    JTextField text = null;

    public Window() {
        setSize(640, 480);
        setTitle("윈도우");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Window(String title, int width, int height) {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initBorderLayout() {

        //BorderLayout borderLayout = new BorderLayout(10, 50);
        //this.setLayout(borderLayout);

        String[] layoutTypes = {
                BorderLayout.NORTH,
                BorderLayout.SOUTH,
                BorderLayout.WEST,
                BorderLayout.EAST,
                BorderLayout.CENTER
        };

        for(String type : layoutTypes) {
            JButton btn = new JButton();
            btn.setText(type + " 버튼");
            add(btn, type);
        }

        setVisible(true);
    }


    public void initFlowLayout() {

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        setLayout(flowLayout);

        for (int i = 0; i < 10; i++) {
            JButton btn= new JButton((i + 1) + " 버튼");
            add(btn);
        }

        setVisible(true);
    }

    public void initGridLayout() {

        GridLayout gridLayout = new GridLayout(4, 3, 5, 5);
        setLayout(gridLayout);

        String[] numbers = {
                "7","8","9",
                "4","5","6",
                "1","2","3",
                "+","0","-",
        };

        for (String number : numbers) {
            JButton btn= new JButton(number);
            add(btn);
        }

        setVisible(true);
    }

    public void initBoxLayout() {

        Container container = this.getContentPane();

        BoxLayout boxLayout = new BoxLayout(container, BoxLayout.X_AXIS);
        setLayout(boxLayout);

        for (int i = 0; i < 10; i++) {
            JButton btn= new JButton((i + 1) + " 버튼");
            add(btn);
        }

        setVisible(true);
    }

    public void initLayout() {

        setLayout(null);


        for (int i = 0; i < 10; i++) {
            JButton btn= new JButton((i + 1) + " 버튼");
            btn.setSize(100, 40);
            btn.setLocation( i * 120, i * 10);
            add(btn);
        }

        //JLabel
        //JTextField
        setVisible(true);
    }

    public void initLoginLayout() {

        setLayout(null);

        JLabel idLabel = new JLabel("아이디: ");
        idLabel.setSize(100, 40);
        idLabel.setLocation(10, 10);
        add(idLabel);

        JTextField idText = new JTextField();
        idText.setSize(200, 40);
        idText.setLocation(120, 10);
        add(idText);

        JLabel passwordLabel = new JLabel("비밀번호: ");
        passwordLabel.setSize(100, 40);
        passwordLabel.setLocation(10, 60);
        add(passwordLabel);

        JTextField pwdText = new JTextField();
        pwdText.setSize(200, 40);
        pwdText.setLocation(120, 60);
        add(pwdText);

        JButton btnLogin = new JButton("로그인");
        btnLogin.setSize(200, 40);
        btnLogin.setLocation(200, 110);
        add(btnLogin);

        setVisible(true);
    }

    public void initLottoLayout() {

        setLayout(null);

        btn = new JButton("로또 번호 생성");
        btn.setBounds(10, 10, 200, 30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Lotto lotto = new Lotto();
                String numbers = lotto.createNumber();

                text.setText(numbers);
                //JOptionPane.showMessageDialog(null, "로또 번호:" + numbers);
            }
        });

        this.add(btn);

        text = new JTextField();
        text.setBounds(10, 110, 200, 30);
        this.add(text);

        setVisible(true);

    }



}