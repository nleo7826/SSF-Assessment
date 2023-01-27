// package ssf.ssfassessment.util;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.List;
// import java.util.Set;

// import org.springframework.boot.ApplicationArguments;
// import org.springframework.stereotype.Component;
// import org.springframework.ui.Model;

// import ssf.ssfassessment.model.Order;

// @Component("calculate")
// public class CalculateOrder {

//     private String getDataDir(ApplicationArguments appArgs, String defaultDataDir) {
//         String dataDirResult = "";
//         List<String> optValues = null;
//         String[] optValuesArr = null;
//         Set<String> opsNames = appArgs.getOptionNames();
//         String[] optNamesArr = opsNames.toArray(new String[opsNames.size()]);
//         if (optNamesArr.length > 0) {
//             optValues = appArgs.getOptionValues(optNamesArr[0]);
//             optValuesArr = optValues.toArray(new String[optValues.size()]);
//             dataDirResult = optValuesArr[0];
//         } else {
//             dataDirResult = defaultDataDir;
//         }

//         return dataDirResult;
//     }

// }
