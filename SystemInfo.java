import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemInfo {

    public static long getCpuLoad() throws IOException, InterruptedException {
        return 100-Long.parseLong(getProcessesValues().get(14));
    }

    public static long getSwpd() throws IOException, InterruptedException {
        return Long.parseLong(getProcessesValues().get(2));
    }

    public static long getFree() throws IOException, InterruptedException {
        return Long.parseLong(getProcessesValues().get(3));
    }

    public static long getBuff() throws IOException, InterruptedException {
        return Long.parseLong(getProcessesValues().get(4));
    }

    public static long getCache() throws IOException, InterruptedException {
        return Long.parseLong(getProcessesValues().get(5));
    }

    public static long totalMemory() throws IOException, InterruptedException {
        return Long.parseLong(getMemoryValues().get(1));
    }

    public static long usedMemory() throws IOException, InterruptedException {
//        return Long.parseLong(getMemoryValues().get(2));
        return Math.round(Long.parseLong(getMemoryValues().get(1))-Long.parseLong(getProcessesValues().get(3))/1024);
    }

    public static long freeMemory() throws IOException, InterruptedException {
        return Long.parseLong(getMemoryValues().get(3));
    }

    public static double allSize() throws IOException, InterruptedException {
        return Double.parseDouble(getStorageInfo().get(1).split("G")[0]);
    }

    public static double usedSize() throws IOException, InterruptedException {
        return Double.parseDouble(getStorageInfo().get(2).split("G")[0]);
    }

    public static double availableSize() throws IOException, InterruptedException {
        return Double.parseDouble(getStorageInfo().get(3).split("G")[0]);
    }

    public static double percantageUse() throws IOException, InterruptedException {
        return Double.parseDouble(getStorageInfo().get(4).split("%")[0]);
    }

    protected static ArrayList<String> getProcessesValues() throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec("vmstat");
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while ((line=buf.readLine())!=null) {
            str.add(line);
        }

        ArrayList<String> arr = new ArrayList<>(List.of(str.get(2).split(" ")));
        arr.removeAll(Collections.singleton(""));

        return new ArrayList<>(arr);

//        procs -----------memory---------- ---swap-- -----io---- -system-- ------cpu-----
//        r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa st
//        1  0 166912  87552  61172 493996    0    0     8    26    7    3  1  0 99  0  0
//        item: 1, i: 0
//        item: 0, i: 1
//        item: 166912, i: 2
//        item: 87552, i: 3
//        item: 61172, i: 4
//        item: 493996, i: 5
//        item: 0, i: 6
//        item: 0, i: 7
//        item: 8, i: 8
//        item: 26, i: 9
//        item: 7, i: 10
//        item: 3, i: 11
//        item: 1, i: 12
//        item: 0, i: 13
//        item: 99, i: 14
//        item: 0, i: 15
//        item: 0, i: 16
    }

    protected static ArrayList<String> getMemoryValues() throws InterruptedException, IOException {
        String cmd = "free -m";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while ((line=buf.readLine())!=null) {
            str.add(line);
        }

        ArrayList<String> arr = new ArrayList<>(List.of(str.get(1).split(" ")));

        arr.removeAll(Collections.singleton(""));

        return new ArrayList<>(arr);

//        total        used        free      shared  buff/cache   available
//        Mem:          981         353          84           0         543         478
//        Swap:         725         163         562
//        item: Mem:, i: 0
//        item: 981, i: 1
//        item: 353, i: 2
//        item: 84, i: 3
//        item: 0, i: 4
//        item: 543, i: 5
//        item: 478, i: 6
    }

    protected static ArrayList<String> getStorageInfo() throws InterruptedException, IOException {
        String cmd = "df -h /";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while ((line=buf.readLine())!=null) {
            str.add(line);
        }

        ArrayList<String> arr = new ArrayList<>(List.of(str.get(1).split(" ")));

        arr.removeAll(Collections.singleton(""));

        return new ArrayList<>(arr);

//        Filesystem      Size  Used Avail Use% Mounted on
//        /dev/vda1       9.8G  8.7G  1.1G  89% /
//        item: /dev/vda1, i: 0
//        item: 9.8G, i: 1
//        item: 8.7G, i: 2
//        item: 1.1G, i: 3
//        item: 89%, i: 4
//        item: /, i: 5
    }
}

//        String cmd = "free -m";
//        Runtime run = Runtime.getRuntime();
//        Process pr = run.exec(cmd);
//        pr.waitFor();
//        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        ArrayList<String> str = new ArrayList<>();
//        String line = "";
//        while ((line=buf.readLine())!=null) {
//            System.out.println(line);
//            str.add(line);
//        }
//
//        ArrayList<String> arr = new ArrayList<>(List.of(str.get(1).split(" ")));
//
//        arr.removeAll(Collections.singleton(""));
//
//        for (int i = 0 ; i < arr.size(); i++) {
//            System.out.println(String.format("item: %s, i: %s", arr.get(i), i));
//        }
