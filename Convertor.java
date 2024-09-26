    import javax.swing.*;
    import java.awt.event.*;
    import java.awt.*;
    public class Convertor implements ActionListener{
        JFrame f;
        JTextField field1,field2;
        JButton convert,clear;
        JPanel panel;
        JLabel resultLabel;
        JComboBox<String> unitFrom, unitTo;
        Font myfont =new Font("MONOSPACED",Font.ITALIC,30);


        Convertor(){
            f= new JFrame("Convertor");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(365, 250);
            f.setResizable(false);
            f.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
            //  f.setLayout(new BorderLayout());
            // f.setLayout(null);
            f.getContentPane().setBackground(new Color(173, 93, 31));

            resultLabel = new JLabel("Result: ");
            String[] units = {"Centimeters", "Meters", "Inches", "Feet"};
                 unitFrom = new JComboBox<>(units);
                 unitTo = new JComboBox<>(units);

            clear=new JButton("CLEAR");
            convert=new JButton("Convert");
            panel=new JPanel();
            panel.add(clear);
            panel.add(convert);
            panel.setBounds(50,50,80,70);
            panel.setLayout(new GridLayout(0, 1, 10, 10));
        panel.setBackground(new Color(173, 93, 31));

            field1=new JTextField();
            field1.setPreferredSize(new Dimension(200, 40));
            field1.setLayout(new FlowLayout(FlowLayout.RIGHT));
            field1.setEditable(true);
            
            field2=new JTextField();
            field2.setLayout(new FlowLayout(FlowLayout.RIGHT));
            field2.setPreferredSize(new Dimension(100, 30));
            field2.setEditable(false);
            field2.setBackground(new Color(235, 210, 141));
          
            f.add(new JLabel("Enter Value:"));
        f.add(field1);
        f.add(new JLabel("From Unit:"));
        f.add(unitFrom);
        f.add(new JLabel("To Unit:"));
        f.add(unitTo);
        // f.add(new JLabel("Converted Value:"));
            f.add(panel);
            f.add(resultLabel);
            f.add(field2);
            convert.addActionListener(this);
        clear.addActionListener(this);
            f.setVisible(true);
        }
        public static void main(String args[]){
            new Convertor();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==convert){
                double value=Double.parseDouble(field1.getText());
                String fromunit=(String)unitFrom.getSelectedItem();
                String tounit=(String)unitTo.getSelectedItem();
                double result=convert(value,fromunit,tounit);
                            // resultLabel.setText("result: "+ result);
                field2.setText(" "+ result);
            }
            else if(e.getSource()==clear){
                field1.setText("");
                             // resultLabel.setText("Result: ");
                field2.setText(" ");
            }
        }
        private double convert(double value,String unitFrom,String unittTo){
            double valueInMeters = convertToMeters(value, unitFrom);
                return convertFromMeters(valueInMeters, unittTo);
        }
        private double convertToMeters(double value, String fromUnit) {
        switch (fromUnit) {
            case "Centimeters":
                return value / 100;
            case "Meters":
                return value;
            case "Inches":
                return value * 0.0254; // 1 inch = 0.0254 meters
            case "Feet":
                return value * 0.3048; // 1 foot = 0.3048 meters
            default:
                return value;
        }
    }

    private double convertFromMeters(double value, String toUnit) {
        switch (toUnit) {
            case "Centimeters":
                return value * 100;
            case "Meters":
                return value;
            case "Inches":
                return value / 0.0254; // 1 meter = 39.3701 inches
            case "Feet":
                return value / 0.3048; // 1 meter = 3.28084 feet
            default:
                return value;
        }
    }
    }