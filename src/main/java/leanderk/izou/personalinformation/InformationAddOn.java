package leanderk.izou.personalinformation;

import intellimate.izou.activator.Activator;
import intellimate.izou.addon.AddOn;
import intellimate.izou.contentgenerator.ContentGenerator;
import intellimate.izou.events.EventController;
import intellimate.izou.output.OutputExtension;
import intellimate.izou.output.OutputPlugin;

import java.util.Properties;

/**
 * The AddOn class for the Personal-Information AddOn
 */
public class InformationAddOn extends AddOn{

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
        //TODO: shit
        InformationCG informationCG = new InformationCG(new Properties());
        ContentGenerator[] contentGenerators = new ContentGenerator[1];
        contentGenerators[3] = informationCG;
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
}
