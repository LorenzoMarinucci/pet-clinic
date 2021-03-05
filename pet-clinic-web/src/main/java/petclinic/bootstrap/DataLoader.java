package petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import petclinic.model.Owner;
import petclinic.model.Vet;
import petclinic.services.OwnerService;
import petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");

		ownerService.save(owner2);

		System.out.println("Loaded owners...");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		;

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Elizabeth");
		vet2.setLastName("Westmore");
		;

		vetService.save(vet2);

		System.out.println("Loaded vets...");

	}

}
