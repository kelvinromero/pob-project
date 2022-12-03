package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import model.Breed;
import model.Pet;
import application.Create;
import daodb4o.Util;
import busines.Facade;

public class Pets {
    private JFrame frame;
    private JTable table;
    private JTextField petName;
    private JTextField petBreed;
    private JTextField petWeight;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Pets window = new Pets();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the application.
     */
    public Pets() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
		Facade.init(); // TODO: Move this to main window init
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        JLabel lblPets = new JLabel("Pets");
        lblPets.setHorizontalAlignment(SwingConstants.CENTER);
        lblPets.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPets.setBounds(10, 11, 414, 25);
        frame.getContentPane().add(lblPets);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 47, 414, 150);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Name", "Breed", "Weight"
            }
        ));
        scrollPane.setViewportView(table);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 208, 46, 14);
        frame.getContentPane().add(lblName);
        
        JLabel lblBreed = new JLabel("Breed");
        lblBreed.setBounds(10, 233, 46, 14);
        frame.getContentPane().add(lblBreed);
        
        JLabel lblWeight = new JLabel("Weight");
        lblWeight.setBounds(10, 258, 46, 14);
        frame.getContentPane().add(lblWeight);
        
        petName = new JTextField();
        petName.setBounds(66, 205, 86, 20);
        frame.getContentPane().add(petName);
        petName.setColumns(10);
        
        petBreed = new JTextField();
        petBreed.setBounds(66, 230, 86, 20);
        frame.getContentPane().add(petBreed);
        petBreed.setColumns(10);
        
        petWeight = new JTextField();
        petWeight.setBounds(66, 255, 86, 20);
        frame.getContentPane().add(petWeight);
        petWeight.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = petName.getText();
                String breedName = petBreed.getText();
                String weight = petWeight.getText();
                
                Breed breed = new Breed(breedName);
                if (name.isEmpty() || breedName.isEmpty() || weight.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields");
                } else {
                    try {
                        double w = Double.parseDouble(weight);
                        Pet p = new Pet(name, breed, w);
                        petName.setText("");
                        petBreed.setText("");
                        petWeight.setText("");
                        updateTable();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Weight must be a number");
                    }
                }
            }
        }
        );
        btnAdd.setBounds(162, 204, 89, 23);
        frame.getContentPane().add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Please select a pet");
                } else {
                    String name = (String) table.getValueAt(row, 0);
                    String breed = (String) table.getValueAt(row, 1);
                    double weight = (double) table.getValueAt(row, 2);
                    // Pet p = new Pet(name, breed, weight);
                    // Delete.deletePet(p);
                    updateTable();
                }
            }
        }
        );
        btnDelete.setBounds(162, 229, 89, 23);
        frame.getContentPane().add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Please select a pet");
                } else {
                    String name = (String) table.getValueAt(row, 0);
                    String breed = (String) table.getValueAt(row, 1);
                    double weight = (double) table.getValueAt(row, 2);
                    // TODO:
                    // Pet p = new Pet(name, breed, weight);
                    // Update.updatePet(p);
                    updateTable();
                }
            }
        }
        );
        btnUpdate.setBounds(162, 254, 89, 23);
        frame.getContentPane().add(btnUpdate);

        updateTable();
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Pet p : Facade.readAllPets()) {
            model.addRow(new Object[] { p.getName(), p.getBreed().getName(), p.getWeight() });
        }
    }
}
