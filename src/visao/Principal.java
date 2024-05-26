package visao;

import dominio.Moeda;
import persistencia.ConsultaCambio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaCambio consultaCambio = new ConsultaCambio();
        Scanner teclado = new Scanner(System.in);
        int menu = 0;
        String moedaOrigem = "";
        String moedaDestino = "";

        try {
            while (true){
                System.out.println("-----Menu------");
                System.out.println("""
                    1 - [ARS] para [BRL]
                    2 - [BOB] para [BRL]
                    3 - [BRL] para [USD]
                    4 - [CLP] para [BRL]
                    5 - [COP] para [BRL]
                    6 - [USD] para [BRL]
                    7 - Sair""");
                System.out.print("Escolha uma opção: ");
                menu = teclado.nextInt();
                if (menu == 7) {
                    break;
                }

                switch (menu){
                    case 1:
                        moedaOrigem = "ARS";
                        moedaDestino = "BRL";
                        break;
                    case 2:
                        moedaOrigem = "BOB";
                        moedaDestino = "BRL";
                        break;
                    case 3:
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 4:
                        moedaOrigem = "CLP";
                        moedaDestino = "BRL";
                        break;
                    case 5:
                        moedaOrigem = "COP";
                        moedaDestino = "BRL";
                        break;
                    case 6:
                        moedaOrigem = "USD";
                        moedaDestino = "BRL";
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente!");
                        continue;
                }
                System.out.print("Qual valor do cambio? ");
                double cambio = teclado.nextDouble();

                double resultado = consultaCambio.buscar(moedaOrigem, moedaDestino, cambio);
                System.out.println("Resultado: " + resultado);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
