package com.bookmeker_service.data_builders;

import com.bookmeker_service.interfaces.IDataBuilder;

public class FactoryBuilder {

    public IDataBuilder getDataBuilder(String bookmeker) {
        IDataBuilder builder = null;
        switch(bookmeker) {
            case "Matchbook" : {builder = new MatchbookBuilder(); break;}
            case "1XBet" : {builder = new IXBetBuilder(); break;}
        }
        return builder;
    }
}