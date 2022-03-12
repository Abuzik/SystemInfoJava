import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println(new Date().getTime());
        System.out.println(SystemInfo.freeMemory());
    }
}
