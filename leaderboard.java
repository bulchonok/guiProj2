
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class leaderboard {

    public static void updatelb(String lbRecord) throws IOException {
        FileWriter fileWriter = new FileWriter("src\\save\\lb.txt");
        String ReadData=getlb();
        String writelb = ReadData+lbRecord;
        fileWriter.write(writelb);
        fileWriter.close();

    }

    public static String getlb() throws IOException {
        String lb = "";
        FileReader fileReader = new FileReader("src\\save\\lb.txt");
        int buffer = 0;

        buffer = fileReader.read();


        while (buffer != -1) {
            lb += (char) buffer;
            buffer = fileReader.read();
        }
        fileReader.close();
        return lb;

    }

}
