import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Main extends JFrame {
    private JLabel nameLabel;
    private JLabel numberLabel;
    private JTextField nameField;
    private JTextField numberField;
    private JButton confirmButton;
    private JTextArea scoreArea;

    private HashMap<String, HashMap<String, Integer>> scoreDict;

    public Main() {
        setTitle("考试科目分数查询程序");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 初始化字典
        scoreDict = new HashMap<>();
        HashMap<String, Integer> yangScores = new HashMap<>();
        yangScores.put("数学", 0);
        yangScores.put("语文", 0);
        yangScores.put("英语", 0);
        yangScores.put("政治", 0);
        yangScores.put("物理", 0);
        yangScores.put("化学", 0);
        yangScores.put("生物", 0);
        yangScores.put("地理", 0);
        yangScores.put("历史", 0);
        scoreDict.put("yangkao1", yangScores);

        HashMap<String, Integer> huangScores = new HashMap<>();
        huangScores.put("数学", 95);
        huangScores.put("语文", 80);
        huangScores.put("英语", 100);
        huangScores.put("政治", 69);
        huangScores.put("物理", 90);
        huangScores.put("化学", 100);
        huangScores.put("生物", 100);
        huangScores.put("地理", 100);
        huangScores.put("历史", 50);
        scoreDict.put("huangkao1", huangScores);

        // 创建界面组件
        nameLabel = new JLabel("考生姓名");
        numberLabel = new JLabel("考生号码");
        nameField = new JTextField();
        numberField = new JTextField();
        confirmButton = new JButton("确定");
        scoreArea = new JTextArea();
        scoreArea.setEditable(false);

        // 设置确定按钮的事件监听器
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String number = numberField.getText();
                if (scoreDict.containsKey(number)) {
                    HashMap<String, Integer> scores = scoreDict.get(number);
                    displayScores(name, number, scores);
                } else {
                    JOptionPane.showMessageDialog(null, "未找到对应考生信息");
                }
            }
        });

        // 添加组件到界面
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(numberLabel);
        inputPanel.add(numberField);
        add(inputPanel, BorderLayout.NORTH);
        add(scoreArea, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.SOUTH);

        // 显示界面
        setVisible(true);
    }

    private void displayScores(String name, String number, HashMap<String, Integer> scores) {
        StringBuilder sb = new StringBuilder();
        sb.append("考生姓名: ").append(name).append("，考生号码: ").append(number).append("\n");
        sb.append("科目成绩表格:\n");
        sb.append("-------------------------\n");
        int totalScore = 0;
        for (String subject : scores.keySet()) {
            int score = scores.get(subject);
            totalScore += score;
            sb.append(subject).append(": ").append(score).append("\n");
        }
        sb.append("-------------------------\n");
        sb.append("总分数: ").append(totalScore).append("\n");
        sb.append("版权信息: ©黄文定政府教育部考试成绩查询系统-考生").append(name).append("-Ⓥ黄文定2009-2023");
        scoreArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new Main();
    }
}
