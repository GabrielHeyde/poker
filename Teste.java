//Gabriel Heyde Pintos e Jardel Nikolas Mathias Ferreira

public class Teste {
    public static void main(String[] args) {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------\nBem vindo(a), ao jogo de Poker! Aqui você mostrará suas habilidades. Jogando contra robôs que realizam ações aleatórias, você deve conseguir superá-los e se tornar o grande campeão!\n----------------------------------------------------------------------------------------------------------------\n");

        String nome = Teclado.leString("Para começar, digite seu nome: ");

        Jogador j1 = new Jogador(nome, "");
        Jogador j2 = new Jogador("J2", "");
        Jogador j3 = new Jogador("J3", "");
        Jogador j4 = new Jogador("J4", "");
        Jogador j5 = new Jogador("J5", "");

        Jogador[] j0 = { j1, j2, j3, j4, j5 };

        Controle teste = new Controle(j0);
        int x = 0;

        int statusDealer = (int) (Math.random() * 5);
        teste.getJogadores()[statusDealer].setStatus("Dealer");

        int statusSmallBlind = statusDealer + 1;
        if (statusSmallBlind == 5) {
            statusSmallBlind = 0;
        }
        teste.getJogadores()[statusSmallBlind].setStatus("Small Blind");

        int statusBigBlind = statusSmallBlind + 1;
        if (statusBigBlind == 5) {
            statusBigBlind = 0;
        }
        teste.getJogadores()[statusBigBlind].setStatus("Big Blind");

        int jogadoresNaRodada = 5;
        while (jogadoresNaRodada > 1) {
            Baralho baralhonovo = new Baralho();
            while (x < 10000) {
                teste.getB().embaralha();
                x++;
            }
            System.out.println("");
            System.out.println("Próxima Rodada!");
            System.out.println("");
            if (jogadoresNaRodada > 2) {
                System.out.println("DEALER DA RODADA: " + teste.getJogadores()[statusDealer].getNome());

            }
            System.out.println("");

            teste.distruibuirCartas();

            teste.apostasIniciais();

            teste.trocarAsCartas();

            System.out.println("\nApostas da Rodada!\n");

            teste.apostasJogo();

            teste.rodada();

            teste.setB(baralhonovo);

            System.out.println("\n=======================================================================================================================================================================================================================");

            jogadoresNaRodada = teste.getJogadoresNaRodada();

            if (jogadoresNaRodada > 2) {
                statusDealer++;
                if (statusDealer == 5) {
                    statusDealer = 0;
                }
                if (teste.getJogadores()[statusDealer] == null) {
                    while (teste.getJogadores()[statusDealer] == null) {
                        statusDealer++;
                        if (statusDealer == 5) {
                            statusDealer = 0;
                        }
                    }
                }

                teste.getJogadores()[statusDealer].setStatus("Dealer");

                statusSmallBlind++;
                if (statusSmallBlind == 5) {
                    statusSmallBlind = 0;
                }
                while (teste.getJogadores()[statusSmallBlind] == null) {
                    statusSmallBlind++;
                    if (statusSmallBlind == 5) {
                        statusSmallBlind = 0;
                    }
                }
                teste.getJogadores()[statusSmallBlind].setStatus("Small Blind");

                statusBigBlind++;
                if (statusBigBlind == 5) {
                    statusBigBlind = 0;
                }
                while (teste.getJogadores()[statusBigBlind] == null) {
                    statusBigBlind++;
                    if (statusBigBlind == 5) {
                        statusBigBlind = 0;
                    }
                }
                teste.getJogadores()[statusBigBlind].setStatus("Big Blind");
            }

            if (jogadoresNaRodada == 2) {

                // Verifica se tem algum dealer na rodada
                boolean temDealer = false;
                int posicaoDealer = -1;
                for (int i = 0; i < teste.getJogadores().length; i++) {
                    if (teste.getJogadores()[i] != null) {
                        if (teste.getJogadores()[i].getStatus().equals("Dealer")) {
                            temDealer = true;
                            posicaoDealer = i;
                            break;
                        }
                    }
                }

                if (temDealer == true) {
                    teste.getJogadores()[posicaoDealer].setStatus("Small Blind");
                    for (int i = 0; i < teste.getJogadores().length; i++) {
                        if (teste.getJogadores()[i] != null && i != posicaoDealer) {
                            teste.getJogadores()[i].setStatus("Big Blind");
                            break;
                        }
                    }
                }

                if (temDealer == false) {
                    for (int i = 0; i < teste.getJogadores().length; i++) {
                        if (teste.getJogadores()[i] != null) {
                            if (teste.getJogadores()[i].getStatus().equals("Big Blind")) {
                                teste.getJogadores()[i].setStatus("Small Blind");
                            } else if (teste.getJogadores()[i].getStatus().equals("Small Blind")) {
                                teste.getJogadores()[i].setStatus("Big Blind");
                            }
                        }
                    }
                }
            }
        }
        int posicaovencedor = 7;
        for (int i = 0; i < teste.getJogadores().length; i++) {
            if (teste.getJogadores()[i] != null) {
                posicaovencedor = i;
                break;
            }
        }

        System.out.println("O jogador chamado de " + teste.getJogadores()[posicaovencedor].getNome()
                + " superou os seus adversários e foi o campeão do jogo de Poker. Parabéns!\n\nSinta-se à vontade para jogar novamente sempre que você quiser =D");
    }
}