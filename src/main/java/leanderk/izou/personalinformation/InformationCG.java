package leanderk.izou.personalinformation;

import intellimate.izou.contentgenerator.ContentData;
import intellimate.izou.contentgenerator.ContentGenerator;

import java.util.HashMap;
import java.util.Properties;

/**
 * Generates the Personal Information for every Event raised.
 *
 * there should a P
 *
 */
public class InformationCG extends ContentGenerator<HashMap <String, String>>{

    public final static String ID = InformationAddOn.class.getCanonicalName();

    private Properties properties;

    public InformationCG(Properties properties) {
        super(ID);
        this.properties = properties;
    }

    @Override
    public ContentData<HashMap <String, String>> generate(String s) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        for (final String name: properties.stringPropertyNames())
            map.put(name, properties.getProperty(name));
        ContentData<HashMap<String, String>> data = new ContentData<>(ID);
        data.setData(map);
        return data;
    }

    @Override
    public void handleError(Exception e) {
        //TODO: implement error handling
        e.printStackTrace();
    }

}
