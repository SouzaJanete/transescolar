package com.example.transescolar.controller;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ContentDisposition;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;

@Controller
public class DashboardController {

    @PostMapping("/consultar")
    public String consultarCpf(@RequestParam("cpf") String cpf, Model model) {
        model.addAttribute("cpf", cpf);
        return "dashboard"; // Retorna para a página do dashboard
    }

    @GetMapping("/consultar-alunos")
    public String consultarAlunos(Model model) {
        return "alunos"; // Página que exibe a lista de alunos
    }

    @GetMapping("/verificar-pagamentos")
    public String verificarPagamentos(Model model) {
        return "pagamentos"; // Página que exibe o histórico de pagamentos
    }

    @GetMapping("/gerar-relatorios")
    public ResponseEntity<byte[]> gerarRelatorios() {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Relatório");

            // Criar cabeçalhos
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Cliente");
            headerRow.createCell(1).setCellValue("Status");
            headerRow.createCell(2).setCellValue("Pagamento");

            // Criar dados de exemplo
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue("João Silva");
            dataRow.createCell(1).setCellValue("Adimplente");
            dataRow.createCell(2).setCellValue("R$ 300,00");

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename("relatorio.xlsx")
                    .build());

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar o relatório Excel", e);
        }
    }
}
