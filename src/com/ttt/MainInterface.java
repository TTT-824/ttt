package com.ttt;

import org.dom4j.DocumentException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/*
主界面
 */
public class MainInterface extends JFrame {
    //定义全局变量
    //主界面jpanel
    private JPanel contentPane;
    //头像
    private JLabel avatar;
    //本地音乐
    private JLabel localmusic;
    //我的喜欢
    private JLabel myliking;
    //我的歌单
    private JLabel myplaylist;
    //更多音乐
    private JLabel moremusic;
    //音乐库
    private JLabel musiclibrary;
    //随机播放
    private JLabel shuffleplayback;
    //批量操作
    private JLabel bulkoperations;
    //扫描音乐
    private JLabel scanmusic;
    //音乐位置
    private JLabel musiclocation;
    //左边底层pane 
    private JDesktopPane leftdesktopPane;
    //中间底层pane
    private JDesktopPane bottondesktopPane;
    //中间的滚动列表
    private JScrollPane scrollPane;
    //播放 / 暂停按钮
    private static JLabel playorstop;
    //上一曲
    private JLabel prevsionsong;
    //下一曲
    private JLabel nextsong;
    //滑动条
    private static JSlider slider;
    //表格行模型
    private static String[][] rowData;
    //表格对象
    private static JTable table11;
    //播放音乐的题目
    private static JLabel mylab5;
    //扫描到的文件下面的文件名列表
    private static List doclist;
    //扫描/设置文件夹对象
    private static GetDocumentList listdocu;
    //java文件管理器窗口
    private JFileChooser jfc;
    //音乐播放器对象
    private MusicPlayer mn;
    //绝对地址
    public static String absolutelocal = "D:\\CodeSpeace\\TTT Player\\src\\xml\\myini.xml";
    //进度条定时器
    private static Timer timer;
    //
    private static SimulatedProgressPar simu;
    //首页方法 页面  主界面
    public MainInterface() {

        mn = new MusicPlayer();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 980, 606);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("ComboBox.buttonHighlight"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //左边的panel
        leftdesktopPane = new JDesktopPane();
        leftdesktopPane.setBounds(0, 0, 200, 497);
        leftdesktopPane.setBackground(UIManager.getColor("ComboBox.disabledBackground"));
        contentPane.add(leftdesktopPane);

        //头像
        avatar = new JLabel("");
        avatar.setHorizontalAlignment(SwingConstants.CENTER);
        avatar.setIcon(new ImageIcon(MainInterface.class.getResource("/img/icon.png")));
        avatar.setBounds(10, 10, 100, 100);
        leftdesktopPane.add(avatar);

        //更多音乐
        moremusic = new JLabel("更多音乐");
        moremusic.setIcon(new ImageIcon(MainInterface.class.getResource("/img/tianqi_4.png")));
        moremusic.setHorizontalAlignment(SwingConstants.LEFT);
        moremusic.setBounds(10, 269, 180, 43);
        moremusic.setOpaque(true);
        moremusic.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                selectedEvent(moremusic);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根
            }
        });
        leftdesktopPane.add(moremusic);

        //我的歌单
        myplaylist = new JLabel("我的歌单");
        myplaylist.setIcon(new ImageIcon(MainInterface.class.getResource("/img/ziliao_3.png")));
        myplaylist.setOpaque(true);
        myplaylist.setHorizontalAlignment(SwingConstants.LEFT);
        myplaylist.setBounds(10, 216, 180, 43);
        myplaylist.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                selectedEvent(myplaylist);
            }
        });
        leftdesktopPane.add(myplaylist);

        //我的喜欢
        myliking = new JLabel("我的喜欢");
        myliking.setIcon(new ImageIcon(MainInterface.class.getResource("/img/dianzan_2.png")));
        myliking.setOpaque(true);
        myliking.setHorizontalAlignment(SwingConstants.LEFT);
        myliking.setBounds(10, 163, 180, 43);
        myliking.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                selectedEvent(myliking);
            }
        });
        leftdesktopPane.add(myliking);

        //本地音乐
        localmusic = new JLabel("本地音乐");
        localmusic.setIcon(new ImageIcon(MainInterface.class.getResource("/img/yinle_1.png")));
        localmusic.setOpaque(true);
        localmusic.setHorizontalAlignment(SwingConstants.LEFT);
        localmusic.setBounds(10, 115, 180, 43);
        localmusic.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                selectedEvent(localmusic);
            }
        });
        leftdesktopPane.add(localmusic);

        //下面的底部面板
        bottondesktopPane = new JDesktopPane();
        bottondesktopPane.setBounds(0, 500, 980, 106);
        bottondesktopPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) SystemColor.control));
        bottondesktopPane.setBackground(Color.WHITE);
        contentPane.add(bottondesktopPane);

        //上一曲
        prevsionsong = new JLabel("");
        prevsionsong.setBounds(20, 25, 30, 30);
        bottondesktopPane.add(prevsionsong);
        prevsionsong.setHorizontalAlignment(SwingConstants.CENTER);
        prevsionsong.setIcon(new ImageIcon(MainInterface.class.getResource("/img/back_left.png")));

        //下一曲
        nextsong = new JLabel("");
        nextsong.setIcon(new ImageIcon(MainInterface.class.getResource("/img/back_right.png")));
        nextsong.setHorizontalAlignment(SwingConstants.CENTER);
        nextsong.setBounds(187, 25, 30, 30);
        bottondesktopPane.add(nextsong);

        //播放  暂停
        playorstop = new JLabel("");
        playorstop.setIcon(new ImageIcon(MainInterface.class.getResource("/img/restart.png")));
        playorstop.setHorizontalAlignment(SwingConstants.CENTER);
        playorstop.setBounds(100, 18, 45, 45);
        playorstop.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                stopOrStart();
            }
        });
        bottondesktopPane.add(playorstop);

        //滑动条
        slider = new JSlider(0, 100, 0);
        slider.setBackground(Color.WHITE);
        slider.setValue(0);
        slider.setBounds(316, 39, 598, 26);
        bottondesktopPane.add(slider);

        //播放音乐的题目
        mylab5 = new JLabel("当前没有播放音乐");
        mylab5.setBounds(316, 10, 257, 30);
        bottondesktopPane.add(mylab5);

        //表格对象
        table11 = new JTable(0, 2);
        table11.getTableHeader().setVisible(false);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setPreferredSize(new Dimension(0, 0));
        table11.getTableHeader().setDefaultRenderer(renderer);
        table11.setBorder(null);
        table11.setRowHeight(40);
        //双击播放事件
        table11.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                //双击播放事件
                try {
                    doubleClickToPlay(e);
                } catch (DocumentException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //中间的滚动列表
        scrollPane = new JScrollPane(table11);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(210, 98, 754, 399);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.getVerticalScrollBar().setUI(null);
        contentPane.add(scrollPane);

        //随机播放
        shuffleplayback = new JLabel("  \u968F\u673A\u64AD\u653E");
        shuffleplayback.setIcon(new ImageIcon(MainInterface.class.getResource("/img/guanli_5.png")));
        shuffleplayback.setBounds(210, 51, 116, 32);
        contentPane.add(shuffleplayback);

        //批量操作
        bulkoperations = new JLabel("  \u6279\u91CF\u64CD\u4F5C");
        bulkoperations.setIcon(new ImageIcon(MainInterface.class.getResource("/img/shezhi_6.png")));
        bulkoperations.setBounds(350, 51, 106, 32);
        contentPane.add(bulkoperations);

        //音乐库
        musiclibrary = new JLabel("\u97F3\u4E50\u5E93");
        musiclibrary.setFont(new Font("宋体", Font.BOLD, 14));
        musiclibrary.setBounds(210, 10, 116, 31);
        contentPane.add(musiclibrary);

        //扫描音乐
        scanmusic = new JLabel("\u626B\u63CF\u97F3\u4E50");
        scanmusic.setIcon(new ImageIcon(MainInterface.class.getResource("/img/sousuo_7.png")));
        scanmusic.setBounds(490, 51, 106, 32);
        scanmusic.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                scannerMusic();
            }
        });
        contentPane.add(scanmusic);

        //音乐文件夹位置设置
        musiclocation = new JLabel("\u97F3\u4E50\u4F4D\u7F6E");
        musiclocation.setIcon(new ImageIcon(MainInterface.class.getResource("/img/wenjianjia_8.png")));
        musiclocation.setBounds(630, 51, 106, 32);
        //设置点击事件setMusicLocation
        musiclocation.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                //调用设置音乐文件夹方法
                setMusicLocation();
            }
        });
        contentPane.add(musiclocation);

        //初始化面板
        initFunction();
        /*
        每次初始化面板后（就是打开程序）要把播放状态恢复到false
        因为要防止异常情况下关闭程序导致初始化播放状态始终为true
         */
        //new出ParsingXML对象
        ParsingXML parsingXML = new ParsingXML();
        try {
            parsingXML.SetElementValue(absolutelocal, 1, 0, "false");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设置音乐文件夹位置
    protected void setMusicLocation() {
        //new一个文件管理器空间
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(1);
        // 显示创建的文件管理器
        jfc.showOpenDialog(null);
        // 获取选择的文件
        File f = jfc.getSelectedFile();
        // 获取选择的文件的路径
        //try:设置路径为空
        try {
            String s = f.getAbsolutePath();
            System.out.println("用户设置了音乐扫描文件夹：" + s);
            //将扫描到的文件路径set给扫描对象
            listdocu = new GetDocumentList();
            listdocu.Set_Document_Path(s);
        }catch (NullPointerException nullexception){
            System.out.println("用户未选择路径: "+nullexception);
        }
    }

    //	扫描音乐方法
    protected static void scannerMusic() {
        //设置默认model
        //判断文件路径是否为空
        GetXmlDom domxml = new GetXmlDom();
        List list = domxml.startXML("/xml/myini.xml", "musiclocal", 0);
        if (!list.isEmpty()) {
            //输出获取到的xml文件结果
            String filenames = String.valueOf(list.get(0));
            //将扫描到的文件路径set给扫描对象
            listdocu = new GetDocumentList();
            listdocu.Set_Document_Path(filenames);
            doclist = listdocu.Get_List();
            //像表格填充数据
            tableFillData(doclist);
        } else if (listdocu.Get_Document_Path().equals("isNull")) {
            System.out.println("文件路径为空");
        } else {
            doclist = listdocu.Get_List();
            rowData = new String[doclist.size()][1];
            //向列表填充数据
            for (int i = 0; i < doclist.size(); i++) {
                for (int j = 0; j < rowData[i].length; j++) {
                    rowData[i][j] = String.valueOf("  " + doclist.get(i));
                }
            }
            Object[] columnNames = {"A"};
            DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // TODO 自动生成的方法存根
                    return false;
                }
            };
            table11.setModel(model);
        }
    }

    //左边选中事件
    protected void selectedEvent(JLabel jLabel) {
        if (jLabel == localmusic) {
            jLabel.setBackground(Color.orange);
            myliking.setBackground(null);
            myplaylist.setBackground(null);
            moremusic.setBackground(null);
            tableFillData(doclist);
            System.out.println("成功替换");
        } else if (jLabel == myliking) {
            jLabel.setBackground(Color.orange);
            localmusic.setBackground(null);
            myplaylist.setBackground(null);
            moremusic.setBackground(null);
            //我的喜欢  替换表格数据
            List listss = new ArrayList();
            tableFillData(listss);
            System.out.println("成功ranchu");
        } else if (jLabel == myplaylist) {
            jLabel.setBackground(Color.orange);
            localmusic.setBackground(null);
            myliking.setBackground(null);
            moremusic.setBackground(null);
            //我的歌单  替换表格数据
            List listss = new ArrayList();
            tableFillData(listss);
            System.out.println("成功ranchu");
        } else if (jLabel == moremusic) {
            jLabel.setBackground(Color.orange);
            localmusic.setBackground(null);
            myliking.setBackground(null);
            myplaylist.setBackground(null);
            //我的更多  替换表格数据
            List listss = new ArrayList();
            tableFillData(listss);
            System.out.println("成功ranchu");
        }
    }

    int c = 1;

    //音乐列表双击播放
    protected void doubleClickToPlay(MouseEvent e) throws DocumentException {
        if (e.getClickCount() == 2) {
            //判断播放状态
            //查询播放状态
            ParsingXML parsingXML = new ParsingXML();
//            String isplay = parsingXML.QueryElementValve(absolutelocal,1,"isplay");
//            if (isplay.equals("true")){
//                simu.stop();
//            }
            System.out.println("分割线-------------------------------");
            // 当前选择行数
            int selctrow = table11.getSelectedRow();
            // 获取当前文件名
            String selectfile = (String) doclist.get(selctrow);
            // 文件夹绝对路径
            String pathname = listdocu.Get_Document_Path();
            // 当前文件的绝对路径
            String selectfilepath = pathname + "\\" + selectfile;
            // 开始播放音乐
            System.out.println(selectfilepath);
            try {
                mn.setPlay_file(selectfilepath);
                mn.play();
            } catch (Exception e1) {
                // TODO 自动生成的 catch 块
                e1.printStackTrace();
            }
            //设置当前的播放题目
            mylab5.setText(selectfile);
            //scd
            System.out.println("调用了");
            //获取当前音乐的时间长度
            //new出ParsingXML对象
            //ParsingXML parsingXML = new ParsingXML();
            //查询XML
            String getslidertime = parsingXML.QueryElementValve(absolutelocal, 2, "time");
            //转换slidertime 这里是播放音乐事件长度毫秒
            int slidertime = Integer.valueOf(getslidertime);
            //查询播放状态
            //new出ParsingXML对象
            String x = parsingXML.QueryElementValve(absolutelocal, 1, "isplay");
            //如果当前播放器状态为-未播放状态
            //c重新设置一个变量
            if (x.equals("false")){
                simu = new SimulatedProgressPar();
                simu.setTimeandFlag(slidertime,true,slider);
                Thread t1 = new Thread(simu);
                t1.start();
            }else {
                simu.stop();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                simu = new SimulatedProgressPar();
                simu.setTimeandFlag(slidertime,true,slider);
                Thread t1 = new Thread(simu);
                t1.start();
                //
            }
        }
    }

    //设置播放状态的按钮
    public static void setPlayStatac(int x) {
        //1 播放中   2暂停中
        if (x == 1) {
            playorstop.setIcon(new ImageIcon(MainInterface.class.getResource("/img/pause-1.png")));
        } else if (x == 3){
            playorstop.setIcon(new ImageIcon(MainInterface.class.getResource("/img/restart.png")));
//            simu.stop();
        } else{
            playorstop.setIcon(new ImageIcon(MainInterface.class.getResource("/img/restart.png")));
            simu.stop();
        }
    }

    //初始化方法
    public static void initFunction() {
        scannerMusic();
    }

    //进度条自动刷新方法
    //musiclong -总时长
    //向表格填充数据
    public static void tableFillData(List lists) {
        rowData = new String[lists.size()][1];
        //向列表填充数据
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < rowData[i].length; j++) {
                rowData[i][j] = String.valueOf("  " + lists.get(i));
            }
        }
        Object[] columnNames = {"A"};
        DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO 自动生成的方法存根
                return false;
            }
        };
        table11.setModel(model);
    }

    //播放暂停响应事件
    public static void stopOrStart(){
        try {
            //查询播放状态
            //new出ParsingXML对象
            ParsingXML parsingXML = new ParsingXML();
            String x = parsingXML.QueryElementValve(absolutelocal, 1, "isplay");
            if (x.equals("true")) {
                MusicPlayer mp = new MusicPlayer();
                mp.stopPlay();
            } else {
                System.out.println("未在播放状态");
            }
        } catch (NullPointerException | DocumentException | IOException e1) {

        }
    }

    public static void sleepStopPlay(){
        simu.stop();
    }
}
