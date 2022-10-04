package pages;


import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.Rows;
import com.deepoove.poi.data.Tables;
import com.deepoove.poi.data.style.BorderStyle;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.Row;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class BasePage {
    protected static String stepNumber;
    protected static String stepDescription;
    protected static String screenShot;
    protected static String result;
    protected static String title;
    protected static Map<String, RowRenderData> rows;
    protected static RowRenderData row;
    protected static RowRenderData[] rowRenderData;
    protected static HashMap rowsReport;


    static {
        Logger logger = LoggerFactory.getLogger(XWPFTemplate.class);
        rows = new TreeMap<String, RowRenderData>();
        rowsReport = new HashMap<String, Object>();
        rowRenderData = new RowRenderData[]{Rows.of("Imagen  1 ", "Imagen 2").create(),Rows.of("Envío una solicitud GET hacia el URI", "Obtengo un código de respuesta de servicio ok").create(), Rows.of("lol","lol").create()};


    }



    public static void stepReport(RowRenderData... row) throws IOException {

        XWPFTemplate template = XWPFTemplate.compile("src/main/resources/templateDoc/template.docx").render(

                new HashMap<String, Object>() {{
                    /*put(tag, renderTag);
                    put("table0", Tables.of(new String[][]{
                            new String[]{"00", "01"},
                            new String[]{"10", "11"}
                    }).border(BorderStyle.DEFAULT).create());
                    */



                    put("Pasos", Tables.create(rowRenderData));
                    //put("table1", Tables.create(row));
                }});


        template.writeAndClose(new FileOutputStream("src/main/resources/outPutDoc/output.docx"));


    }



}
