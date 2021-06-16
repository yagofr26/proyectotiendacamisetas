package com.backend.yago.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.backend.yago.modelo.CamisetaVO;
import com.backend.yago.modelo.UsuarioRolVO;
import com.backend.yago.modelo.UsuarioVO;
import com.backend.yago.repositorio.CamisetaDAO;

import com.backend.yago.servicio.ServicioCamiseta;
import com.backend.yago.servicio.ServicioRol;
import com.backend.yago.servicio.ServicioUsuario;
import com.backend.yago.servicio.ServicioUsuarioRol;

@Controller
public class CamisetaController {
	@Autowired
	ServicioCamiseta sc;
	@Autowired
	ServicioUsuario su;
	@Autowired
	ServicioUsuarioRol sur;
	@Autowired
	ServicioRol sr;
    @Autowired
    CamisetaDAO cd;
	
	@GetMapping("/admin")
	public String allCamisetas(Model modelo) {
		modelo.addAttribute("camisetas", cd.findAll());
		return "camisetas/admin";
	}
	

	@GetMapping("/index")
	public String Camisetas(Model modelo) {
		modelo.addAttribute("camisetas", cd.findAll());
		return "camisetas/index";
	}
	

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	@GetMapping("/403")
	public String p403() {
		return "403";
	}
	
	@GetMapping("/home")
	public String home() {
		return "camisetas/home";
	}
	
	@GetMapping("/insertar")
	public String insertar(Model modelo) {
		modelo.addAttribute("camisetas", new CamisetaVO());
		return "camisetas/insertar";
	}
	/*@PostMapping("/submit")
	public String submit(@ModelAttribute CamisetaVO camiseta, Model modelo) {
		sc.save(camiseta);
		modelo.addAttribute("camisetas", sc.findAll());
		return "camisetas/admin";
	}*/
	
	@GetMapping("/registrarse")
    public String registrarse(Model modelo) {
        modelo.addAttribute("usuario", new UsuarioVO());
        return "registro";
    }
    
    @PostMapping("/registro")
    public String registro(@ModelAttribute UsuarioVO usuario,Model modelo) {
        BCryptPasswordEncoder encriptador=new BCryptPasswordEncoder();
        String contraseña = encriptador.encode(usuario.getPassword());
        usuario.setPassword(contraseña);
        su.save(usuario);
        sur.save(new UsuarioRolVO(0,usuario,sr.findById(2).get()));
        return "camisetas/home";
    }
    
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam int idcamiseta, Model modelo) {
		sc.deleteById(idcamiseta);
		modelo.addAttribute("camisetas", sc.findAll());
		return "camisetas/admin";
	}
	
	@GetMapping("/modificar")
	public String mofificar(@RequestParam int idcamiseta, Model modelo) {
		modelo.addAttribute("camisetas", sc.findById(idcamiseta).get());
		return "camisetas/modificar";
	}
	
	@GetMapping("/acercade")
	public String acercade() {
		return "camisetas/acercade";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "camisetas/contacto";
	}

	@GetMapping("/productos")
	public String productos() {
		return "camisetas/productos";
	}
	
	@GetMapping("/acercadeadmin")
	public String acercadeadmin() {
		return "camisetas/acercadeadmin";
	}
	
	@GetMapping("/contactoadmin")
	public String contactoadmin() {
		return "camisetas/contactoadmin";
	}
	
	@GetMapping("/comprado")
	public String comprado() {
		return "camisetas/comprado";
	}
	
	
	
	@PostMapping("/submit")
	public String guardar(@RequestParam(name = "file" , required = false) MultipartFile image, @ModelAttribute CamisetaVO camiseta, RedirectAttributes flash, Model modelo)
	{
		if(!image.isEmpty()) {
			String ruta= "C:\\Users\\yagof\\Desktop\\ProyectoCamisetasFutbol\\yago\\images";
			
			try {
				byte[] bytes= image.getBytes();
				Path rutaAbsoluta= Paths.get(ruta + "//" + image.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				camiseta.setImage("http://localhost:8080/CamisetasFutbol/" + image.getOriginalFilename());
			}catch (Exception e) {
				
			}
			
			cd.save(camiseta);
			modelo.addAttribute("camisetas", cd.findAll());
			flash.addFlashAttribute("success", "Foto subida!!");
		}
		
		return "camisetas/admin";
		
	}

}
