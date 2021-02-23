package zwf.tool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @discription: 生成JSP页面标签
 * @Author: 张文峰
 * @Date: 2021-02-23 09:04:55
 */
public class GenerateJsp {
    private final static String path = "E:\\Jsp\\label.txt";
    private final static String excel = "B:\\Save_Excel\\test.xlsx";

    public static void main(String[] args) {
        List<String> list = getLabel();

        int flagCreate = createTxt(path, list);

        if (flagCreate == 0) {
            System.out.println("Create Success!");
            System.out.println("Path: " + path);
        }
    }

    /**
     * 获取表头
     *
     * @param
     * @return : java.util.List<java.lang.String>
     * @Date 21.2.23 - 16:33
     */
    public static List<String> getLabel() {
        List<String> list = new ArrayList<>();
        // 获取工作簿对象
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(excel);
            // 获取工作表
            XSSFSheet sheet = workbook.getSheetAt(0);
            // 获取行
            XSSFRow row = sheet.getRow(1);

            if (row != null) {
                for (Cell cell : row) {
                    String value = cell.getStringCellValue();

                    list.add(value);
                }
            }

            // 获取全部表格数据
            /*for (Row row : sheet) {
                // 获取单元格
                for (Cell cell : row) {
                    String value = cell.getStringCellValue();

                    System.out.println(value);
                }
            }*/

        } catch (IOException e) {
            System.out.println("Table Acquisition Failed!");
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    System.out.println("Resource Closure Failed!");
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 创建文件
     *
     * @param path
     * @return : int
     * @Date 21.2.23 - 16:33
     */
    public static int createTxt(String path, List<String> list) {

        FileWriter fileWritter = null;
        File file = new File(path);

        if (file.exists()) {
            boolean b = file.delete();
            if (b) {
                System.out.println("Delete Success!");
            }
        }

        try {
            boolean flag = file.createNewFile();
            // new FileWriter(file.getName(), true);  追加写
            fileWritter = new FileWriter(path, true);

            for (int i = 0; i < list.size(); i++) {
                fileWritter.write("<hy:gridfield name=\"item" + i + "\" title=\"" + list.get(i) + "\" align=\"center\" width=\"100\"/>");
                fileWritter.write("\r\n");
            }

            fileWritter.write("\r\n");
            fileWritter.write("\r\n");

            for (int i = 0; i < list.size(); i++) {
                fileWritter.write("<hy:gridlink name=\"item" + i + "\" title=\"" + list.get(i) + "\" align=\"center\" width=\"100\" onclick=\"showmj(this," + (i + 1) + ")\" />");
                fileWritter.write("\r\n");
            }


            return 0;
        } catch (IOException e) {

            System.out.println("File Creation Failed!");

            e.printStackTrace();

            return 1;
        } finally {
            if (fileWritter != null) {
                try {
                    fileWritter.close();
                } catch (IOException e) {
                    System.out.println("Resource Closure Failed!");
                    e.printStackTrace();
                }
            }
        }
    }
}
