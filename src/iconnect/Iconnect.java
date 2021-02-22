package iconnect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Iconnect {

    public static void main(String[] args) {
        String path1 = "C:\\Users\\www\\Desktop\\iconnect\\cm29JAN2020bhav.csv"; //Assigning the path of the files 
        String path2 = "C:\\Users\\www\\Desktop\\iconnect\\cm30JAN2020bhav.csv";
        String path3 = "C:\\Users\\www\\Desktop\\iconnect\\cm31JAN2020bhav.csv";
        String line1 = "", line2 = "", line3 = "";

        float x = 0, y = 0, res = 0;

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(path1)); //Java BufferedReader class is used to read the text from a character-based input stream
            BufferedReader br2 = new BufferedReader(new FileReader(path2));  //	It is used to create a buffered character input stream that uses the default size for an input buffer.
            BufferedReader br3 = new BufferedReader(new FileReader(path3));

            PrintWriter pr = new PrintWriter(new File("C:\\Users\\www\\Desktop\\iconnect\\MyCSV.csv")); //creates a new csv file naming MyCSV.csv
            StringBuilder sb = new StringBuilder();    //Java StringBuilder class is used to create mutable (modifiable) string.
            sb.append("SYMBOL");
            sb.append(",");
            sb.append("29 jan 2020");
            sb.append(",");
            sb.append("30 jan 2020");
            sb.append(",");
            sb.append("31 jan 2020");
            sb.append("\r\n");

            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null && (line3 = br3.readLine()) != null) { //reading the files line by line untill null value is reached

                String values1[] = line1.split(","); //split the line by commas
                String values2[] = line2.split(",");
                String values3[] = line3.split(",");

                if (values1[0].equals("SYMBOL")) {
                    continue;
                }

                sb.append(values1[0]);
                sb.append(",");

                try {
                    x = Float.parseFloat(values1[3]);  
                    y = Float.parseFloat(values1[4]);

                    res = x - y;    //calculate the daily range = high - low for each stock
                    sb.append(res);
                    sb.append(",");

                    x = Float.parseFloat(values2[3]);
                    y = Float.parseFloat(values2[4]);

                    res = x - y;
                    sb.append(res);
                    sb.append(",");

                    x = Float.parseFloat(values3[3]);
                    y = Float.parseFloat(values3[4]);

                    res = x - y;
                    sb.append(res);
                    sb.append(",");

                    sb.append("\r\n");
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }

              //float res = x-y;
                //sb.append(res);
            }
            pr.write(sb.toString());
            pr.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
