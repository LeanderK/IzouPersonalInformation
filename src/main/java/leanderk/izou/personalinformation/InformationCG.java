package leanderk.izou.personalinformation;

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
    HashMap<String, String> cache = null;


    private Properties properties;

    public InformationCG(Properties properties) {
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
        if(cache == null) {
            HashMap<String, String> map = new HashMap<>();
            for (final String name: properties.stringPropertyNames())
                map.put(name, properties.getProperty(name));
            cache = map;
        }
        ContentData<HashMap<String, String>> data = new ContentData<>(ID);
        data.setData(cache);
        return data;
    }

    @Override
    public void handleError(Exception e) {
        //TODO: implement error handling
        e.printStackTrace();
    }

}
