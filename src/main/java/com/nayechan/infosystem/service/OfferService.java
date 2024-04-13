package com.nayechan.infosystem.service;

import com.nayechan.infosystem.dao.OfferDao;
import com.nayechan.infosystem.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    //service -> dao
    @Autowired
    private OfferDao offerDao;

    public List<Offer> getAllOffers() {
        return offerDao.getOffers();
    }

    public void insert(Offer offer) {
        offerDao.insert(offer);
    }
}
