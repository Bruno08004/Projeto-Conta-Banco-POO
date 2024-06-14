//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente bruno = new Cliente();
        bruno.setNome("Bruno");
        bruno.getCpf();

        Conta conta = new ContaPoupanca(bruno);

        conta.depositar(100);
        conta.imprimirExtrato();



   ///Para adicionar os clientes em uma LISTA DE CLIENTES
//        Conta conta = new Conta();
//        conta.adicionarCliente("Bruno");
//        conta.adicionarCliente("Bruno");
//        conta.exibirClientes();

    }

}



