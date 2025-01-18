import java.util.ArrayList;
import java.util.Scanner;


class UrnaEletronica{
    private static ArrayList<Candidato> arrayCandidatos = new ArrayList<>();
    private int votosNulo;
    private boolean nenhumVotoValido;
            
            //metodo para configurar a urna com os candidatos
            public void configUrnaEletronica(){                   
                
                Candidato candidato01 = new Candidato("Ada Lovelace", 1);
                Candidato candidato02 = new Candidato("Alan Turing", 2);
                Candidato candidato03 = new Candidato("Marie Curie", 3);
                Candidato candidato04 = new Candidato("Albert Einstein", 4);
                Candidato candidato05 = new Candidato("Ludwig van Beethoven", 5);        
                arrayCandidatos.add(candidato01);
                arrayCandidatos.add(candidato02);
                arrayCandidatos.add(candidato03);
                arrayCandidatos.add(candidato04);
                arrayCandidatos.add(candidato05);        
            }
            
            //Metodo para inserir vodo na array do candidato 
            public void adicionarVoto(int numero){
                if (numero < 1 || numero > 5){     
                    votosNulo++;           
                }else{
                    for (Candidato candidato : arrayCandidatos){
                        if (candidato.getNumero() == numero){
                        candidato.incrementarVotos();
                        break;
                        }
                    }
                }                
            }

            //Faz a apuração do vencedor 
            public ArrayList<String> apurarVotos(){
                int maxVotos = 0; 
                ArrayList<String> vencedor = new ArrayList<>(); 
                if (votosNulo == 10){
                    nenhumVotoValido = true;
                }else{
                    for (Candidato candidato : arrayCandidatos) {
                        if (candidato.getVotos() > maxVotos){   
                            maxVotos = candidato.getVotos();
                            vencedor.clear();
                            vencedor.add(candidato.getNome());
                        }else if(candidato.getVotos() == maxVotos && maxVotos > 0){
                            vencedor.add(candidato.getNome());
                        }
                    }
                }
                return vencedor;
            }

            //Metodo para divulgar o resultado
            public void divulgarResultado(ArrayList<String> vencedor){
                double porcentagem = 0;
                String nome;
                int votos;
                if(nenhumVotoValido){
                    System.out.println("Resultado da Votação: \n");
                    System.out.println("Nenhum candidato teve voto nessa eleição!");
                    for (Candidato candidato : arrayCandidatos){
                        nome = candidato.getNome();
                        votos = candidato.getVotos();
                        porcentagem = candidato.getVotos()*10;
                        System.out.println(nome + ":" + votos + " (" +porcentagem +")");
                    }
                    System.out.println("Votos nulos: " + votosNulo);
                }else if(vencedor.size() > 1){
                    System.out.println("Resultado da Votação: \n");
                    for (Candidato candidato : arrayCandidatos){
                        nome = candidato.getNome();
                        votos = candidato.getVotos();
                        porcentagem = candidato.getVotos()*10;
                        if (votos == 1){
                            System.out.println(nome + ": " + votos + " voto (" +porcentagem +"%)");
                        }else{
                            System.out.println(nome + ": " + votos + " votos (" +porcentagem +"%)");
                        }
                    }
                    System.out.println("Votos nulos: " + votosNulo + "\n");
                    System.out.println("Houve empate entre os candidatos: \n");
                    for (String string : vencedor) {
                        System.out.println(string);
                    }                      
                }else{    
                    System.out.println("Resultado da Votação: \n");
                    for (Candidato candidato : arrayCandidatos){
                        nome = candidato.getNome();
                        votos = candidato.getVotos();
                        porcentagem = candidato.getVotos()*10;
                        if (votos == 1){
                            System.out.println(nome + ": " + votos + " voto (" +porcentagem +"%)");
                        }else{
                            System.out.println(nome + ": " + votos + " votos (" +porcentagem +"%)");
                        }
                    }
                    System.out.println("Votos nulos: " + votosNulo);
                    System.out.println("Vencedor: " + vencedor.get(0));         
                }
            }
}

public class UrnaEletronicaJava {    
    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();
        Scanner scanner = new Scanner(System.in);
        urna.configUrnaEletronica();
        System.out.println("Bem-vindo à Urna Eletrônica!\n");
        System.out.println("Candidatos:\r\n" + //
                        "01 - Ada Lovelace\r\n" + //
                        "02 - Alan Turing\r\n" + //
                        "03 - Marie Curie\r\n" + //
                        "04 - Albert Einstein\r\n" + //
                        "05 - Ludwig van Beethoven");
        //Laço para receber os votos
        for (int i = 0; i < 10; i++){
            System.out.println("Digite o número do seu candidato:");
            String entrada = scanner.nextLine();
            /*Verificar se o numero de 01 até 05 foi digitado corretamente
            caso seja digitado 1 ou 5, retorna entrada invalida e pede novamente*/
            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3") || entrada.equals("4") || entrada.equals("5")){
                System.out.println("Entrada invalida, tente novamente!");
                i--;
            }else{
                if (entrada.length() < 2 || entrada.length() > 2){
                    urna.adicionarVoto(0);
                }else{
                    int numeroConverter = Integer.parseInt(entrada);
                    urna.adicionarVoto(numeroConverter);
                }
            }
        }
        scanner.close();
        urna.divulgarResultado(urna.apurarVotos());
    }
}
