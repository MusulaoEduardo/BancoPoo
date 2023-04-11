package banco;

public class Conta {
    private int numero;
    private Pessoa proprietario;
    private double saldo;

    public Conta(int numero, Pessoa proprietario) {
        this.numero = numero;
        this.proprietario = proprietario;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}
