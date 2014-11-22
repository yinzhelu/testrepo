import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TemperatureTest  {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");

        // Find the text input element by its name
        WebElement user = driver.findElement(By.name("userId"));

        // Enter something to search for
        user.clear();
        user.sendKeys("bob");

        WebElement password = driver.findElement(By.name("userPassword"));
        password.clear();
        password.sendKeys("bathtub");

        // Now submit the form. WebDriver will find the form for us from the element
        user.submit();

        // Check the title of the page
        if(driver.getTitle().equals("Online temperature conversion calculator"))
	{
		System.out.println("Plain vanilla Bob login passed test!");
	}
	else
	{
		System.out.println("Test failure with spaces!");
	}      

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
         // Find the text input element by its name
        user = driver.findElement(By.name("userId"));

        // Enter something to search for
        user.clear();
        user.sendKeys("  andy  ");

        password = driver.findElement(By.name("userPassword"));
        password.clear();
        password.sendKeys("apple");

        // Now submit the form. WebDriver will find the form for us from the element
        user.submit();
        if(driver.getTitle().equals("Online temperature conversion calculator"))
	{
		System.out.println("Andy login with spaces passed test!");
	}
	else
	{
		System.out.println("Test failure with spaces!");
	}        

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
         // Find the text input element by its name
        user = driver.findElement(By.name("userId"));

        // Enter something to search for
        user.clear();
        user.sendKeys("  CHarley  ");

        password = driver.findElement(By.name("userPassword"));
        password.clear();
        password.sendKeys(" china	");

        // Now submit the form. WebDriver will find the form for us from the element
        user.submit();
        if(driver.getTitle().equals("Online temperature conversion calculator"))
	{
		System.out.println("Random capitalization Charley passed test!");
	}
	else
	{
		System.out.println("Test failure with charley!");
	}      
 

        for (int i = 0; i < 4; i++)
	{
		driver.get("http://apt-public.appspot.com/testing-lab-login.html");
	         // Find the text input element by its name
	        user = driver.findElement(By.name("userId"));
	
	        // Enter something to search for
	        user.clear();
	        user.sendKeys("andy");
	
	        password = driver.findElement(By.name("userPassword"));
	        password.clear();
	        password.sendKeys("Bruce Wayne");
	
        	// Now submit the form. WebDriver will find the form for us from the element
        	user.submit();
        	if(driver.getTitle().equals("Online temperature conversion calculator"))
		{
			System.out.println("Test failed");
		}
		else if (driver.getTitle().equals("Frequent Login"))
		{
			System.out.println("Lock within 10s");
		}      
	}

        long end = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < end) {}


        	driver.get("http://apt-public.appspot.com/testing-lab-login.html");
	         // Find the text input element by its name
	        user = driver.findElement(By.name("userId"));
	
	        // Enter something to search for
	        user.clear();
	        user.sendKeys("andy");
	
	        password = driver.findElement(By.name("userPassword"));
	        password.clear();
	        password.sendKeys("apple");
	
        	// Now submit the form. WebDriver will find the form for us from the element
        	user.submit();
        	if(driver.getTitle().equals("Online temperature conversion calculator"))
		{
			System.out.println("One minute lockout failed!");
		}
		else
		{
			System.out.println("Lockout!");
		}      


	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	WebElement temperature = driver.findElement(By.name("farenheitTemperature"));
        temperature.clear();
        temperature.sendKeys("-220.3452");
	temperature.submit();
        WebElement header = driver.findElement(By.xpath("//h2"));
        if (header.getText().equals("-220.3452 Farenheit = -140.19 Celsius"))
	{
		System.out.println("Valid temperature converter input -220.3452 result passed!");
	}
	else
	{
		System.out.println("Valid temperature converter input -220.3452 result failed!");
	}

	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	temperature = driver.findElement(By.name("farenheitTemperature"));
        temperature.clear();
        temperature.sendKeys("9.73E2");
	temperature.submit();
        header = driver.findElement(By.xpath("//h2"));
        if (header.getText().equals("Need to enter a valid temperature!Got a NumberFormatException on BigBob"))
	{
		System.out.println("Invalid temperature converter input 9.37E2 generates NumberFormatException!");
	}
	else
	{
		System.out.println("Invalid temperature converter input 9.37E2 failed to generate NumberFormatException!");
	}

	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	temperature = driver.findElement(By.name("farenheitTemperature"));
        temperature.clear();
        temperature.sendKeys("BigBob");
	temperature.submit();
        header = driver.findElement(By.xpath("//h2"));
        if (header.getText().equals("Need to enter a valid temperature!Got a NumberFormatException on BigBob"))
	{
		System.out.println("Invalid temperature converter input generates NumberFormatException!");
	}
	else
	{
		System.out.println("Invalid temperature converter input result failed to generate NumberFormatException!");
	}

	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	temperature = driver.findElement(By.name("farenheitTemperature"));
        temperature.clear();
        temperature.sendKeys("213.2435");
	temperature.submit();
        header = driver.findElement(By.xpath("//h2"));
        if (header.getText().equals("213.2435 Farenheit = 100.7 Celsius"))
	{
		System.out.println("Temperature converter input 213.2435 generated correct one decimal place result!");
	}
	else
	{
		System.out.println("Temperature converter input 213.2435 generated incorrect two decimal place result!");
	}

	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	temperature = driver.findElement(By.name("farenheitTemperature"));
        temperature.clear();
        temperature.sendKeys("-40");
	temperature.submit();
        header = driver.findElement(By.xpath("//h2"));
        if (header.getText().equals("-40 Farenheit = -40 Celsius"))
	{
		System.out.println("Temperature converter input -40 generated correct celsius result -40!");
	}
	else
	{
		System.out.println("Temperature converter input -40 generated incorrect result!");
	}

        driver.quit();
    }
}
