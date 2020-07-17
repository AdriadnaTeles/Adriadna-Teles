package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class HomePage {

	private static WebDriver driver;
	
	List<WebElement> listaProdutos = new ArrayList();
	
	private By textoProdutosNoCarrinho = By.className("empty");
	
	private By produtos = By.cssSelector("section .description p.name");
	
	private By descricoesDosProdutos = By.cssSelector("section .description p.name");
	
	private By precoDosProdutos = By.cssSelector("p .official-price");
	
	private By botaoSignIn = By.id("login-link");
	
	private By usuarioLogado = By.cssSelector("label span.name");
	
	private By botaoSair = By.id("submenu-logout");
	
	public HomePage (WebDriver driver) {
		this.driver = driver;	
}
     public int contarProdutos() {
        	carregarListaProdutos();
        	return listaProdutos.size();
        	
        }
     
     private void carregarListaProdutos() {
       	 listaProdutos = driver.findElements(produtos);  
}   
      public int obterQuantidadeProdutosNoCarrinho() {
    	 String quantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho).getText();
    	 quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace("Meu carrinho","0") ;
    	 //quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace(">","") ;
    	 int qtdProdutosNoCarrinho = Integer.parseInt(quantidadeProdutosNoCarrinho);
    	 return qtdProdutosNoCarrinho;
      } 	 

     public String obterNomeProduto (int indice){
    	 return driver.findElements(descricoesDosProdutos).get(indice).getText();
    	 
     }	 
     public String obterPrecoProduto (int indice) {
    	return driver.findElements(precoDosProdutos).get(indice).getText();
    	 
     }
     
     public ProdutoPage clicarProduto (int indice) {
    	driver.findElements(descricoesDosProdutos).get(indice).click();
    	return new ProdutoPage (driver);
     }
     
     public LoginPage clicarBotaoSign () {
  	 driver.findElement(botaoSignIn).click();
     return new LoginPage (driver);
     }
     
     public boolean estaLogado (String texto) {
    	 return texto.contentEquals (driver.findElement(usuarioLogado).getText());
     }
    
     public HomePage clicarEstaLogado () {
    	 driver.findElement(usuarioLogado).click();
    	 return new HomePage (driver);
    
     }
     
     public HomePage clicarBotaoSair() {
    	 driver.findElement(botaoSair).click();
    	 return new HomePage (driver);
     }
    }
    	 
     
     
    
    
      
    
         