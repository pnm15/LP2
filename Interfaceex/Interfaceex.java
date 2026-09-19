/*1.o metodo andar() e correr() representam  
ações de movimento que podem ser realizadas, e
o parametro vel vai regular a velocidade de movimento*/
interface movimento {
	void andar(int vel);
	void correr(int vel);
}
class gato implements movimento {
	void andar(int vel) {
		
	}
	void correr(int vel) {
	
	}
}
class cachorro implements movimento {
	void andar(int vel) {
		
	}
	void correr(int vel) {
	
	}
}
class cavalo implements movimento {
	void andar(int vel) {
		
	}
	void correr(int vel) {
	
	}
}


/*2.o metodo guardar e retirar representam  
ações de recipiente que podem ser realizadas, e
o parametro objeto vai definir a partir de uma string,
o que será guardado dentro das classes*/
interface recipiente {
	int guardar(String objeto);
	int retirar(String objeto);
}
class caixa implements recipiente {
	int guardar(String objeto) {
		return 0;
	}
	int retirar(String objeto) {
		return 0;
	}
}
class armario implements recipiente {
	int guardar(String objeto) {
		return 0;
	}
	int retirar(String objeto) {
		return 0;
	}
}
class estante implements recipiente {
	int guardar(String objeto) {
		return 0;
	}
	int retirar(String objeto) {
		return 0;
	}
}
//1.
gato g=new gato();
int vel=40;
g.andar(vel);

//2.
caixa c= new caixa();
c.guardar("livro");
