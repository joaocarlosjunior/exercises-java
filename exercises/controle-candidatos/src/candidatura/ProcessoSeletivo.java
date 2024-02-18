package candidatura;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        ArrayList<Candidato> candidatosSelecionados = selecionarCandidatos();

        System.out.println("Candidatos Selecionados:");
        for (Candidato candidato: candidatosSelecionados){
            System.out.println(candidato.getName() + " Salário: " + new DecimalFormat(".##").format(candidato.getSalarioPretendido()));
        }

        System.out.println("Entrando em contato com candidatos selecionados:");
        for (Candidato candidato: candidatosSelecionados){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(Candidato candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }
        }while (continuarTentando && tentativasRealizadas <= 3);

        if(atendeu){
            System.out.println("Contato realizado com sucesso com " + candidato.name + " na " + tentativasRealizadas + " tentativa.");
        }else{
            System.out.println("Candidato " + candidato.name + " não atendeu.");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static ArrayList<Candidato> selecionarCandidatos(){
        String []  candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        ArrayList<Candidato> selecionados = new ArrayList<>();
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " pretende ter o salário " + salarioPretendido);
            if(analisarCandidato(salarioPretendido)){
                selecionados.add(new Candidato(candidato, salarioPretendido));
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        return selecionados;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    static boolean analisarCandidato(double salarioPretedendido){
        double salarioBase = 2000.0;

        return salarioBase >= salarioPretedendido;
    }
}
