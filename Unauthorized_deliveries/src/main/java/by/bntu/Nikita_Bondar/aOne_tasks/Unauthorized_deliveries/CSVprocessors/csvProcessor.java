/**
 * csvProcessor reads csv-files
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.CSVprocessors;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class csvProcessor {

    /**
     * @param path - path to csv-file
     * @param separator - char separator
     * @return - arrayList of string arrays of data from line;
     * @throws IOException
     */
    public static ArrayList<String[]> resdCSV(String path, char separator) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path), separator, '"', 1);
        ArrayList<String[]> arrayList = new ArrayList<>();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            arrayList.add(nextLine);
        }
        return  arrayList;
    }


}
