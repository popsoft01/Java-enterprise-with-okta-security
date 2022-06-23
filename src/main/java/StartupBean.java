import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.stream.Stream;

@Singleton
public class StartupBean {
    private final BeerService beerService;

    @Inject
    public StartupBean(BeerService beerService){
        this.beerService = beerService;
    }

    @PostConstruct
    private void startup(){
        Stream.of("Kentucky Brunch Brand Stout", "Marshmallow Handjee",
                "Barrel-Aged Abraxas", "Heady Topper",
                "Budweiser", "Coors Light", "PBR").forEach(name ->
                beerService.addBeer(new Beer(name))
        );
        beerService.getAllBeer().forEach(System.out::println);
    }
    @PreDestroy
    private void shutDown(){
        beerService.clear();
    }

}
