package org.bloom.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bloom.plugin.event.BloomPluginHandler;

/**
 * Represents a Bloom plugin
 */
public abstract class Plugin {
    private String name;
    private String version;
    private Thread thread;

    // public MyPlugin(Thread thread)
    // super("ExamplePlugin", "1.0", thread)
    public Plugin(String name, String version, Thread thread){
        this.name = name;
        this.version = version;
        this.thread = thread;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Logger getLogger(){
        return LogManager.getLogger(getName());
    }

    public void onEnable(BloomPluginHandler handler){}

    public void onDisable(){}

    public boolean isRunning(){
        return thread.isAlive();
    }

    public void disablePlugin(){
        onDisable();
        thread.stop();
        JavaPluginLoader.nameToPlugin.remove(getName());
    }

    public void startPlugin(){
        if(isRunning()){
            disablePlugin();
        }
        thread.start();
        onEnable(new BloomPluginHandler(this));
        JavaPluginLoader.nameToPlugin.put(getName(), this);
    }
}
