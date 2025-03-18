package controle;
import dominio.*;
public class TesteListaGenerica {

   public static void main(String[] args) {
	   ListaGenerica<Integer> listaInt = new ListaGenerica<>(3);
	   listaInt.adicionar(10);
	   listaInt.adicionar(20);
	   listaInt.adicionar(30);
	   System.out.println("Lista de Inteiros:");

	   listaInt.exibir();

	   listaInt.adicionar(40);
	   listaInt.exibir();
	   // Lista de Strings
	   ListaGenerica<String> listaStr = new ListaGenerica<>(3);
	   listaStr.adicionar("Java");
	   listaStr.adicionar("C++");
	   listaStr.adicionar("Python");
	   System.out.println("Lista de Strings:");
	   listaStr.exibir();

	   ListaGenerica<Aluno> listaAluno = new ListaGenerica<>(3);
	   Aluno alu = new Aluno(123,"Luiz"); 
	   Aluno alu2 = new Aluno(345,"Luiza"); 
	   Aluno alu3 = new Aluno(101,"Carla"); 	
	   Aluno alu4 = new Aluno(010,"Carlos"); 
	   
	   listaAluno.adicionar(alu);
	   listaAluno.adicionar(alu2);
           listaAluno.adicionar(alu3);
           listaAluno.adicionar(alu4);

	   listaAluno.exibir();
   }
}
