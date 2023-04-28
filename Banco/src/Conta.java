import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static int proxNumero = 1;

    private int numero;
    private Pessoa proprietario;
    private double saldo;
    List<String> historico;

    public Conta(Pessoa proprietario, double saldoInicial) {

        this.numero = proxNumero;
        proxNumero++;

        this.proprietario = proprietario;
        this.saldo = saldoInicial;
        historico = new ArrayList<>();
    }

    public void Status() {
        System.out.println("---------------------------");
        System.out.println("Conta:" + this.numero);
        System.out.println("Nome: " + getProprietario().getNome());
        System.out.println("Saldo: " + this.saldo);
        System.out.println("---------------------------");
        System.out.println();

    }

    public void historico() {
        System.out.println("Histórico da Conta " + this.getNumero());
        for (String historico : this.historico) {
            System.out.println(historico);
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public Pessoa getProprietario() {
        return this.proprietario;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

}
