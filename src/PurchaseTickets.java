import java.awt.List;
import java.sql.Time;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class PurchaseTickets {

    public static void main(String[] args) throws InterruptedException {
        String url = "";
        int productId = 433;
        boolean areTicketsAvailable = false;

        //Set up Chrome
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/shweta.thakare/Downloads⁩/chromedriver");

        driver.get("");
        //Rather than hardcoded wait let user input "Y" in order to proceed
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you logged in ?");
        while (!scanner.hasNext()) ;
        String input = "";
        if (scanner.hasNext()) input = scanner.nextLine();
        System.out.println("input is '" + input + "'");

        if (input.equals("Y")) {
            while (!areTicketsAvailable) {
                driver.get("" + productId);
                ArrayList<WebElement> listOfTicketInputField = (ArrayList<WebElement>) driver.findElements(By.className("ticketQty"));
                System.out.println(listOfTicketInputField.size());
                if (listOfTicketInputField.size() > 0) {
                    System.out.println("Here you go !! there are some tickets available");
                    System.out.println(listOfTicketInputField.get(0).getText());
                    areTicketsAvailable = true;
                    //TODO Play a sound here to let user know that tickets are available.
                } else {
                    System.out.println("Sorry! All tickets are sold out");
                    //This is where you can add how long you want to wait till you refresh and retry
                    System.out.println("retrying in 5 seconds");
                    Thread.sleep(5000);
                }
            }
        }//if Y	
       //Purposely commented driver.close so that you can perform manual actions.
        // driver.close();
    }
}
