import view.MainFrame;

import javax.swing.*;

// 프로그램 시작
public class MedicineMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) { }
            new MainFrame().setVisible(true);
        });
    }
}
