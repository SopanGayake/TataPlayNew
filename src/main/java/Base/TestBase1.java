package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase1 {
	public static WebDriver driver;
	public static Properties prop;
	public String readPropertyFile(String value) throws IOException 
	{
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Sopan Gayake.DTPLLPT70\\workspace\\TataPlay\\src\\main\\java\\Config\\config.properties");
		prop.load(file);
		return prop.getProperty(value); 
	}
	public void initalization() throws IOException
	{
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.facebook.com/");
		
		String browserName = readPropertyFile("browser");  //edge
		if(browserName.equalsIgnoreCase("chrome"))
		{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(o);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("opera")) 
		{
			OperaOptions o = new OperaOptions();
			o.addArguments("--disable-notifications");
			System.setProperty("webdriver.opera.driver", "operadriver");
			driver = new OperaDriver(o);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "msedgedriver");
			driver = new EdgeDriver();
		}
		else
		{
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readPropertyFile("url"));
	}
	
	public static void readExcelFile() throws IOException
	{
		String filePath = "C:\\Users\\Sopan Gayake.DTPLLPT70\\workspace\\TataPlay\\src\\main\\java\\Config\\User names.xlsx";
		FileInputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0); //getSheetAt(sheet1);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for (int r=0;r<rows;r++)
		{
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING: System.out.println(cell.getStringCellValue());break;
				case NUMERIC: System.out.println(cell.getNumericCellValue());break;
				case BOOLEAN: System.out.println(cell.getBooleanCellValue());break;
				}
			}
			System.out.println();
		}
	
	}
	
}
