package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reservar {
    private Cliente cliente;
    private String quartoNumero;
    private final String codigo;

    private static List<Reservar> reservas = new ArrayList<>();
    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODIGO_LENGTH = 9;


    public Reservar(Cliente cliente, String quartoNumero, String codigo) {
        this.cliente = cliente;
        this.quartoNumero = quartoNumero;
        this.codigo = codigo;
    }

    public String reservarQuartoDoHotel(String numeroQuarto, String tipoDePagamento) {
        Pagamento pagamento = null;
        try {
            Quartos quartoEscolhido;

            if (numeroQuarto.equals("1")) {
                quartoEscolhido = Quartos.CASAL;
            } else if (numeroQuarto.equals("2")) {
                quartoEscolhido = Quartos.SOLTEIRO;
            } else {
                return "Número do quarto inválido!";
            }
            pagamento = new Pagamento(quartoEscolhido);
            Pagar pagar = new Pagar(tipoDePagamento, pagamento.getValorCompra());
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao processar a reserva.";
        }

        return "Valor: ";
    }

    private static String gerarCodigo() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder(CODIGO_LENGTH);

        for (int i = 0; i < CODIGO_LENGTH; i++) {
            int index = random.nextInt(CHAR_SET.length());
            codigo.append(CHAR_SET.charAt(index));
        }

        return codigo.toString();
    }

    public static void AdicionarReserva(Cliente cliente, String quartoEscolhido, String formaDePagamento) {
        try {
            if (quartoEscolhido.equals("1") || quartoEscolhido.equals("2") || quartoEscolhido.equals("3")) {
                String codigoDaReserva = gerarCodigo();

                Reservar reservaCliente = new Reservar(cliente, quartoEscolhido, codigoDaReserva);
                reservas.add(reservaCliente);
                reservaCliente.reservarQuartoDoHotel(quartoEscolhido, formaDePagamento);
                imprimirReserva(cliente);

            } else { System.out.println("Essa opção não existe"); }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao adicionar reserva: " + e.getMessage());
        }
    }

    public static void imprimirReserva(Cliente cliente) {
        boolean reservaEncontrada = false;

        try {
            for (Reservar reserva : reservas) {
                if (cliente.getCpf().equals(reserva.cliente.getCpf())) {
                    System.out.println("Reserva:");
                    System.out.println(reserva);
                    reservaEncontrada = true;
                }
            }
            if (!reservaEncontrada) { System.out.println("Nenhuma reserva encontrada para o cliente especificado."); }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao imprimir a reserva: " + e.getMessage());
        }
    }

    public String tipoDeQuarto() {
        if (quartoNumero.equals("1")) {
            return "Casal";
        } else {
            return "Solteiro";
        }
    }

    protected static void mostrarReservas() {
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println(reservas.get(i));
        }
    }

    @Override
    public String toString() {
        return "Cliente: " +
                cliente.getNome() +
                ", Quarto: " + tipoDeQuarto() +
                ", codigo: " + codigo;
    }
}