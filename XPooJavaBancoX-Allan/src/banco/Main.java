package banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // essa é a parte em que você cria as contas
        System.out.print("Digite o nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();
        Pessoa pessoa1 = new Pessoa(nome1, "123.456.789-00");

        System.out.print("Digite o nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();
        Pessoa pessoa2 = new Pessoa(nome2, "987.654.321-00");

        // conectada a parte de bancdo
        Banco banco = new Banco();

        // conectada a parte de conta
        Conta conta1 = banco.criarConta(pessoa1);
        Conta conta2 = banco.criarConta(pessoa2);

    
        System.out.print("Digite o valor para depositar na conta 1: ");
        double valorDepositoConta1 = scanner.nextDouble();
        conta1.depositar(valorDepositoConta1);

        System.out.print("Digite o valor para depositar na conta 2: ");
        double valorDepositoConta2 = scanner.nextDouble();
        conta2.depositar(valorDepositoConta2);

     
        System.out.print("Digite o valor para transferir da conta 1 para a conta 2: ");
        double valorTransferencia = scanner.nextDouble();
        banco.transferir(conta1, conta2, valorTransferencia);


        System.out.println("Saldo da conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da conta 2: " + conta2.getSaldo());
    }
}
