package com.flipkart.business.interfaces;

import com.flipkart.model.FlipFitSlots;

import java.util.List;

public interface IFlipFitGymCentre {
    public void createGymCentre();
    public boolean updateGymCentre();
    public boolean deleteGymCentre(int centreId);
    public List<FlipFitSlots> viewAvailableSlots(int centreId);
}
