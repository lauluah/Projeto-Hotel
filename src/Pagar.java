package src;

public class Pagar {
    private String debito;
    private String credito;
    private String pix;
    private String cupom = "Ferias20";
    private double descontoPix = 0.10;
    private String tipoDePagamento;
    private double valorDaCompra;

    public Pagar(String tipoDePagamento, double valorDaCompra) {
        this.tipoDePagamento = tipoDePagamento;
        this.valorDaCompra = valorDaCompra;
        formaDePagamento(tipoDePagamento);
    }

    public void formaDePagamento(String tipoDePagamento) {
          if(tipoDePagamento.equals("1")) {
              System.out.println("Opção escolhida: debito");
              System.out.println("valor total da compra: " + this.valorDaCompra);
          } else if(tipoDePagamento.equals("2")) {
              System.out.println("Opção escolhida: credito");
              System.out.println("valor total da compra: " + this.valorDaCompra);
          } else if(tipoDePagamento.equals("3")) {
              System.out.println("Opção escolhida: pix - Desconto de 10% ");
              mostrarDesconto();
          } else { System.out.println("Essa opção não existe"); }
    }

    public double calcularDesconto() {
          double valorCompra = this.valorDaCompra;
          double desconto = (valorCompra * descontoPix);
          double valorComDesconto = valorCompra - desconto;
          return valorComDesconto;
    }

    public void mostrarDesconto() {
        System.out.println("Valor com desconto: " + calcularDesconto());
    }
}
