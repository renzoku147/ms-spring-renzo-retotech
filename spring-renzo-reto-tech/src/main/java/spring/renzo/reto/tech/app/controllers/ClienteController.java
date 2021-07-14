package spring.renzo.reto.tech.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.renzo.reto.tech.app.models.ClienteDTO;
import spring.renzo.reto.tech.app.models.ObjectoRespuesta;
import spring.renzo.reto.tech.app.repositories.ClienteDAO;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteDAO repository;
	
	@PostMapping("/creacliente")
	public ClienteDTO create(@Validated @RequestBody ClienteDTO c) {
		return repository.insert(c);
	}
	
	@GetMapping("/cliente")
	public List<ClienteDTO> readAll(){
		return repository.findAll();
	}
	
	@GetMapping("/kpideclientes")
	public ObjectoRespuesta readAllCustomEdad(){
		List<ClienteDTO> list = repository.findAll();
		
		ObjectoRespuesta resp =  new ObjectoRespuesta();
		
		// Promedio de edades
		resp.setPromedio(list.stream()
							.mapToInt(cliente -> cliente.getEdad())
							.average()
							.getAsDouble()); 
		
		// Desviacion estandar de las edades
		resp.setDeviacion(calcularDesviacionEstandar(list.stream()
														.map(cliente -> cliente.getEdad())
														.collect(Collectors.toList()))
													);
		
		return resp;
	}
	
	@GetMapping("/listclientes")
	public List<ClienteDTO> readAllCustomFechaMuerte(){
		return repository.findAll();
	}
	
	public static double calcularDesviacionEstandar(List<Integer> numArray)
    {
        double sum = 0.0, desviacionEstandar = 0.0;
        int length = numArray.size();

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
        	desviacionEstandar += Math.pow(num - mean, 2);
        }

        return Math.sqrt(desviacionEstandar/length);
    }
}
