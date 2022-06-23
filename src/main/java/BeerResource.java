import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class BeerResource {
    private final BeerService beerService;

    @Inject
    public BeerResource(BeerService beerService) {
        this.beerService =  beerService;
    }

    @GET
    @Produces({APPLICATION_JSON})
    public List<Beer> getGoodBeers(){
        return beerService.getAllBeer().stream()
                .filter(this::isGreat).collect(Collectors.toList());
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }
}
