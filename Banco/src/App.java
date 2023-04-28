public class App {
    public static void main(String[] args) {
        // Criando algumas pessoas
        Pessoa pessoa1 = new Pessoa("Allan", 30);
        Pessoa pessoa2 = new Pessoa("Eduardo", 25);

        // Criando um banco
        Banco banco = new Banco();

        // Criando algumas contas
        Conta c1 = banco.criarConta(pessoa1, 500);
        Conta c2 = banco.criarConta(pessoa2, 2000);

        // Exibindo as informações das contas
        c1.Status();
        c2.Status();
        System.out.println();

        System.out.println("TRANSFERENCIA");
        // Realizando uma transferência
        boolean transferencia = banco.transferir(c1.getNumero(), c2.getNumero(), 1000);
        banco.extrato(c1.getNumero());

        // Status das Contas

        banco.depositar(1500, c1.getNumero());
        System.out.println("Allan depositou $1500");
        System.out.println();

        System.out.println("TRANSFERENCIA");
        transferencia = banco.transferir(c1.getNumero(), c2.getNumero(), 1000);

        System.out.println("Status");
        c1.Status();
        c2.Status();

        // Exibindo o total dos saldos do banco
        System.out.println("Total dos saldos: " + banco.somarSaldos());

        banco.sacar(200, c1.getNumero());
        c1.Status();

        System.out.println("extrato");
        c1.historico();

        // HISTORICO TRANSFERECIA
    }
}
