package com.nichesoftware.gcm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by n_che on 15/04/2016.
 */
public class GcmModel {
    private List<String> registrationIds;
    private Map<String, String> data;

    /**
     * Constructeur privé
     */
    private GcmModel() {
        // Nothing
    }

    /** Holder */
    private static class SingletonHolder {
        /**
         * Instance unique non préinitialisée
         */
        private final static GcmModel INSTANCE = new GcmModel();
    }

    /**
     * Point d'accès pour l'instance unique du singleton
     */
    public static GcmModel getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public void addRegistrationId(final String id) {
        if (registrationIds == null) {
            registrationIds = new LinkedList<String>();
        }

        if (!registrationIds.contains(id)) {
            registrationIds.add(id);
        }

        // FIXME: Supprimer logs dégueulasses
        System.out.print("|");
        for (String registrationId : registrationIds) {
            System.out.print(" " + registrationId + " |");
        }
    }

    public void createData(final String title, final String message) {
        if (data == null) {
            data = new HashMap<String, String>();
        }
        data.put(GcmConstants.TITLE, title);
        data.put(GcmConstants.MESSAGE, message);
    }

    public Map<String, String> getData() {
        return data;
    }
    public void setData(Map<String, String> data) {
        this.data = data;
    }
    public List<String> getRegistrationIds() {
        return registrationIds;
    }
    public void setRegistrationIds(List<String> registrationIds) {
        this.registrationIds = registrationIds;
    }
}
