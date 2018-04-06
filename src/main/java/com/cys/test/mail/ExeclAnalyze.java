package com.cys.test.mail;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExeclAnalyze {
    /**
     * 读取execl,判断是否为xls或xlsx文件。
     * @param filePath  文件路径，如果文件不合法，抛出异常
     * @return  返回一个WorkBook对象
     * @throws IOException 如果加载失败，抛出异常。
     */
    private Workbook loadExeclFile(String filePath) throws IOException {
        InputStream in = new FileInputStream(new File(filePath));
        Workbook wb = null;
        if (filePath.matches(".*\\.xls")) {
            wb = new HSSFWorkbook(in);
        } else if (filePath.matches(".*\\.xlsx")) {
            wb = new XSSFWorkbook(in);
        } else {
            throw new IllegalArgumentException("输入的文件路径[" + filePath + "]不合法，请检查是否为execl！");
        }
        return wb;
    }

    /**
     * 解析标题行
     * @param workbook  execl对象
     * @return  返回标题数组
     */
    private String[] readExeclTitles(Workbook workbook){
        if (workbook == null) {
            throw new IllegalArgumentException("execl对象无效，读取标题出错");
        }
        Sheet firstSheet = workbook.getSheetAt(0);
        Row titleRow = firstSheet.getRow(0);
        int titleNumber = titleRow.getPhysicalNumberOfCells();
        String [] titleArray= new String[titleNumber];
        for (int i = 0; i < titleNumber; i++) {
            titleArray[i] = titleRow.getCell(i).toString();
        }
        return titleArray;
    }

    private List<List<String>> readBody(Workbook workbook, int titleLength){
        if (workbook == null) {
            throw new IllegalArgumentException("execl对象无效，读取内容出错");
        }
        List<List<String>> body = new ArrayList<>();
        Sheet firstSheet = workbook.getSheetAt(0);
        int lastRowNum = firstSheet.getLastRowNum();
        for (int i = 1; i < lastRowNum ; i++) {
            Row row = firstSheet.getRow(i);
            ArrayList<String> rowList = new ArrayList<>();
            for (int j = 0; j < titleLength; j++) {
                Cell cell = row.getCell(j);
                String value = "";
                if (null != cell) {
                    value = cell.toString();
                }
                rowList.add(value);
            }
            body.add(rowList);
        }
        return body;
    }

    public void test(){
        try {
            Workbook workbook = loadExeclFile("X:\\test\\execl.xlsx");
            String[] strings = readExeclTitles(workbook);
            List<List<String>> lists = readBody(workbook, strings.length);
            System.out.println(Arrays.toString(strings));
            System.out.println(lists.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ExeclAnalyze execlAnalyze = new ExeclAnalyze();
        execlAnalyze.test();
//        System.out.println("X:\\test\\execl.xlsx".matches(".*\\.xlsx"));
//        Pattern p = Pattern.compile("\\.xlsx");
//        System.out.println(p.matcher("X:\\test\\execl.xlsx").find());
    }
}
