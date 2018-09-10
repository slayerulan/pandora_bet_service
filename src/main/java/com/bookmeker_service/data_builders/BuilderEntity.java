package com.bookmeker_service.data_builders;

import com.bookmeker_service.beans.EventGeneral;
import com.bookmeker_service.beans.LeagueGeneral;
import com.bookmeker_service.beans.SportGeneral;

public class BuilderEntity {

    public SportGeneral getSportGeneral(int id, String name, String urlName, String json) {
        return new SportGeneral(id, name, urlName, json);
    }

    public EventGeneral getEventGeneral(int id, String name, String urlName, String json) {
        return new EventGeneral(id, name, urlName, json);
    }

    public LeagueGeneral getLeagueGeneral(int id, String name, String nameUrl, String json) {
        return new LeagueGeneral(id, name, nameUrl, json);
    }
}