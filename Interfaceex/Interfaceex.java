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
qual objeto será guardado dentro das classes*/
interface recipiente {
	void  guardar(String objeto);
	void  retirar(String objeto);
}
class caixa implements recipiente {
	void  guardar(String objeto) {
		
	}
	void  retirar(String objeto) {
		
	}
}
class armario implements recipiente {
	void  guardar(String objeto) {
		
	}
	void  retirar(String objeto) {
		
	}
}
class estante implements recipiente {
	void  guardar(String objeto) {
		
	}
	void  retirar(String objeto) {
		
	}
}
//1.
gato g=new gato();
int vel=40;
g.andar(vel);

//2.
caixa c= new caixa();
c.guardar("livro");
