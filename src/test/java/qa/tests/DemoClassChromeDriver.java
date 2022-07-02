package qa.tests;

public class DemoClassChromeDriver implements   DemoInterfaceWebDriver{

    public static void main(String args[]){
        DemoInterfaceWebDriver interfaceObj  = new DemoClassChromeDriver();
        interfaceObj.get("https:google.co.in");
        interfaceObj.click();
    }

    @Override
    public void get(String appUrl) {
        System.out.println("app "+appUrl + " has been launched");
    }

    @Override
    public void click() {
        System.out.println("Login button clicked");
    }
}
