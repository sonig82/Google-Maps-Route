package utils;
import java.io.*;
import java.util.*;
public class CSVDataReader {
  public static List<String[]> readStationPairs(String filePath) {
  List<String[]> stationPairs = new ArrayList<();
    try (BufferedReader reader = new BufferedReader(new Filereader(filePath))) {
      String line;
      reader.readLine();
      while((line = reader.readLine())!=null) {
        String parts = line.split(",");
            if(parts.length ==2) {
              stationPAirs.add(new String[]{parts[0].trim(), parts[1].trim()});
            }
      }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return stationPairs;
  }
}

