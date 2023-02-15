import java.awt.*;

public class ObserverFirst extends Observer {
    public ObserverFirst(String title, SubjectInterface subjectInterface) throws HeadlessException {
        super(title);
        this.subject = subjectInterface;
        this.subject.attach(this);
    }

    public void update() {
        this.getContentPane().setBackground(this.subject.getCustomState());
    }

    public void showInterface(){
        this.setSize(400,400);
        this.setLayout(null);
        this.setVisible(true);
    }
}