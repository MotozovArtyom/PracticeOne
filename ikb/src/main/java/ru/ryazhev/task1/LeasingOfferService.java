package ru.ryazhev.task1;

import ru.ryazhev.task3.StatCounter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class LeasingOfferService implements OfferService{
    @Override
    public Offer signNewOffer(LocalDateTime startDate,
                              LocalDateTime endingDate,
                              Client client,
                              Stuff stuff) {
        Offer offer = null;
        String number = Integer.toString(
                startDate.getNano()) +
                Integer.toString(endingDate.getNano()) +
                Integer.parseInt(startDate.getMonth().toString()) +
                Integer.toString(endingDate.getDayOfMonth());
        offer = new Offer(UUID.randomUUID(), number, LocalDateTime.now(), endingDate, startDate,
                office, client, stuff);

        StatCounter.getInstance().addOffer(offer);
        return offer;

    }
    private static LeasingOfferService instance;
    private final Office office = new Office(UUID.fromString("0590954c-499b-11ed-b878-0242ac120002"),
            "9425 Vince Groves",
            "Suite 130, 94073-7811, Port Gabrielmouth, New York, United States",
            10);
    private LeasingOfferService() {
    }
    public static LeasingOfferService getInstance(){
        if(instance == null){
            instance = new LeasingOfferService();
        }
        return instance;
    }
}