package ssf.ssfassessment.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import ssf.ssfassessment.model.Order;

@Component("calculate")
public class CalculateOrder {

    public void saveContact(Order o, Model model, ApplicationArguments appArgs, String defaultDataDir) {
        String dataFilename = o.getId();
        PrintWriter prntWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(getDataDir(appArgs, defaultDataDir) + "/" + dataFilename);
            prntWriter = new PrintWriter(fileWriter);
            prntWriter.println(o.getType());
            prntWriter.println(o.getSize());
            prntWriter.println(o.getQuantity());
            prntWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("order", new Order(o.getId(), o.getType(),
                o.getSize(), o.getQuantity()));
    }

    private String getDataDir(ApplicationArguments appArgs, String defaultDataDir) {
        String dataDirResult = "";
        List<String> optValues = null;
        String[] optValuesArr = null;
        Set<String> opsNames = appArgs.getOptionNames();
        String[] optNamesArr = opsNames.toArray(new String[opsNames.size()]);
        if (optNamesArr.length > 0) {
            optValues = appArgs.getOptionValues(optNamesArr[0]);
            optValuesArr = optValues.toArray(new String[optValues.size()]);
            dataDirResult = optValuesArr[0];
        } else {
            dataDirResult = defaultDataDir;
        }

        return dataDirResult;
    }

}
