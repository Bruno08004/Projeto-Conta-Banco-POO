import java.util.Random;

public class Cliente {

    private String nome;
    private String cpf;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = formatCPF(generateCPF());
    }


    public String getCpf() {
        return formatCPF(generateCPF());
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String s) {
        this.cpf = formatCPF(generateCPF());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nome='" + getNome() + '\'' +
                ", CPF='" + formatCPF(generateCPF()) + '\'' +
                '}';
    }
    public static String generateCPF() {
        Random random = new Random();
        int[] cpf = new int[11];

        // Gera os primeiros 9 dígitos do CPF
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        // Calcula o primeiro dígito verificador
        cpf[9] = calculateVerifierDigit(cpf, 10);

        // Calcula o segundo dígito verificador
        cpf[10] = calculateVerifierDigit(cpf, 11);

        StringBuilder sb = new StringBuilder();
        for (int digit : cpf) {
            sb.append(digit);
        }
        return sb.toString();
    }

    private static int calculateVerifierDigit(int[] cpf, int weight) {
        int sum = 0;
        for (int i = 0; i < weight - 1; i++) {
            sum += cpf[i] * (weight - i);
        }
        int result = 11 - (sum % 11);
        return (result > 9) ? 0 : result;
    }

    public static String formatCPF(String cpf) {
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }
}

