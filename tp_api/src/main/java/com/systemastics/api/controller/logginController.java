package com.systemastics.api.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.systemastics.api.models.Authority;
import com.systemastics.api.models.Direccion;
import com.systemastics.api.models.Servicio;
import com.systemastics.api.models.UserPlus;
import com.systemastics.api.models.Usuario;
import com.systemastics.api.services.IAutoridadService;
import com.systemastics.api.services.IDireccionService;
import com.systemastics.api.services.IServicioService;
import com.systemastics.api.services.IUploadFileService;
import com.systemastics.api.services.IUserPlusService;
import com.systemastics.api.services.IUsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.checkout.Session;
import com.stripe.param.AccountCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@Controller
public class logginController {
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IUserPlusService userpService;
	@Autowired
	private IDireccionService direccionService;
	@Autowired
	private IServicioService servicioService;
	@Autowired
	private IAutoridadService autoridadService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private IUploadFileService uploadFileService;
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@GetMapping ("/signupUT")
	public String signupUT(Model model) {
		List<Servicio> servicios = new ArrayList<Servicio>();
		
		servicios = servicioService.findAll();
		
		model.addAttribute("servicios",servicios);
		return "porto/pages-signupUT";}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Usuario usuario,@RequestParam("datebirth2") String datebirth2) throws ParseException {		
		Date dtf = new Date();				
		Date datebirth=new SimpleDateFormat("yyyy/mm/dd").parse(datebirth2);
		Authority auth2 = new Authority();
		auth2 = autoridadService.findOne((long)1);
		usuario.setAuthority(auth2);
		usuario.setEnabled(false);
		usuario.setInfo("{\"user_foto\":false,\"user_info\":false,\"pet_info\":false,\"pet_vacuna\":false,\"progreso\":0}");
		usuario.setCreatdate(dtf);
		usuario.setDatebirth(datebirth);		
		String bcryptPassword = passwordEncoder.encode(usuario.getContrasena());
		usuario.setContrasena(bcryptPassword);
		usuarioService.save(usuario);		

		return "redirect:loggin";
	}
	
	@RequestMapping(value = "/signupUT", method = RequestMethod.POST)
	public String signupUTPost(
			Usuario usuario,
			@RequestParam("calle") String calle,
			@RequestParam("numero_int") String numero_int,
			@RequestParam("numero_ext") String numero_ext,
			@RequestParam("colonia") String colonia,
			@RequestParam("estado") String estado,
			@RequestParam("ciudad") String ciudad,
			@RequestParam("postcode") String postcode,
			@RequestParam("nombre_empresa") String nombre_empresa,
			@RequestParam("datebirth2") String datebirth2,
			@RequestParam("listaService") ArrayList<Servicio> servicios,
			@RequestParam("file") MultipartFile foto,
			@RequestParam("file2") MultipartFile ine,
			@RequestParam("correo") String email) throws ParseException {	
		
		UserPlus userp = new UserPlus();
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setCiudad(ciudad);
		direccion.setAlcaldia(colonia);
		direccion.setEstado(estado);
		direccion.setNumero_ext(numero_ext);
		direccion.setNumero_int(numero_int);
		
		
		userp.setNombre_empresa(nombre_empresa);
		
		
		for(Servicio s:servicios) {			
			userp.addservice(s);			
		}
		
		Date dtf = new Date();				
		Date datebirth=new SimpleDateFormat("yyyy/mm/dd").parse(datebirth2);
		Authority auth2 = new Authority();
		auth2 = autoridadService.findOne((long)2);
		userp.setIne("");
		usuario.setAuthority(auth2);
		usuario.setEnabled(false);
		usuario.setInfo("{\"user_foto\":true,\"user_info\":true,\"serv_info\":false,\"product_ini\":0,\"progreso\":75}");
		usuario.setCreatdate(dtf);
		usuario.setDatebirth(datebirth);		
		usuario.setCorreo(email);
		String bcryptPassword = passwordEncoder.encode(usuario.getContrasena());
		usuario.setContrasena(bcryptPassword);
		userp.setUsuario(usuario);
		direccion.setUsuarios(usuario);
		usuario.setUsuarioplus(userp);
		
		if (!foto.isEmpty()) {
			String nombreUnico = null;						
				try {
					nombreUnico = uploadFileService.copy(foto,"U");
					usuario.setFoto(nombreUnico);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
		}
		
		if (!ine.isEmpty()) {
			String nombreUnico = null;						
				try {
					nombreUnico = uploadFileService.copy(ine,"IO");
					userp.setIne(nombreUnico);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
		}
		
		
		Stripe.apiKey = "sk_test_51LjVTWLxwDxyaavTJtWrWJKT2lKPWT1374eKMVEiWNoh0xC7cQ97FLFCYfkcqwghlyFcrMmA0XIhswZJh6oCDbOn00u7GH532k";	
		
		Map<String, Object> cardPayments =new HashMap<>();		
		Map<String, Object> transfers = new HashMap<>();		
		Map<String, Object> capabilities = new HashMap<>();
		Map<String, Object> params = new HashMap<>();
		
		cardPayments.put("requested", true);
		transfers.put("requested", true);
		capabilities.put("card_payments", cardPayments);
		capabilities.put("transfers", transfers);				
		params.put("type", "Standard");
		params.put("country", "MX");
		params.put("email", usuario.getCorreo());
		params.put("capabilities", capabilities);
		
		try {
			Account account = Account.create(params);
			userp.setStripe_id(account.getId());
			System.out.println(account);
			usuarioService.save(usuario);	
			userpService.save(userp);
			direccionService.save(direccion);
			
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			

		return "redirect:loggin";
	}
	
	
	@GetMapping("/login-error")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "/porto/pages-signin";
	  }

}
