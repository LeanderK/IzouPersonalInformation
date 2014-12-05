package leanderk.izou.personalinformation;

import intellimate.izou.addon.PropertiesContainer;
import intellimate.izou.contentgenerator.ContentGenerator;
import intellimate.izou.events.Event;
import intellimate.izou.resource.Resource;
import intellimate.izou.system.Context;
import intellimate.izou.system.Identification;
import intellimate.izou.system.IdentificationManager;

import java.util.Arrays;
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
public class InformationCG extends ContentGenerator{
    public final static String ID = InformationAddOn.class.getCanonicalName();
    public final static String RESOURCE_ID = ID + ".ResourceInfo";
    private HashMap<String, String> cache = null;
    private IdentificationManager identificationManager = IdentificationManager.getInstance();


    private PropertiesContainer properties;

    public InformationCG(PropertiesContainer properties, Context context) {
        super(ID, context);
        this.properties = properties;
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

    @Override
    public List<Resource> announceResources() {
        Optional<Identification> identification = identificationManager.getIdentification(this);
        Resource<String> resource = new Resource<>(RESOURCE_ID);
        identification.ifPresent(resource::setProvider);
        return Arrays.asList(resource);
    }

    @Override
    public List<String> announceEvents() {
        return Arrays.asList(Event.RESPONSE);
    }

    /**
     * returns ContentData with the following format.
     * <p>
     * ContentData is a HashMap,where the keys and values are strings.
     * ALWAYS check for existence of key/value pairs<br>
     * <br>
     * The HashMap should contain:<br>
     * <code>
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
     * </code>
     * </p>
     * @param list the resources to generate
     * @param optional the event which may caused the generation
     * @return ContentData containing information about the user
     */
    @Override
    public List<Resource> provideResource(List<Resource> list, Optional<Event> optional) {
        Optional<Identification> identification = identificationManager.getIdentification(this);
        Resource<HashMap <String, String>> resource = new Resource<>(RESOURCE_ID);
        identification.ifPresent(resource::setProvider);
        resource.setResource(getData());
        return Arrays.asList(resource);
    }
}
