import javax.swing.*;

public abstract class Observer extends JFrame {
    protected SubjectInterface subject;

    public Observer(java.lang.String title) throws java.awt.HeadlessException { /* compiled code */ }

    public abstract void update();
}