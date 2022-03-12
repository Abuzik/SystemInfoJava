# SystemInfoJava
Get hardware info by using vmstat linux command
```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println(SystemInfo.freeMemory());
    }
}

```

## Output(example): 
```78
