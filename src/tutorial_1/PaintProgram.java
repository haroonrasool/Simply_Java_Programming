package tutorial_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class PaintProgram extends JFrame implements ActionListener {
    private final JComboBox<Object> shapeChoice;
    private JButton load;
    private JButton store;
    private final JButton color;
    private final PaintPanel painter;

    public PaintProgram() {
        super("Moving Shapes Painting Application");

        Container c = getContentPane();
        JPanel controls = new JPanel();
        painter = new PaintPanel();
        c.add(painter, BorderLayout.CENTER);

        shapeChoice = new JComboBox<>();
        shapeChoice.addItem("Line");
        shapeChoice.addItem("Rectangle");
        shapeChoice.addItem("Oval");
        shapeChoice.addActionListener(this);
        controls.add(shapeChoice);

        color = new JButton("Color");
        color.addActionListener(e -> {
            Color col = JColorChooser.showDialog(null, "Select a Color", Color.black);
            color.setBackground(col);
            painter.setCurrentColor(col);
        });

        controls.add(color);

        c.add(controls, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        painter.setCurrentShapeType(Objects.requireNonNull(shapeChoice.getSelectedItem()).toString());
    }

    public static void main(String[] args) {
        // create application Frame and resize
        PaintProgram app = new PaintProgram();

        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        app.setSize(400, 400);
        app.show();
    }
}
