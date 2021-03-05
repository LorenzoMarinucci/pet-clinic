package petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petclinic.services.VetService;

@Controller
@RequestMapping({ "/vets", "/vets/ ", "/vets/index", "/vets/index.html" })
public class VetController {

	private final VetService vetService;

	@Autowired
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping
	public String listVets(Model model) {

		model.addAttribute("vets", vetService.findAll());

		return "vets/index";
	}

}
