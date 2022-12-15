package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ProductsPageObjects extends Base{

	
	@FindBy(id = "search_product")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(id = "submit_search")
	@CacheLookup
	WebElement submitSearchBtn;
	
	@FindBy(xpath = "//div[@class=\"productinfo text-center\"]/p")
	@CacheLookup
	public WebElement productTitle;
	
	@FindBy(xpath = "(//a[@data-product-id=\"2\"])[1]")
	public WebElement productAddtoCartBtn;
	
	@FindBy(xpath = "//a[@href=\"/view_cart\"]/u")
	public WebElement productCart;
	
	@FindBy(xpath = "//button[@data-dismiss=\"modal\"]")
	public WebElement continueShopping;
	
	
	
	public ProductsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String prod) {
		searchField.sendKeys(prod);
		submitSearchBtn.click();
	}
	
	
}
