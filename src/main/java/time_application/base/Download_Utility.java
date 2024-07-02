package time_application.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Download_Utility {

	public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    public Download_Utility(WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
    	 this.driver = driver;
         this.prop = prop;
         this.wait = wait;
         this.action = action;
         this.javascriptexecutor = javascriptexecutor;
    }


    public void File_Download_Check(String filename_when_downloading, String Folder_name_to_move_file, String file_rename, String extension) throws InterruptedException, IOException {

        String file_extension = "." + extension + "";
        String file_name = "" + filename_when_downloading + "" + file_extension + "";

        String folder_name = System.getProperty("user.home") + "\\Downloads";
        Path folder_created = Paths.get(System.getProperty("user.home") + "\\Downloads\\" + Folder_name_to_move_file + "");

        File f = new File(System.getProperty("user.home") + "\\Downloads\\" + file_name + "");
        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;
        while (System.currentTimeMillis() < end) {
            if (f.exists()) {
                break;
            } else {

            }
        }

        if (Files.exists(folder_created)) {
            System.out.println("folder already exist");
        } else {
            File filess = new File(System.getProperty("user.home") + "\\Downloads\\" + Folder_name_to_move_file + "");
            Boolean folder_creation = filess.mkdir();
            System.out.println(folder_creation);
        }


        File[] listOfFiles;
        String file_Name;
        boolean file_dowladed = false;

        while (true) {
            listOfFiles = new File(folder_name).listFiles();
            for (File file : listOfFiles) {
                file_Name = file.getName();

                if (file_Name.equals(file_name)
                        && !file_Name.contains("crdownload")) {
                    file_dowladed = true;
                    break;
                }
            }
            if (file_dowladed)
                break;
            break;
        }
        Assert.assertTrue(file_dowladed, "Test case failed - file is not downloaded");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String date_and_time = dtf.format(now);

        Path temp = Files.move
                (Paths.get(System.getProperty("user.home") + "\\Downloads\\" + file_name + ""),
                        Paths.get(System.getProperty("user.home") + "\\Downloads\\" + Folder_name_to_move_file + "\\" + file_rename + "_" + date_and_time + "." + extension + ""));


    }


}
