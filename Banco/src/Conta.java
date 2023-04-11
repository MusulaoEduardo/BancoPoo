public class Conta {
    private static int proxNumero = 1;

    private int numero;
    private Pessoa proprietario;
    private double saldo;

    public Conta(Pessoa proprietario, double saldoInicial) {
        
        this.numero = proxNumero;
        proxNumero++;

        this.proprietario = proprietario;
        this.saldo = saldoInicial;
    }

    public void Status(){
        System.out.println("---------------------------");
        System.out.println("Conta:"+this.numero);
        System.out.println("Nome: "+getProprietario().getNome());
        System.out.println("Saldo: "+this.saldo);
        System.out.println("---------------------------");
        System.out.println();

        
    }

    public int getNumero() {
        return this.numero;
    }

    public Pessoa getProprietario() {
        return this.proprietario;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }

        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            return false;
        }

        this.saldo -= valor;
        return true;
    }
}
