package edu.projeto.entidade;

import edu.projeto.entidade.constantes.Materias;

public class Caderno extends Produto{
    private Materias materia;

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public Materias getMateria() {
        return materia;
    }

    public double calcularFrete() {
        return (getPreco() * getQuantidade()) + materia.getFator();
    }

    public String toString() {
        return "Caderno{" +
                "materia='" + materia + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
}
