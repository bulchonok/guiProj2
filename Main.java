import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new View();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }
}
