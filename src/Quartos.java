package src;

public enum Quartos {
    SOLTEIRO(190.00),
    CASAL(230.00);

    private final double preco;

    Quartos(Double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
