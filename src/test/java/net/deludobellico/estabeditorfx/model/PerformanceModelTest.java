package net.deludobellico.estabeditorfx.model;

import javafx.collections.FXCollections;
import net.deludobellico.estabeditorfx.data.jaxb.FireType;
import net.deludobellico.estabeditorfx.model.AmmoLoadModel;
import net.deludobellico.estabeditorfx.model.PerformanceModel;
import net.deludobellico.estabeditorfx.model.RangeItemModel;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PerformanceModelTest {

    private final AmmoLoadModel ammoLoad = new AmmoLoadModel();
    private final int minRange = 10;
    private final double slowROF = 2.0;
    private final double normalROF = 3.0;
    private final double rapidROF = 4.0;
    private final int burstRadius = 5;
    private final double shellWeight = 6.0;
    private final List<RangeItemModel> ranges = FXCollections.observableArrayList();
    private final FireType fireType = FireType.AAIR;


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
