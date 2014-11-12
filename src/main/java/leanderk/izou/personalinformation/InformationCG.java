package leanderk.izou.personalinformation;

import intellimate.izou.addon.PropertiesContainer;
import intellimate.izou.contentgenerator.ContentData;
import intellimate.izou.contentgenerator.ContentGenerator;

import java.util.HashMap;
import java.util.Properties;

/**
 * Generates the Personal Information for every Event raised.
 *
 * there should a Properties file containing information like:
 *
 *
 */
public class InformationCG extends ContentGenerator<HashMap <String, String>>{

    public final static String ID = InformationAddOn.class.getCanonicalName();
    private HashMap<String, String> cache = null;


    private PropertiesContainer properties;

    public InformationCG(PropertiesContainer properties) {
        super(ID);
        this.properties = properties;
    }

    /**
     * returns ContentData with the following format.
     *
     * ContentData is a HashMap,where the keys and values are strings.
     * ALWAYS check for existence of key/value pairs
     *
     * #basic data:
     *
     * #first name of the user:
     * firstname
     * #last name of the user:
     * lastname
     *
     *
     * #email
     * email
     *
     *
     * #location data
     *
     * #postal code
     * postalcode
     * #town
     * town
     * #street
     * street
     * #housenumer
     * housenumber
     *
     * @param id id the event causing the generate
     * @return ContentData containing information about the user
     * @throws Exception
     */
    @Override
    public ContentData<HashMap <String, String>> generate(String id) throws Exception {
        HashMap<String, String> temp = getData();
        ContentData<HashMap<String, String>> data = new ContentData<>(ID);
        data.setData(temp);
        return data;
    }

    @Override
    public void handleError(Exception e) {
        //TODO: implement error handling
        e.printStackTrace();
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

}
