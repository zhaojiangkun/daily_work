package excel;

import com.alibaba.fastjson.JSON;
import excel.read.ExcelReader;
import excel.vo.EntityVO;
import excel.vo.ExcelDataVO;
import excel.write.ExcelWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author: PingQiu
 * @date: 2023/8/26 15:20
 */
public class ExcelTest {


    public static void main(String[] args) {
        String path = "/Users/zjk/Desktop/2023.xlsx";
        List<EntityVO> excelDataVOS = ExcelReader.readExcel(path);
        System.out.println(JSON.toJSONString(excelDataVOS));
    }

    @Test
    public void insert(){
        String path = "/Users/zjk/Desktop/2023.xlsx";
        List<EntityVO> excelDataVOS = ExcelReader.readExcel(path);
        Workbook workbook = ExcelWriter.exportData(excelDataVOS);

        // 以文件的形式输出工作簿对象
        FileOutputStream fileOut = null;
        try {
            String exportFilePath = "/Users/zjk/Desktop/2023out.xlsx";
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {

        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
