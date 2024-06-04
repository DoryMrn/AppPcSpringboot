package com.example.demo;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.ui.Model;

@Controller
public class MyController {
	
	@Autowired
    private EmailService emailService;

	private final pcJDBCTemp pcJDBCTemp;
	
	private final pcOrdJDBCTemp pcOrdJDBCTemp;

	
    @Autowired
    public MyController(pcJDBCTemp pcJDBCTemp, pcOrdJDBCTemp pcOrdJDBCTemp) {
        this.pcJDBCTemp = pcJDBCTemp;
        this.pcOrdJDBCTemp = pcOrdJDBCTemp;
    }

	 
	 @GetMapping("/")
	 public String getOrologioForm(){
		
		 return "formMagazzino";
		 
	 }

	 
	 @GetMapping("/getPc")
	 public String getAll(Model model){
		
		 ArrayList <computer> lista = pcJDBCTemp.ritornaPc();
		 model.addAttribute("lista", lista);
		 
		 return "listaPc";
		 
	 }
	 
	 
	 @PostMapping("/AddPc")
	 public String addPc(@RequestParam("marca") String marca, @RequestParam("tipologia") String tipologia, @RequestParam("modello") String modello, @RequestParam("descrizione") String descrizione, @RequestParam("qnt") String qnt, @RequestParam("url") String url, @RequestParam("prezzo") String prezzo, Model model) {
		 
		 String [] ImgUrl = url.split("\"");
			
			String urlImage = ImgUrl[3];
		 
		 computer o1 = new computer();
		 o1.setMarca(marca);
		 o1.setTipologia(tipologia);
		 o1.setModello(modello);
		 o1.setDescrizione(descrizione);
		 o1.setQnt(Integer.parseInt(qnt));
		 o1.setUrl(urlImage);
		 o1.setPrezzo(Double.parseDouble(prezzo));
		 System.out.println(o1.url);
		 model.addAttribute("computer", o1);
		 pcJDBCTemp.insertPc(marca, tipologia, modello, descrizione, Integer.parseInt(qnt), urlImage, Double.parseDouble(prezzo));
		 return "AddPc";
		 
	 }
	 
	 
	 @GetMapping("/change")
	 public String change(Model model) {
		 
		 ArrayList <computer> lista = pcJDBCTemp.ritornaPc();
		 model.addAttribute("lista", lista);
		 
		 return "change";
	 }
	 
	 
	 
	 
	 
	
/*	 @PostMapping("/changeP")
	 public ResponseEntity<String> addWatch(@RequestParam("pc") String [] ordini,@RequestParam("pezzi") String [] pezzi,Model model){
 
		 ArrayList<Integer> pc = new ArrayList<>();
		 ArrayList<Integer> qnt = new ArrayList <>();
 
		 for (String s: pezzi) {
			 if (!s.isEmpty()) {
			int x = Integer.parseInt(s);
			qnt.add(x);
		 }}
		 
		 for (String s: ordini) {
			 if (!s.isEmpty()) {
			int x = Integer.parseInt(s);
			pc.add(x);
		 }}
		 
		 for (int i = 0; i < qnt.size(); i++) {
			 
			 pcJDBCTemp.updatePezzi(qnt.get(i), pc.get(i));
		 }
 
		 return ResponseEntity.ok("Articoli aggiornati con successo");
	 }*/
	
