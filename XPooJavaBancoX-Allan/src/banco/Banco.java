package banco;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList<Conta>();
    }

    public Conta criarConta(Pessoa proprietario) {
        int numero = contas.size() + 1;
        Conta conta = new Conta(numero, proprietario);
        contas.add(conta);
        return conta;
    }

    public double somarSaldos() {
        double total = 0.0;
        for (Conta conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente na conta de origem");
        }
        origem.sacar(valor);
        destino.depositar(valor);
    }
}
