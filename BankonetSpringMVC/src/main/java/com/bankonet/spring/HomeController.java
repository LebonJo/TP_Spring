package com.bankonet.spring;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IClientService;
import com.bankonet.model.Client;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IClientService clientService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		
		List<Client> clients = clientService.listClients();

		model.addAttribute("clients", clients);
		model.addAttribute("newClient", new Client());
		model.addAttribute("actionPerformed", "none");
		model.addAttribute("idClient", 0);
		
		return "home";
	}
	
	@RequestMapping(value="/addClient")
	public String addClient(@ModelAttribute("newClient") @Valid Client newClient, BindingResult result, Model model) throws Exception{
		
		if(result.hasErrors()){
			model.addAttribute("clients", clientService.listClients());
			model.addAttribute("newClient", newClient);
			model.addAttribute("actionPerformed", "none");
			return "home";
		} else {
			if(newClient.getId()==0){
				clientService.addClient(newClient);
				List<Client> clients = clientService.listClients();
				model.addAttribute("actionPerformed", "added");
				model.addAttribute("clients", clients);
				model.addAttribute("idClient", clients.get(clients.size()-1).getId());
			} else {
				clientService.updateClient(newClient);
				model.addAttribute("actionPerformed", "updated");
				model.addAttribute("clients", clientService.listClients());
				model.addAttribute("idClient", newClient.getId());
			}
			
			model.addAttribute("newClient", new Client());
			return "home";
		}
		
		
		
	}
	
	@RequestMapping(value="/deleteClient/")
	public String deleteClient(@RequestParam int idClient, Model model){
		
		clientService.deleteClient(idClient);
		
		model.addAttribute("newClient", new Client());
		model.addAttribute("clients", clientService.listClients());
		model.addAttribute("actionPerformed", "deleted");
		model.addAttribute("idClient", idClient);
		
		return "home";
	}
	
	@RequestMapping(value="editClient/{idClient}")
	public String editClient(@PathVariable int idClient, Model model){
		
		Client client = clientService.editClient(idClient);
		model.addAttribute("newClient", client);
		model.addAttribute("clients", clientService.listClients());
		model.addAttribute("actionPerformed", "none");
		model.addAttribute("idClient", idClient);
		
		return "home";
	}
}
