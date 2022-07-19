package com.example.dataparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ViewActivity extends AppCompatActivity {

    TextView dataDisplayView, parseDataTitle;
    int mode=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        dataDisplayView = (TextView) findViewById(R.id.textViewParseData);
        parseDataTitle = (TextView) findViewById(R.id.textViewTitle);

        mode = getIntent().getIntExtra("mode",0);

        System.out.println("\n\n"+mode);
        if(mode==1)
            ParseXMLDocument();
        else
            ParseJSON();
    }

    private void ParseJSON() {
        parseDataTitle.setText("JSON Data");
        try{
            InputStream inputStream=getAssets().open("city.json");
            byte[] data=new byte[inputStream.available()];
            inputStream.read(data);
            String readData=new String(data);

            JSONObject jsonObject=new JSONObject(readData);
            JSONObject jsonCityDetails=jsonObject.getJSONObject("city");

            dataDisplayView.setText("City Name :"+ jsonCityDetails.getString("name")+"\n");
            dataDisplayView.append("Temperature :"+ jsonCityDetails.getInt("temparature")+"\n");
            dataDisplayView.append("Longitude :"+ jsonCityDetails.getString("logitute")+"\n");
            dataDisplayView.append("Latitude :"+ jsonCityDetails.getString("latitude")+"\n");
            dataDisplayView.append("Humidity :"+ jsonCityDetails.getString("humidity")+"\n");


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private String ParseXMLDocument() {
        parseDataTitle.setText("XML Data");
        try{
            InputStream inputStream = getAssets().open("city.xml");
            DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
            Document doc=dBuilder.parse(inputStream);
            Element element=doc.getDocumentElement();
            element.normalize();
            NodeList nList =doc.getElementsByTagName("city");
            for(int i=0;i<nList.getLength();i++)
            {
                Node node=nList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element2=(Element) node;
                    dataDisplayView.setText("City Name :"+ getValue("name",element2)+"\n");
                    dataDisplayView.append("Temperature :"+ getValue("temparature",element2)+"\n");
                    dataDisplayView.append("Longitude :"+ getValue("longitude",element2)+"\n");
                    dataDisplayView.append("Latitude :"+ getValue("latitude",element2)+"\n");
                    dataDisplayView.append("Humidity :"+ getValue("humidity",element2)+"\n");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList= element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node=nodeList.item(0);
        return node.getNodeValue();
    }

}