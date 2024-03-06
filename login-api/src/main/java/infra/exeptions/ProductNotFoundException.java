package infra.exeptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String name) {
  super("Usuario não encontrado: " + name);
  }
}