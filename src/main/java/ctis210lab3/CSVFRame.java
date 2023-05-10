package ctis210lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVFRame extends JFrame {

    private JTable table;

    public CSVFRame(String filename) {
        super("HOOPER'S STATS"); // title for the frame
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            Path path = Paths.get(this.getClass().getResource("/HOOPERSTATS.csv").toURI());
            FileReader filereader = new FileReader(path.toFile());
      
            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                      .withSkipLines(1)
                                      .build();
            List<String[]> allData = csvReader.readAll();

            // Ask the user for a player name
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a player name: ");
            String playerName = input.nextLine();
            input.close();
         

            
        

            String[] columnNames = {"Rank", "Player", "Pos", "Age", "Tm", "G", "GS", "MP", "FG", "FGA", "FG%", "3P", "3PA", "3P%", "2P", "2PA", "2P%", "eFG%", "FT", "FTA", "FT%", "ORB", "DRB", "TRB", "AST", "STL", "BLK", "TOV", "PF", "PS/G"};
            
            DefaultTableModel model = new DefaultTableModel(columnNames, 1);
            table = new JTable(model);
            for (String[] row : allData) {
                model.addRow(row);
            }
            add(new JScrollPane(table));
            setSize(2000, 2000);
            setVisible(true);
            // allow user to scoll across x-axis
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
            
            

            // print Data for the player the user entered
            for (int i = 0; i < allData.size(); i++) {
                String[] row = allData.get(i);
                if (row[0].equals(playerName)) {
                    System.out.println("Player Name: " + row[1]);
                    System.out.println("Pos: " + row[2]);
                    System.out.println("Age: " + row[3]);
                    System.out.println("Team: " + row[4]);
                    System.out.println("GP: " + row[5]);
                    System.out.println("GS: " + row[6]);
                    System.out.println("MP: " + row[7]);
                    System.out.println("FG: " + row[8]);
                    System.out.println("FGA: " + row[9]);
                    System.out.println("FG%: " + row[10]);
                }
            }


            // organize the the index of the player's stats

        } catch (Exception e) {
            e.printStackTrace();
        }

        }

            

        

    

    public static void main(String[] args) {
        CSVFRame frame = new CSVFRame("HOOPERSTATS.csv");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    

    // 

    

}

}


