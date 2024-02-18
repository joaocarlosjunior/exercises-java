# Projeto
Uma loja vende livros e cadernos. Livro tem nome e gênero. Já carderno tem
quantidade de materias. Ambos tem preço e uma quantidade que pode ser
comprada. <br>Os pedidos podem ou não ter um cupom de desconto aplicado ao
valor total. Este cupom tem código e porcentagem de desconto. Os pedidos
são de um cliente, qual tem um nome e cpf. <br> Os pedido podem ser só de
livros,  de cadernos ou ambos. Por fim, o valor do frete varia de acordo com a
quantide de cada item, seu preço e um fator a depender de seu tipo.
<br>Os tipos para livro são: **DRAMA**, **SUSPENSE** e **ROMANCE** com os fatores 0.15, 0.10
e 0.05 respectivamente. Tal fator é multiplicativo, ao total calculado: preco *
quantidade.
Os tipos para caderno são: M2, M5 e M10 com os fatores 2, 5 e 10
respectivamente.Tal fator é aditivo, ao total calculado: preco * quantidade.

## UML
![Diagrama UML](https://github.com/joaocarlosjunior/exercises-java/blob/main/projeto-poo-java/assets/images/uml.png)