package hashsetss;

import java.util.Objects;

public class Manga {
	int id;
	String nome;
	double preco;
	int quantidade;
	
	public Manga(int id, String nome, double preco) {
		Objects.requireNonNull(id, "Can't be null");
		Objects.requireNonNull(nome, "Can't be null");
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
    public Manga(int id, String nome, double preco, int quantidade) {
        this(id, nome, preco);
        this.quantidade = quantidade;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Manga manga = (Manga) o;
		return id == manga.id && Objects.equals(nome, manga.nome);
	}

	@Override
    public String toString() {
        return "Manga:{ id = " + id + ", nome = " + nome + ", preço = "
                + preco + ", quantidade = " + quantidade + " }";
    }
	
}
