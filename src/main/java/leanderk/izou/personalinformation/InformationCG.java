package leanderk.izou.personalinformation;

import org.intellimate.izou.events.EventModel;
import org.intellimate.izou.resource.ResourceModel;
import org.intellimate.izou.sdk.Context;
import org.intellimate.izou.sdk.contentgenerator.ContentGenerator;
import org.intellimate.izou.sdk.contentgenerator.EventListener;
import org.intellimate.izou.sdk.events.CommonEvents;
import org.intellimate.izou.sdk.properties.PropertiesAssistant;
import org.intellimate.izou.sdk.resource.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Generates the Personal Information for every Event raised.
 *
 * there should a Properties file containing information like:
 *
 *
 */
public class InformationCG extends ContentGenerator {
    public final static String ID = InformationCG.class.getCanonicalName();
    public final static String RESOURCE_ID = ID + ".ResourceInfo";
    private HashMap<String, String> cache = null;


    private PropertiesAssistant properties;

    public InformationCG(Context context) {
        super(ID, context);
        this.properties = context.getPropertiesAssistant();
    }

    /**
     * returns a HashMap containing the Data about the user.
     *
     * see generate for further Information.
     *
     * @return HashMap
     */
    public HashMap<String, String> getData () {
        synchronized (this) {
            if(cache == null) {
                HashMap<String, String> map = new HashMap<>();
                for (final String name: properties.getProperties().stringPropertyNames())
                    map.put(name, properties.getProperties().getProperty(name));
                cache = map;
            }
            return cache;
        }
    }

    /**
     * returns ContentData with the following format.
     * <p>
     * ContentData is a HashMap,where the keys and values are strings.
     * ALWAYS check for existence of key/value pairs<br>
     * <br>
     * The HashMap should contain:<br>
     * <table summary="">
     *   <tr>
     *      <td>firstname</td><td>the first name of the user</td>
     *   </tr>
     *   <tr>
     *      <td>lastname</td><td>the last name of the user</td>
     *   </tr>
     *   <tr>
     *      <td>email</td><td>the email-adress of the user</td>
     *   </tr>
     *   <tr>
     *      <td>postalcode</td><td>postal-code of the users location</td>
     *   </tr>
     *   <tr>
     *      <td>town</td><td>name of the town of the current location</td>
     *   </tr>
     *   <tr>
     *      <td>street</td><td>the name of the street</td>
     *   </tr>
     *   <tr>
     *      <td>housenumber</td><td>housenumber</td>
     *   </tr>
     *   <tr>
     *      <td>country</td><td>country</td>
     *   </tr>
     * </table>
     *
     * @param list     a list of resources without data
     * @param optional if an event caused the action, it gets passed. It can also be null.
     * @return a list of resources with data
     */
    @Override
    public List<? extends Resource> triggered(List<? extends ResourceModel> list, Optional<EventModel> optional) {
        return optionalToList(createResource(RESOURCE_ID, getData()));
    }

    /**
     * this method returns a List of EventListener, which indicate for which Events the ContentGenerator should be
     * triggered.
     *
     * @return a List of EventListeners
     */
    @Override
    public List<? extends EventListener> getTriggeredEvents() {
        return optionalToList(CommonEvents.Type.responseListener(this));
    }

    /**
     * This method is called to register what resources the object provides.
     * just pass a List of Resources without Data in it.
     *
     * @return a List containing the resources the object provides
     */
    @Override
    public List<? extends Resource> getTriggeredResources() {
        return optionalToList(createResource(RESOURCE_ID));
    }
}
