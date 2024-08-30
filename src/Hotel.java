package src;

import java.util.List;

public class Hotel {
    private List<Quartos> tiposQuartos;
    public String nome;
    public String telefone;
    public String email;

    public Hotel(String nome, String telefone, String email, List<Quartos> tiposQuartos) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.tiposQuartos = tiposQuartos;
    }

    public void mostrarPrecosQuartos() {
        System.out.println(" << Quartos disponiveis >> ");
        System.out.println("1" + "- Quarto de casal: " + Quartos.CASAL.getPreco());
        System.out.println("2" + "- Quarto de solteiro: " + Quartos.SOLTEIRO.getPreco());
    }

}