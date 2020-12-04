import org.junit.BeforeClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Setup {
    private String[] dataInput;

    public String[] getDataInput(String fileName) throws IOException {
        return setup(fileName);
    }

    private String[] setup(String fileName) throws IOException {
        List<String> dataInputList = new ArrayList<String>();
        FileInputStream problemInputFile = new FileInputStream("src/test/java/dataInputs/" + fileName);
        DataInputStream data_input = new DataInputStream(problemInputFile);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
        String str_line;
        while ((str_line = buffer.readLine()) != null) {
            str_line = str_line.trim();
            if ((str_line.length() != 0)) {
                dataInputList.add(str_line);
            }
        }
        dataInput = dataInputList.toArray(new String[dataInputList.size()]);
        return dataInput;
    }
}
