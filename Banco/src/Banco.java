import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    private Conta encontrarConta(double saldo) {
        return null;
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

    // add depositar
    public void extrato(int numeroConta) {
        Conta conta = null;
        // Procura a conta pelo número
        for (Conta c : this.contas) {
            if (c.getNumero() == numeroConta) {
                conta = c;
                break;
            }
        }

        // Se a conta foi encontrada, imprime o extrato
        if (conta != null) {
            System.out.println("----- Extrato da Conta " + conta.getNumero() + " -----");
            System.out.println("Data: " + new Date());
            System.out.println("Descrição: Saldo anterior: " + conta.getSaldo());
            System.out.println("Valor: " + conta.getSaldo());
            System.out.println();
        } else {
            System.out.println("Conta não encontrada!");
            System.out.println();
        }
    }
    // SACAR

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
        // extrato
        /* */
        if (contOrg.getSaldo() >= valor) {
            // add no historico
            contOrg.historico.add("Transferência para Conta " + valor);
            contDest.historico.add("Transferência da Conta " + contOrg.getNumero() + ": +" + valor);

            System.out.println("----- Transferencia da Conta " + contOrg.getNumero() + " -----");
            System.out.println("Data: " + new Date());
            System.out.println("Descrição: Transferência para a Conta " + contDest.getNumero());
            System.out.println("Valor: -" + valor);
            System.out.println();

            System.out.println("----- Transferencia da Conta " + contDest.getNumero() + " -----");
            System.out.println("Data: " + new Date());
            System.out.println("Descrição: Transferência da Conta " + contOrg.getNumero());
            System.out.println("Valor: +" + valor);
            System.out.println();
            System.out.println("Transferência realizada com sucesso!");
            System.out.println();

            return true;
        } else {
            System.out.println("****************************************************************");
            System.out.println(contOrg.getProprietario().getNome()
                    + " não foi possível realizar a transferência,Saldo insuficiente.");
            System.out.println("Saldo:" + contOrg.getSaldo());
            System.out.println("Valor:" + valor);
            System.out.println("****************************************************************");
            System.out.println();

            return false;
        }

    }

    public boolean depositar(double valor, int idConta) {
        Conta conta = encontrarConta(idConta);
        for (Conta c : this.contas) {
            if (c.getNumero() == idConta) {
                conta = c;
                break;
            }
        }
        if (conta == null || valor <= 0) {
            return false;
        }
        conta.historico.add("Depositou o valor de R$ " + valor);
        conta.setSaldo(conta.getSaldo() + valor);
        return true;
    }

    public boolean sacar(double valor, int idConta) {
        Conta conta = encontrarConta(idConta);
        for (Conta c : this.contas) {
            if (c.getNumero() == idConta) {
                conta = c;
                break;
            }
        }
        if (conta == null || valor <= 0) {
            return false;
        }
        conta.historico.add("Sacou o valor de R$ " + valor);
        conta.setSaldo(conta.getSaldo() - valor);
        return true;
    }

}
