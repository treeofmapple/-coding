package hashsetss;

import java.util.LinkedHashSet;
import java.util.Set;

public class Mairn {

	public static void main(String[] args) {
		
		Set <Manga> mangas = new LinkedHashSet<>();
		
		mangas.add(new Manga(1,"Holy", 10.4, 2));
		mangas.add(new Manga(2,"Abc", 12.4, 5));
		mangas.add(new Manga(3,"Dco", 19.4, 7));
		mangas.add(new Manga(4,"IBR", 2.4, 4));

		int a = 1;
		for(Manga manga: mangas) {
			System.out.println(a +" : "+ manga);
			a++;
		}
	}
	

	
	
}

