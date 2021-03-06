package commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedWriter bufferWriter;
    private static BufferedReader bufferReader;
    private static String path;

    public static void writeFile(String[] content) {
        try {
            bufferWriter = new BufferedWriter(new FileWriter(path, true));
            bufferWriter.write(StringUtils.concat(content, StringUtils.COMMA));
            bufferWriter.newLine();
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileEdit() {
        try {
            bufferWriter = new BufferedWriter(new FileWriter(path, false));
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile() {
        List<String> arrayContent = new ArrayList<String>();
        try {
            bufferReader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = bufferReader.readLine()) != null) {
                arrayContent.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayContent;
    }

    public static void setFullPathFile(String filename) {
        StringBuffer path = new StringBuffer("C:\\Users\\OS\\Documents\\GitHub\\a1201it1-LeHongDuc\\module2\\module2\\src\\data\\");
        path.append(filename);
        path.append(StringUtils.CSV);
        FileUtils.path = path.toString();
    }


}
