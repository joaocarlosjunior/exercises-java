package edu.esturaturadados.fila;

public class Fila<T> {
    private No<T> referenciaNoEntrada;

    public Fila() {
        this.referenciaNoEntrada = null;
    }

    public void enqueue(T obj) {

        No<T> novoNo = new No<>(obj);
        novoNo.setRefProximoNo(referenciaNoEntrada);
        referenciaNoEntrada = novoNo;

    }

    public Object dequeue() {
        if (!isEmpty()) {
            No<T> primeiroNo = referenciaNoEntrada;
            No<T> noAuxiliar = referenciaNoEntrada;
            while (true) {
                if (primeiroNo.getRefProximoNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    noAuxiliar.setRefProximoNo(null);
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    public T first() {

        if (!isEmpty()) {
            No<T> primeiroNo = referenciaNoEntrada;
            while (true) {
                if (primeiroNo.getRefProximoNo() != null) {
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty() {
        return referenciaNoEntrada == null ? true : false;
    }

    public String toString(){
        String stringRetorno = "";

        No<T> noAuxiliar = referenciaNoEntrada;

        if(!isEmpty()){
            while (true){
                stringRetorno += "[No{Objeto = " + noAuxiliar.getObject() + "}] --->";
                if(noAuxiliar.getRefProximoNo() != null){
                    noAuxiliar = noAuxiliar.getRefProximoNo();
                }else{
                    stringRetorno += " null";
                    break;
                }
            }
        }
        return stringRetorno;
    }

}
