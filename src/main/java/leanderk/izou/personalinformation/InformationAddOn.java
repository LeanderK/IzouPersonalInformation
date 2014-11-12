package leanderk.izou.personalinformation;

import intellimate.izou.activator.Activator;
import intellimate.izou.addon.AddOn;
import intellimate.izou.contentgenerator.ContentGenerator;
import intellimate.izou.events.EventController;
import intellimate.izou.output.OutputExtension;
import intellimate.izou.output.OutputPlugin;
import ro.fortsoft.pf4j.Extension;

import java.nio.file.Path;

/**
 * The AddOn class for the Personal-Information AddOn
 */
@Extension
public class InformationAddOn extends AddOn {

    public final static String ID = InformationAddOn.class.getCanonicalName();

    public InformationAddOn() {
        super(ID);
    }

    @Override
    public void prepare() {

    }

    @Override
    public Activator[] registerActivator() {
        return null;
    }

    @Override
    public ContentGenerator[] registerContentGenerator() {
        InformationCG informationCG = new InformationCG(getPropertiesContainer());
        ContentGenerator[] contentGenerators = new ContentGenerator[1];
        contentGenerators[0] = informationCG;
        return contentGenerators;
    }

    @Override
    public EventController[] registerEventController() {
        return null;
    }

    @Override
    public OutputPlugin[] registerOutputPlugin() {
        return null;
    }

    @Override
    public OutputExtension[] registerOutputExtension() {
        return null;
    }

    /**
     * use this method to register a property file (if you have one) so that Izou reloads it when you update it manually
     *
     * @return the path to the properties file
     */
    @Override
    public Path registerPropertiesFile() {
        return null;
    }
}
