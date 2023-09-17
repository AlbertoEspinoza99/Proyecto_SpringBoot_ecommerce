package com.mastershop.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mastershop.entity.Cliente;
import com.mastershop.entity.Enlace;
import com.mastershop.entity.Producto;
import com.mastershop.services.ClienteServices;
import com.mastershop.services.ProductoServices;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

	@Autowired
	private ProductoServices serPro;
	
	@Autowired
	private ClienteServices serCli;
	
	
	@RequestMapping("/lista")
	public String lista(Model model,HttpSession session) {
		
		List<Enlace> lista=(List<Enlace>) session.getAttribute("listaEnlaces");
		model.addAttribute("listaEnlaces", lista);
		
		return "Reportes";
		
	}
	
	
	
	@RequestMapping("/Producto")
	public void reporteCliente(HttpServletResponse response) {
		try {
			//invocar al método listarTodos
			List<Producto> lista=serPro.listaProducto();;
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:Reporteproductolista.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping("/Cliente")
	public void reporteClie(HttpServletResponse response) {
		try {
			//invocar al método listarTodos
			List<Cliente> lista=serCli.listaCLiente();
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:ReporteClienteLista.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
}
