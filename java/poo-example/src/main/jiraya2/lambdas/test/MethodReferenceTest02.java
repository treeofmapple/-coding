package lambdas.test;

import java.util.ArrayList;
import java.util.List;

import lambdas.dominio.Anime;
import lambdas.service.AnimeComparators;

//Reference to an instance method of a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("One piece", 900), new Anime("Naruto", 500)));
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        animeList.sort((a1,a2) -> animeComparators.compareByEpisodesNonStatic(a1,a2));
        System.out.println(animeList);
    }
}
