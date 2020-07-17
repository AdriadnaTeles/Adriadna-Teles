package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {
	private WebDriver driver;

	private By nomeProduto = By.cssSelector("article.product-info h1");
	
	private By precoProduto = By.cssSelector("div.price-quantity span:nth-child(2)");
	
	private By removerDoCarrinho = By.xpath("//form[@action='/cart/remove-item']//input[2][@value='Remover']");
	
	private By quantidadeProduto = By.cssSelector("input.item-quantity");
	
	private By botaoAddToCart = By.cssSelector("article.product-info section.actions-wrapper a");

   public ProdutoPage (WebDriver driver) {
	this.driver = driver;	
}
  public String obterNomeProduto () {
	  return driver.findElement(nomeProduto).getText();
  
}
  public String obterPrecoProduto() {
	  return driver.findElement(precoProduto).getText();
	  
	  
  }
  
  
  public void alterarQuantidade(int quantidade) {
		//driver.findElement(quantidadeProduto).clear();
		driver.findElement(quantidadeProduto).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		driver.findElement(quantidadeProduto).sendKeys(Integer.toString(quantidade));
		//driver.findElement(quantidadeProduto).clear();				
}
  
  public ModalProdutoPage clicarBotaoAddToCart() {
		driver.findElement(botaoAddToCart).click();
		return new ModalProdutoPage(driver);
}
  
  public String obterQuantidadeProduto() {
	  return driver.findElement(quantidadeProduto).getText();
	  
  }
	
  //public void clicarRemoverDoCarrinho() {
	 // driver.findElement(removerDoCarrinho).click();
//} 
  
}