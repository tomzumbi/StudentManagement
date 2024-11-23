package org.example.DAO;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExportToPDF {
    public boolean exportToPDF() {
        String pdfPath = "diem.pdf";

        try (Connection connection = ConnectionMySql.getConnection()) {
            if (connection != null) {
                String query = "SELECT u.idUser, u.name AS studentName, s.subjectName, e.avgScore FROM Enrollment e JOIN user u ON e.idUser = u.idUser JOIN Subject s ON e.idSubject = s.idSubject ORDER BY u.name, s.subjectName"; // Thay 'your_table' bằng tên bảng thực tế
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                // Tạo file PDF
                PdfWriter writer = new PdfWriter(pdfPath);
                PdfDocument pdfDoc = new PdfDocument(writer);
                Document document = new Document(pdfDoc);

                PdfFont font = PdfFontFactory.createFont("C:\\Users\\nguye\\OneDrive\\Máy tính\\StudentManagement\\src\\main\\java\\org\\example\\font\\SVN-Times New Roman.ttf");

                Table table = new Table(4);
                table.addHeaderCell(new Cell().add(new Paragraph("Mã sinh viên").setFont(font)));
                table.addHeaderCell(new Cell().add(new Paragraph("Tên").setFont(font)));
                table.addHeaderCell(new Cell().add(new Paragraph("Tên học phần").setFont(font)));
                table.addHeaderCell(new Cell().add(new Paragraph("Điểm trung bình").setFont(font)));

                while (resultSet.next()) {
                    String idUser = resultSet.getString("idUser");
                    String name = resultSet.getString("studentName");
                    String subject = resultSet.getString("subjectName");
                    float avgScore = resultSet.getFloat("avgScore");


                    table.addCell(new Cell().add(new Paragraph(idUser).setFont(font)));
                    table.addCell(new Cell().add(new Paragraph(name).setFont(font)));
                    table.addCell(new Cell().add(new Paragraph(subject).setFont(font)));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(avgScore))));
                }

                // Thêm bảng vào tài liệu
                document.add(table);
                document.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
