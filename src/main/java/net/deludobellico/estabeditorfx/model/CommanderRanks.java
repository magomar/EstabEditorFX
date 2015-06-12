package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.List;

/**
 * Created by Mario on 30/04/2015.
 */
public class CommanderRanks {
    private final ObservableMap<ServiceModel, ObservableList<RankModel>> SERVICE_RANKS = FXCollections.observableHashMap();

    public CommanderRanks(EstabModel estab) {
        for (ServiceModel service : estab.getServices().values()) {
            int i = 0;
            for (RankModel rankModel : service.getRankList()) {
                rankModel.setIndex(i);
                i++;
            }
            SERVICE_RANKS.put(service, service.getRankList());
        }
    }

    public ObservableList<RankModel> getServiceRankList(ServiceModel service) {
        return SERVICE_RANKS.get(service);
    }
}
