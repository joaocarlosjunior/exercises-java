package candidatura;

public class Candidato {
    String name;
    double salarioPretendido;

    public Candidato(){}
    public Candidato(String name, double salarioPretendido){
        this.name = name;
        this.salarioPretendido = salarioPretendido;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalarioPretendido(double salarioPretendido) {
        this.salarioPretendido = salarioPretendido;
    }

    public double getSalarioPretendido() {
        return salarioPretendido;
    }

    public String getName() {
        return name;
    }

}
