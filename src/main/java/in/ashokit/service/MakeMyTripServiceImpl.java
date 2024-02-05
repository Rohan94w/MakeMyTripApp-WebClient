package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import reactor.core.publisher.Mono;

@Service
public class MakeMyTripServiceImpl {

	public Mono<Ticket> bookTicket(Passenger p) {
		
		String apiUrl = "http://3.27.167.200:8080/ticket";
		
		WebClient webclient = WebClient.create();
		
		Mono<Ticket> bodyToMono = webclient
									.post()
									.uri(apiUrl)
									.body(BodyInserters.fromValue(p))
									.retrieve()
									.bodyToMono(Ticket.class);
		
		return bodyToMono;
	}
	
	public Mono<Ticket[]> getAllTickets(){
		
		String apiUrl = "http://3.27.167.200:8080/getTickets";
		
		WebClient webClient = WebClient.create();
		
		Mono<Ticket[]> bodyToMono = webClient
									.get()
									.uri(apiUrl)
									.retrieve()
									.bodyToMono(Ticket[].class);
		return bodyToMono;
	}
}
