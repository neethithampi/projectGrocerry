package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name = "dataProvider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "admin111" },
      new Object[] { "admin111", "admin" },
      new Object[] { "admin111", "admin222" }
   
    };
  }
    
    @DataProvider(name = "dataProvider1")
    public Object[][] dp1() {
        return new Object[][] {
          new Object[] { "admin", "admin" },
          

        };
    }
}
