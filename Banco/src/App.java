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

        // Realizando uma transferência
        boolean transferencia = banco.transferir(c1.getNumero(), c2.getNumero(), 1000);
        banco.extrato(c1.getNumero(), c2.getNumero());
        /*
         * // Exibindo as informações atualizadas das contas
         * System.out.println("Conta 1:");
         * System.out.println("Proprietário: " + c1.getProprietario().getNome());
         * System.out.println("Saldo: " + c1.getSaldo());
         * 
         * System.out.println("Conta 2:");
         * System.out.println("Proprietário: " + c2.getProprietario().getNome());
         * System.out.println("Saldo: " + c2.getSaldo());
         */
        // Status das Contas
        System.out.println();
        System.out.println("Status");
        c1.Status();
        c2.Status();

        // Exibindo o total dos saldos do banco
        System.out.println("Total dos saldos: " + banco.somarSaldos());

    }
}
