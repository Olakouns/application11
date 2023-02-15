import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubjectInterface extends JFrame {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private ArrayList<Color> colors = new ArrayList<>(List.of(Color.black, Color.white, Color.blue, Color.ORANGE, Color.YELLOW, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.darkGray, Color.cyan));
    private int state;


    public SubjectInterface(String title) throws HeadlessException {
        super(title);
    }

    public Color getCustomState() {
        return colors.get(state);
    }

    public void setCustomState(int state) { /* compiled code */ }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public  void showInterface() {

        JButton b=new JButton("Changer Couleur");
        b.setBounds(50,100,95,30);
        b.addActionListener(e -> {
            this.setState(new Random().nextInt(9));
        });

        JButton newFrame = new JButton("Nouvelle fenetre");
        newFrame.setBounds(195,100, 150,30);
        newFrame.addActionListener(e -> {
            ObserverFirst observerFirst =  new ObserverFirst("New Frame", this);
            observerFirst.showInterface();
            observerFirst.update();
        });

        JButton closeFrame = new JButton("Fermer les fenetre");
        closeFrame.setBounds(400,100,150,30);
        closeFrame.addActionListener(e -> {
          this.observers.forEach(Window::dispose);
        });


        this.add(b);
        this.add(newFrame);
        this.add(closeFrame);
        this.setSize(600,400);
        this.setLayout(null);
        this.setVisible(true);
    }
}