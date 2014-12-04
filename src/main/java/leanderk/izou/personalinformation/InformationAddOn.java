package leanderk.izou.personalinformation;

import intellimate.izou.activator.Activator;
import intellimate.izou.addon.AddOn;
import intellimate.izou.contentgenerator.ContentGenerator;
import intellimate.izou.events.EventsController;
import intellimate.izou.output.OutputExtension;
import intellimate.izou.output.OutputPlugin;
import ro.fortsoft.pf4j.Extension;

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
        InformationCG informationCG = new InformationCG(getPropertiesContainer(), getContext());
        ContentGenerator[] contentGenerators = new ContentGenerator[1];
        contentGenerators[0] = informationCG;
        return contentGenerators;
    }

    @Override
    public EventsController[] registerEventController() {
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

    @Override
    public String getID() {
        return ID;
    }
}
