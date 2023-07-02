# Java-queryscore
Java考生考试成绩查询程序
import javax.swing.*; 和 import java.awt.*; 导入了Swing和AWT的相关类。
public class Main extends JFrame { 定义了一个名为Main的类，并继承自JFrame类，表示这是一个窗口。
private JLabel nameLabel; 定义了私有成员变量nameLabel，表示姓名标签。
private JLabel numberLabel; 定义了私有成员变量numberLabel，表示号码标签。
private JTextField nameField; 定义了私有成员变量nameField，表示姓名输入框。
private JTextField numberField; 定义了私有成员变量numberField，表示号码输入框。
private JButton confirmButton; 定义了私有成员变量confirmButton，表示确定按钮。
private JTextArea scoreArea; 定义了私有成员变量scoreArea，表示显示分数的文本区域。
private HashMap<String, HashMap<String, Integer>> scoreDict; 定义了私有成员变量scoreDict，表示分数字典。
public Main() { ... } 是构造函数，用于初始化界面和相关的数据。
setTitle("考试科目分数查询程序"); 设置窗口的标题为"考试科目分数查询程序"。
setSize(400, 400); 设置窗口的大小为400x400像素。
setDefaultCloseOperation(EXIT_ON_CLOSE); 设置窗口关闭时默认的操作为退出程序。
setLayout(new BorderLayout()); 设置窗口的布局为边界布局(BorderLayout)。
scoreDict = new HashMap<>(); 初始化分数字典。
创建两个HashMap对象yangScores和huangScores，分别表示"yangkao1"和"huangkao1"两位考生的科目分数。
scoreDict.put("yangkao1", yangScores); 和 scoreDict.put("huangkao1", huangScores); 将考生和对应的科目分数放入分数字典中。
创建各个界面组件，包括标签、输入框、按钮和文本区域，并初始化它们的相关属性。
为确认按钮添加动作监听器，当按钮被点击时执行相应的代码。
将界面组件添加到窗口中的适当位置。
setVisible(true); 显示窗口。
private void displayScores(String name, String number, HashMap<String, Integer> scores) { ... } 是一个方法，用于在文本区域中显示考生的姓名、号码和各科目的分数。
public static void main(String[] args) { new Main(); } 是程序的入口点，创建Main对象启动程序的执行。
