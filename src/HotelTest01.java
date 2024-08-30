package src;

import java.util.List;
import java.util.Scanner;

public class HotelTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite seu CPF: ");
            String cpf = sc.nextLine();
            System.out.println("Digite seu telefone: ");
            String telefone = sc.nextLine();
            Cliente cliente = new Cliente(nome, cpf, telefone);

            Hotel hotel = new Hotel("ibis", "7283903", "lslsll@gmail.com", List.of(Quartos.SOLTEIRO, Quartos.CASAL));

            System.out.println("Escolha seu Quarto: ");
            hotel.mostrarPrecosQuartos();
            String escolhaDoQuarto = sc.nextLine();

            Reservar.AdicionarReserva(cliente, escolhaDoQuarto);

            System.out.println("Reservas atuais:");
            Reservar.mostrarReservas();

            System.out.println("Deseja adicionar outra reserva? (s/n)");
            String resposta = sc.nextLine();

            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        sc.close();
    }
}