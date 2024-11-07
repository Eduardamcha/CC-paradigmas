import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atletas {

    static class Atleta {
        String nome;
        String sexo;
        double altura;
        double peso;

        Atleta(String nome, String sexo, double altura, double peso) {
            this.nome = nome;
            this.sexo = sexo;
            this.altura = altura;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler a quantidade de atletas
        System.out.print("Qual a quantidade de atletas? ");
        int N = scanner.nextInt();
        while (N <= 0) {
            System.out.print("Por favor, digite um número maior que 0: ");
            N = scanner.nextInt();
        }
        scanner.nextLine();  // Consumir a nova linha

        List<Atleta> atletas = new ArrayList<>();
        double totalPeso = 0;
        double totalAlturaMulheres = 0;
        int contMulheres = 0;
        String atletaMaisAlto = "";
        double alturaMaxima = 0;
        int contHomens = 0;

        // Ler dados dos atletas
        for (int i = 0; i < N; i++) {
            System.out.printf("Digite os dados do atleta número %d:%n", (i + 1));
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            // Validação do sexo
            String sexo;
            do {
                System.out.print("Sexo (F/M): ");
                sexo = scanner.nextLine().toUpperCase();
                if (!sexo.equals("F") && !sexo.equals("M")) {
                    System.out.println("Valor inválido! Por favor, digite 'F' para feminino ou 'M' para masculino.");
                }
            } while (!sexo.equals("F") && !sexo.equals("M"));

            // Validação da altura
            double altura;
            do {
                System.out.print("Altura (em metros): ");
                altura = scanner.nextDouble();
                if (altura <= 0) {
                    System.out.println("Altura inválida! Por favor, digite um valor positivo.");
                }
            } while (altura <= 0);

            // Validação do peso
            double peso;
            do {
                System.out.print("Peso (em kg): ");
                peso = scanner.nextDouble();
                if (peso <= 0) {
                    System.out.println("Peso inválido! Por favor, digite um valor positivo.");
                }
            } while (peso <= 0);

            scanner.nextLine();  // Consumir a nova linha após a leitura de peso

            // Armazenar os dados do atleta
            atletas.add(new Atleta(nome, sexo, altura, peso));
            totalPeso += peso;

            // Verificar atleta mais alto
            if (altura > alturaMaxima) {
                alturaMaxima = altura;
                atletaMaisAlto = nome;
            }

            // Cálculo de dados específicos
            if (sexo.equals("F")) {
                totalAlturaMulheres += altura;
                contMulheres++;
            } else {
                contHomens++;
            }
        }

        // Relatório
        double pesoMedio = totalPeso / N;
        double porcentagemHomens = (contHomens / (double) N) * 100;

        System.out.println("\n### RELATÓRIO ###");
        System.out.printf("Peso médio dos atletas: %.2f kg%n", pesoMedio);
        System.out.println("Atleta mais alto: " + atletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f%%%n", porcentagemHomens);

        if (contMulheres > 0) {
            double alturaMediaMulheres = totalAlturaMulheres / contMulheres;
            System.out.printf("Altura média das mulheres: %.2f m%n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas.");
        }

        scanner.close();
    }
}