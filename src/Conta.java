

import java.util.ArrayList;
import java.util.List;

public class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> clienteList;

    public Conta() {
        this.clienteList = new ArrayList<>();
    }

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }


    @Override
    public void adicionarCliente(String nome) {
        Cliente novoCliente = new Cliente(nome, Cliente.generateCPF());
        clienteList.add(String.valueOf(novoCliente));
    }

    public void removerCliente(String nome) {
        List<String> clientesRemover = new ArrayList<>();
        if (!clienteList.isEmpty()) {
            for (String s : clienteList) {
                if (cliente.getNome().equalsIgnoreCase(nome)) {
                    clientesRemover.add(s);
                    clienteList.removeAll(clientesRemover);
                }
            }
        }

    }

    public void exibirClientes() {
        System.out.println(clienteList);
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println("CPF:" + this.cliente.getCpf());
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
