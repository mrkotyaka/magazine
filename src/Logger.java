import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    public void log(String msg) {
        try {
            File file = new File("logs.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла для логгирования");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("\n[" + LocalDateTime.now() + "] " + msg);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл логгирования");
            e.printStackTrace();
        }
    }

    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        return (logger == null) ? logger = new Logger() : logger;
    }
}

