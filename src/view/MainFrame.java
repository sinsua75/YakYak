package view;

import controller.AppController;
import store.CsvRecordStore;
import store.RecordStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// 전체 프로그램 메인 창
public class MainFrame extends JFrame {

    public MainFrame() {
        super("약약 – 약 관리를 위한 나만의 약사");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 620);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        RecordStore store = new CsvRecordStore();

        // 컬럼: 이름, #분류, 시간대, 시작, 종료, 완료, 별점
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"이름", "#분류", "시간대", "시작", "종료", "완료", "별점"}, 0) {

            public Class<?> getColumnClass(int c) {
                if (c == 5) return Boolean.class; // 완료
                if (c == 6) return Double.class;  // 별점
                return String.class;
            }

            public boolean isCellEditable(int r, int c) {
                return c == 5; // 완료만 체크 가능
            }
        };

        AppController controller = new AppController(store, model);

        RecordPanel recordPanel = new RecordPanel(controller);
        AddMedicinePanel addPanel = new AddMedicinePanel(controller);
        CalendarPanel calendarPanel = new CalendarPanel(controller);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("약 등록", addPanel);
        tabs.addTab("기록 보기", recordPanel);
        tabs.addTab("달력 보기", calendarPanel);

        add(tabs, BorderLayout.CENTER);
    }
}
