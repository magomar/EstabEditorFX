package net.deludobellico.commandops.test.model;

import javafx.collections.FXCollections;
import net.deludobellico.commandops.estabeditor.data.jaxb.FireType;
import net.deludobellico.commandops.estabeditor.model.AmmoLoadModel;
import net.deludobellico.commandops.estabeditor.model.PerformanceModel;
import net.deludobellico.commandops.estabeditor.model.RangeItemModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PerformanceModelTest {

    AmmoLoadModel ammoLoad = new AmmoLoadModel();
    int minRange = 10;
    double slowROF = 2.0;
    double normalROF = 3.0;
    double rapidROF = 4.0;
    int burstRadius = 5;
    double shellWeight = 6.0;
    List<RangeItemModel> ranges = FXCollections.observableArrayList();
    FireType fireType = FireType.AAIR;


    @Test
    public void testEquals() throws Exception {
        PerformanceModel ours = new PerformanceModel();
        ours.setAmmoLoad(ammoLoad);
        ours.setMinRange(minRange);
        ours.setSlowROF(slowROF);
        ours.setNormalROF(normalROF);
        ours.setRapidROF(rapidROF);
        ours.setBurstRadius(burstRadius);
        ours.setShellWeight(shellWeight);
        ours.setShellWeight(shellWeight);
        ours.setFireType(fireType);
        ranges.clear();
        ranges.add(new RangeItemModel());
        ours.getRanges().addAll(ranges);

        PerformanceModel other = new PerformanceModel();
        other.setAmmoLoad(ammoLoad);
        other.setMinRange(minRange);
        other.setSlowROF(slowROF);
        other.setNormalROF(normalROF);
        other.setRapidROF(rapidROF);
        other.setBurstRadius(burstRadius);
        other.setShellWeight(shellWeight);
        other.setShellWeight(shellWeight);
        other.setFireType(fireType);
        ranges.clear();
        ranges.add(new RangeItemModel());
        other.getRanges().addAll(ranges);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCode() throws Exception {
        PerformanceModel ours = new PerformanceModel();
        ours.setAmmoLoad(ammoLoad);
        ours.setMinRange(minRange);
        ours.setSlowROF(slowROF);
        ours.setNormalROF(normalROF);
        ours.setRapidROF(rapidROF);
        ours.setBurstRadius(burstRadius);
        ours.setShellWeight(shellWeight);
        ours.setShellWeight(shellWeight);
        ours.setFireType(fireType);
        ranges.clear();
        ranges.add(new RangeItemModel());
        ours.getRanges().addAll(ranges);

        PerformanceModel other = new PerformanceModel();
        other.setAmmoLoad(ammoLoad);
        other.setMinRange(minRange);
        other.setSlowROF(slowROF);
        other.setNormalROF(normalROF);
        other.setRapidROF(rapidROF);
        other.setBurstRadius(burstRadius);
        other.setShellWeight(shellWeight);
        other.setShellWeight(shellWeight);
        other.setFireType(fireType);
        ranges.clear();
        ranges.add(new RangeItemModel());
        other.getRanges().addAll(ranges);
        assertEquals(ours.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsNullableFieldsAreNull() throws Exception {
        PerformanceModel ours = new PerformanceModel();
        ours.setAmmoLoad(null);
        ours.setMinRange(minRange);
        ours.setSlowROF(slowROF);
        ours.setNormalROF(normalROF);
        ours.setRapidROF(rapidROF);
        ours.setBurstRadius(burstRadius);
        ours.setShellWeight(shellWeight);
        ours.setShellWeight(shellWeight);
        ours.setFireType(null);
        ranges.clear();
        ranges.add(new RangeItemModel());
        ours.getRanges().addAll(ranges);

        PerformanceModel other = new PerformanceModel();
        other.setAmmoLoad(null);
        other.setMinRange(minRange);
        other.setSlowROF(slowROF);
        other.setNormalROF(normalROF);
        other.setRapidROF(rapidROF);
        other.setBurstRadius(burstRadius);
        other.setShellWeight(shellWeight);
        other.setShellWeight(shellWeight);
        other.setFireType(null);
        ranges.clear();
        ranges.add(new RangeItemModel());
        other.getRanges().addAll(ranges);
        assertEquals(true, ours.equals(other));
    }

    @Test
    public void testHashCodeNullableFieldsAreNull() throws Exception {
        PerformanceModel ours = new PerformanceModel();
        ours.setAmmoLoad(null);
        ours.setMinRange(minRange);
        ours.setSlowROF(slowROF);
        ours.setNormalROF(normalROF);
        ours.setRapidROF(rapidROF);
        ours.setBurstRadius(burstRadius);
        ours.setShellWeight(shellWeight);
        ours.setShellWeight(shellWeight);
        ours.setFireType(null);
        ranges.clear();
        ranges.add(new RangeItemModel());
        ours.getRanges().addAll(ranges);

        PerformanceModel other = new PerformanceModel();
        other.setAmmoLoad(null);
        other.setMinRange(minRange);
        other.setSlowROF(slowROF);
        other.setNormalROF(normalROF);
        other.setRapidROF(rapidROF);
        other.setBurstRadius(burstRadius);
        other.setShellWeight(shellWeight);
        other.setShellWeight(shellWeight);
        other.setFireType(null);
        ranges.clear();
        ranges.add(new RangeItemModel());
        other.getRanges().addAll(ranges);
        assertEquals(ours.hashCode(), other.hashCode());
    }
}
