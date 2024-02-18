package edu.esturaturadados.fila;

public class No<T> {
    private T object;
    private No<T> refProximoNo;

    public No(){
    }

    public No(T object){
        this.object = object;
        this.refProximoNo = null;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No<T> getRefProximoNo() {
        return refProximoNo;
    }

    public void setRefProximoNo(No<T> refProximoNo) {
        this.refProximoNo = refProximoNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
