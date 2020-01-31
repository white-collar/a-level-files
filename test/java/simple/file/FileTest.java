package simple.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class FileTest {

    @Test
    public void testCreateFile() {

        File file = new File("D:/test.txt");

        if (file.exists()) {
            file.delete();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(file.exists());
    }

    @Test
    public void testFileAttributes() {
        File file = new File("D:/test.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.lastModified());
    }

    @Test
    public void createAndWriteFile() {
        String fileContent = "Stop boring me and think. It's new sexy";
        FileOutputStream fileOutputStream = null;
        File file = new File("D:/java/sherlock.txt");
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(fileContent.getBytes());
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testBufferedWriter() throws IOException {
        File file = new File("D:/java/witcher.txt");
        file.createNewFile();

        String fileContent = "Toss a coin to your witcher";

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(fileContent);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
