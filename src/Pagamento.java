package src;

public class Pagamento {
    Quartos quartoEscolhido;
    private Double valorCompra;

    public Pagamento(Quartos quartoEscolhido) {
        this.quartoEscolhido = quartoEscolhido;
        this.valorCompra = calcularValorTotal(quartoEscolhido);

    }

    public Double calcularValorTotal(Quartos quartoEscolhido) {
        double valor = 0.0;

        if (Quartos.CASAL == quartoEscolhido) {
            valor = Quartos.CASAL.getPreco();
        } else {
            valor = Quartos.SOLTEIRO.getPreco();
        }
        return valorCompra = valor;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    private void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }
}