	 @PostMapping("/buyPc")
	 public String buyPC(@RequestParam("ordini") String [] ordini,@RequestParam("pezzi") String [] pezzi,Model model){
 
		 ArrayList <computer> lista = pcJDBCTemp.ritornaPc();
		 ArrayList<Integer> qnt = new ArrayList <>();
		 ArrayList<pcOrd> pc = new ArrayList <>();
 
		 for (String s: pezzi) {
			 if (!s.isEmpty()) {
			int x = Integer.parseInt(s);
			qnt.add(x);
		 }}
		 double prezzo = 0;
		 
		 
		
 
 
			 for (int j = 0; j < ordini.length; j++) {
				 for (int i = 0; i < lista.size(); i++) {
				 if (lista.get(i).id == (Integer.parseInt(ordini[j]))) {
					 
					 pcJDBCTemp.updatePezzi2(qnt.get(j), lista.get(i).id);
					 
					 prezzo += lista.get(i).getPrezzo() * qnt.get(j);
					 pcOrd computer = new pcOrd();
					 computer.setModello(lista.get(i).getModello());
					 computer.setQnt(qnt.get(j));
					 pc.add(computer);
					 
				 }
 
			 }
		 }

 
			 System.out.println(prezzo);
			 model.addAttribute("lista", pc);
			 
			 model.addAttribute("prezzo", prezzo);
 
 
 
		 return "conferma";
	 }
	
	 
	 @PostMapping("/confPc")
	 public ResponseEntity<String> pcMail(@RequestParam("modello") String [] ordini,@RequestParam("qnt") String [] pezzi, @RequestParam("prezzo") String prezzo, @RequestParam("email") String email,Model model){
 
		 
		 ArrayList <computer> lista = pcJDBCTemp.ritornaPc();
		 ArrayList<Integer> qnt = new ArrayList <>();
		 ArrayList<pcOrd> pc = new ArrayList <>();
 
		 for (String s: pezzi) {
			 if (!s.isEmpty()) {
			int x = Integer.parseInt(s);
			qnt.add(x);
		 }}
		
		 
		 
		
 
 
			 for (int j = 0; j < ordini.length; j++) {
				 for (int i = 0; i < lista.size(); i++) {
				 if (lista.get(i).getModello().equals(ordini[j])) {
					 
					
					 
					
					 pcOrd computer = new pcOrd();
					 computer.setModello(lista.get(i).getModello());
					 computer.setQnt(qnt.get(j));
					 pc.add(computer);
					 
				 }
 
			 }
		 }
		
		//aggiungere pezzi dei prodotti della tabella pcord	 
		for (pcOrd comp : pc) {
		pcOrdJDBCTemp.updatePezzi(comp.getQnt(), comp.getModello());}
			 
			 
		 String to = email;
		 String subject = "Ordine confermato";
		 String text = "";
		 for(pcOrd comp : pc) {
			 text+="Hai acquistato: \n";
			 text+= "Modello: " + comp.getModello() + "\n";
			 text+="Quantità: " + comp.getQnt()+ "\n";
		 }
		 text+= "il totale da pagare è " + prezzo + " euro";
		 
		 emailService.sendSimpleEmail(to, subject, text);
	     return ResponseEntity.ok("Email inviata con successo. Grazie dell'acquisto.");
		 
	 
	 }
	 
	 
	 
	 
	
	 @GetMapping("/formEmail")
		public String formEmail(){
			
			return "formEmail";
		}
		
		
	    @PostMapping("sendEmail")
	    public ResponseEntity<String> sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("text") String text) {
	        emailService.sendSimpleEmail(to, subject, text);
	        return ResponseEntity.ok("Email sent successfully");
	    }
	    
	    
	    
	    @GetMapping("/showPcOrders")
	    public String showPcOrders(Model model) {
	        ArrayList<pcOrd> pcOrders = new ArrayList<>();
	        pcOrders = pcOrdJDBCTemp.ritornaOrdPc();
	        
	        // Convertiamo la lista in una stringa JSON
	        ObjectMapper objectMapper = new ObjectMapper();
	        String pcOrdersJson = "";
	    	try {
				pcOrdersJson = objectMapper.writeValueAsString(pcOrders);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       

	        // Passiamo la stringa JSON al modello
	        model.addAttribute("pcOrdersJson", pcOrdersJson);
	        
	        model.addAttribute("pcOrders", pcOrders);
	        return "pcOrders";
	    }
	    
	    
	    
	    
	    
	}

	
	
	

