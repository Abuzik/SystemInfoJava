# SystemInfo Java
Get hardware info by using [vmstat](https://en.wikipedia.org/wiki/Vmstat) linux command
```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println(SystemInfo.freeMemory());
    }
}

```

## Output(example): 
```
78
```
## List of all functions(all are static): 
```java
   SystemInfo.getCpuLoad();
   SystemInfo.getSwpd();
   SystemInfo.getFree();
   SystemInfo.getBuff();
   SystemInfo.getCache();
   SystemInfo.totalMemory();
   SystemInfo.usedMemory();
   SystemInfo.freeMemory();
   SystemInfo.allSize();
   SystemInfo.usedSize();
   SystemInfo.availableSize();
   SystemInfo.percantageUse();
```
