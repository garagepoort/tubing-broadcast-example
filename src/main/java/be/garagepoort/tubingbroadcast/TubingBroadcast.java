package be.garagepoort.tubingbroadcast;

import be.garagepoort.mcioc.TubingPlugin;

public class TubingBroadcast extends TubingPlugin {
    @Override
    protected void enable() {
        getLogger().info("TubingBroadcast enabled");
    }

    @Override
    protected void disable() {
        getLogger().info("TubingBroadcast disabled");
    }
}
