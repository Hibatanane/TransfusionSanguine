package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Analyse;
import iga.TransfusionSanguine.Repositories.AnalyseRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Donneur")
public class AnalyseController {
    @Autowired
    private AnalyseRepository analyseRepository;

    @GetMapping("/analyses/{idDon}")
    public String visualiserAnalyse(Model model, @PathVariable("idDon") long idDon) {
        System.out.println("id du don : " + idDon);
        return "Donneur/don";
    }


}