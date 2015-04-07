package leanderk.izou.personalinformation;

import org.intellimate.izou.sdk.activator.Activator;
import org.intellimate.izou.sdk.addon.AddOn;
import org.intellimate.izou.sdk.contentgenerator.ContentGenerator;
import org.intellimate.izou.sdk.events.EventsController;
import org.intellimate.izou.sdk.output.OutputExtension;
import org.intellimate.izou.sdk.output.OutputPlugin;
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
        InformationCG informationCG = new InformationCG(getContext());
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
}
