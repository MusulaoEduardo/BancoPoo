import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public Conta criarConta(Pessoa proprietario, double saldo) {
        Conta conta = new Conta(proprietario, saldo);
        this.contas.add(conta);
        return conta;
    }

    public double somarSaldos() {
        double total = 0;
        for (Conta conta : this.contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    public void extrato(int numerocontOrg, int numerocontDest) {

    }

    public boolean transferir(int numerocontOrg, int numerocontDest, double valor) {
        Conta contOrg = null;
        Conta contDest = null;

        // Procura as contas pelo número
        for (Conta conta : this.contas) {
            if (conta.getNumero() == numerocontOrg) {
                contOrg = conta;
            } else if (conta.getNumero() == numerocontDest) {
                contDest = conta;
            }
        }
        if (contOrg.getSaldo() >= valor) {
            // extrato
            System.out.println("----- Extrato da Conta " + contOrg.getNumero() + " -----");
            System.out.println("Data: " + new Date());
            System.out.println("Descrição: Transferência para a Conta " + contDest.getNumero());
            System.out.println("Valor: -" + valor);
            System.out.println();

            System.out.println("----- Extrato da Conta " + contDest.getNumero() + " -----");
            System.out.println("Data: " + new Date());
            System.out.println("Descrição: Transferência da Conta " + contOrg.getNumero());
            System.out.println("Valor: +" + valor);
            System.out.println();
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("****************************************************************");
            System.out.println(contOrg.getProprietario().getNome() +" não foi possível realizar a transferência,Saldo insuficiente.");
            System.out.println("Saldo:"+contOrg.getSaldo());
            System.out.println("Valor:"+valor);
            System.out.println("****************************************************************");
        }

        // Se as contas foram encontradas e o saldo da conta origem é suficiente, faz a
        // transferência
        if (contOrg != null && contDest != null && contOrg.sacar(valor)) {
            contDest.depositar(valor);
            return true;
        } else {
            return false;
        }

    }
}
