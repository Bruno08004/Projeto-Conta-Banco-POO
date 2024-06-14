public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

    void adicionarCliente(String nome);

    void removerCliente(String nome);

    void exibirClientes();
}
