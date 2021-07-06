package tf.ssf.sfort.defresource;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class Config implements ModInitializer{
    public static Logger LOGGER = LogManager.getLogger();

    public static List<String> paks;

    @Override
    public void onInitialize() {
        File confFile = new File(
                FabricLoader.getInstance().getConfigDir().toString(),
                "DefaultResources.conf"
        );
        try {
            confFile.createNewFile();
            paks = Files.readAllLines(confFile.toPath());
            LOGGER.log(Level.INFO,"tf.ssf.sfort.defresource successfully loaded config file");
        } catch(Exception e) {
            LOGGER.log(Level.ERROR,"tf.ssf.sfort.defresource failed to load config file, using defaults\n"+e);
        }
    }
}