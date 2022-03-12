import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println(SystemInfo.freeMemory());
        System.out.println(SystemInfo.getCpuLoad());
        System.out.println(SystemInfo.allSize());
        System.out.println(SystemInfo.usedSize());
        System.out.println(SystemInfo.availableSize());
        System.out.println(SystemInfo.percantageUse());
    }
}
