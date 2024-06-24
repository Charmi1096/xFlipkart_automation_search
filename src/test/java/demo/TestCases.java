package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
    static  ChromeDriver driver;
    
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public static void testCase01() throws InterruptedException
    {
        System.out.println("Start Test case: testCase01");
        //1.Go to www.flipkart.com
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);  
        //2. Search "Washing Machine".
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchBox.clear();
        searchBox.sendKeys("Washing Machine");
        searchBox.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Popularity']")));
        //3. Sort by popularity and print the count of items with rating less than or equal to 4 stars.
        WebElement sortByElement = driver.findElement(By.xpath("//div[text()='Popularity']"));
        sortByElement.click();
        Thread.sleep(3000);
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='_75nlfW']"));
        int itemSize = items.size();
        System.out.println("totals item is : "+itemSize);
        List<WebElement> ratinG = driver.findElements(By.xpath("//div[@class='XQDdHH']"));
        List<String> ratings = new ArrayList<String>();
        for (WebElement e : ratinG)
        {
            ratings.add(e.getText());
        }
        List<String> newRating = new ArrayList<String>(ratings);
        int count = 0;
        for(int i = 0; i < newRating.size(); i++) 
        {
            
            if(i<=4){
              //System.out.println("washing machine by rating :"+newRating.get(i));  
              count++;
            }
        }
        System.out.println("count of items with rating less than or equal to 4 stars is : "+count);
        System.out.println("End Test case: testCase01");
    }

    @Test
    public static void testCase02() throws InterruptedException
    {
        System.out.println("Start Test case: testCase02");
        //1.Go to www.flipkart.com
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);  
        //2. Search "iPhone".
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchBox.clear();
        searchBox.sendKeys("iPhone");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);  

        List<WebElement> iphoneDetail = driver.findElements(By.xpath("//div[@class='yKfJKb row']"));
        
        List<WebElement> titleOfIphone = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        List<String> title = new  ArrayList<String>();
        for (WebElement e : titleOfIphone)
        {
            title.add(e.getText());
        }
        List<String> newTitle = new ArrayList<String>(title);
        List<WebElement> discount = driver.findElements(By.xpath("//div[@class='UkUFwK']"));
        List<String> dis = new ArrayList<String>();
        for (WebElement e : discount)
        {
            dis.add(e.getText());
        }
        List<String> newDiscount = new ArrayList<String>(dis);

            for(int j = 0; j < 24; j++){
                
                if(j>17 && j < 100)
                   System.out.println("title is : "+newTitle.get(j)+"discount is : "+j+"% off");
                    
                
             
            }
    
        System.out.println("End Test case: testCase02");
    }

    @Test
    public static void testCase03() throws InterruptedException
    {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);  
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchBox.clear();
        searchBox.sendKeys("Coffee Mug");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);  
        WebElement selectStar = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div/div/section[5]/div[2]/div/div[1]/div/label"));
        selectStar.click();
        Thread.sleep(3000);

        List<WebElement> titleOfCoffeemug = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        List<String> title = new  ArrayList<String>();
        for (WebElement e : titleOfCoffeemug)
        {
            title.add(e.getText());
        }
        List<String> newTitle = new ArrayList<String>(title);

        List<WebElement> imgUrlList = driver.findElements(By.xpath("//img[@class='DByuf4']"));
        List<String> imGUrl = new  ArrayList<String>();
        for (WebElement e : imgUrlList)
        {
            imGUrl.add(e.getText());
        }
        List<String> newImgUrl = new ArrayList<String>(imGUrl);

        List<WebElement> reviewList = driver.findElements(By.xpath("//span[@class='Wphh3N']"));
        List<String> reviewLst = new  ArrayList<String>();
        for (WebElement e : reviewList)
        {
            reviewLst.add(e.getText());
        }
        List<String> newReview = new ArrayList<String>(reviewLst);
        int largestString = newReview.get(0).length();
        for (int i = 0; i <= 5 ; i++) {
            if(newReview.get(i).length() > largestString)
                System.out.println("title of coffeemug is : "+newTitle.get(i)+" img url of coffeemug is : "+newImgUrl.get(i));
            
        }
        System.out.println("End Test case: testCase03");
    }
    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}