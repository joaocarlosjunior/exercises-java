package edu.esturaturadados.pilha;

public class Pilha<T> {
    private No<T> referenciaNoEntradaPilha;

    public Pilha() {
        this.referenciaNoEntradaPilha = null;
    }

    public void push(T obj){

        No<T> novoNo = new No<>(obj);

        No<T> refAuxiliar = this.referenciaNoEntradaPilha;
        this.referenciaNoEntradaPilha = novoNo;

        novoNo.setReferenciaNo(refAuxiliar);

    }

    public No<T> pop(){
        if(!this.isEmpty()){
            No<T> noPoped = this.referenciaNoEntradaPilha;
            referenciaNoEntradaPilha = referenciaNoEntradaPilha.getReferenciaNo();
            return noPoped;
        }
        return null;
    }

    public No<T> top(){
        return this.referenciaNoEntradaPilha;
    }

    public boolean isEmpty(){
        return this.referenciaNoEntradaPilha == null? true: false;
    }

    public String toString(){
        String stringRetorno = "-----------\n";
        stringRetorno += "MINHA PILHA\n";
        stringRetorno += "-----------\n";

        No<T> noAuxiliar = this.referenciaNoEntradaPilha;
        while(true){
            if(noAuxiliar != null){
                stringRetorno += "[No{Dado: " + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getReferenciaNo();
            }else{
                break;
            }
        }
        return stringRetorno;
    }
}
